package org.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.common.entity.BaseEntity;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-06-22 20:03
 */
@Data
@Builder
@TableName("user")
public class User extends BaseEntity {

    private String username;

    private String password;

}
