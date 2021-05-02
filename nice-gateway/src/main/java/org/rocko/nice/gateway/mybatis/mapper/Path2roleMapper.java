package org.rocko.nice.gateway.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.rocko.nice.gateway.entity.Path2role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-05-01
 */
public interface Path2roleMapper extends BaseMapper<Path2role> {


    @Override
    List<Path2role> selectList(Wrapper<Path2role> queryWrapper);
}
