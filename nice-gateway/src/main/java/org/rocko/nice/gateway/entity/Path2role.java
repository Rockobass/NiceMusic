package org.rocko.nice.gateway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-05-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Path2role implements Serializable {

    private static final long serialVersionUID=1L;

    private String path;

    private String role;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
