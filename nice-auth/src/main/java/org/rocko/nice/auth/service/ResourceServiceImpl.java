package org.rocko.nice.auth.service;
import org.rocko.nice.auth.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        String[] ROLES_rocko = new String[]{"admin", "common"};
        String[] ROLES_baby = new String[]{"common"};
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/test/2", Arrays.asList(ROLES_baby));
        resourceRolesMap.put("/test/**", Arrays.asList(ROLES_rocko));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
        redisTemplate.opsForList().leftPushAll("path","/test/2","/test/**");
    }
}
