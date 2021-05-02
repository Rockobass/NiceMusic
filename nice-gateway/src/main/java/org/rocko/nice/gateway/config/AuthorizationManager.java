package org.rocko.nice.gateway.config;

import org.rocko.nice.common.utils.TypeConverter;
import org.rocko.nice.gateway.constant.AuthConstant;
import org.rocko.nice.gateway.constant.RedisConstant;
import org.rocko.nice.gateway.mybatis.mapper.Path2roleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 * Created by macro on 2020/6/19.
 */
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    Path2roleMapper path2roleMapper;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        //从Redis中获取当前路径可访问角色列表
        URI uri = authorizationContext.getExchange().getRequest().getURI();
        String path = uri.getPath();
        String pathPattern = "";

        List<Object> paths = redisTemplate.opsForList().range("path",0,-1);
        PathMatcher pathMatcher = new AntPathMatcher();
        for (Object p : paths) {
            if (pathMatcher.match(p.toString(), path)) {
                pathPattern = p.toString();
                break;
            }
        }
        Object obj = redisTemplate.opsForHash().get(RedisConstant.RESOURCE_ROLES_MAP, pathPattern);
        List<String> authorities;
        try {
            authorities = TypeConverter.ObjectToListStr(obj);
        }catch (NullPointerException e) {
            authorities = new ArrayList<>();
        }

        authorities = authorities.stream().map(i -> i = AuthConstant.AUTHORITY_PREFIX + i).collect(Collectors.toList());
        //认证通过且角色匹配的用户可访问当前路径
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }

}
