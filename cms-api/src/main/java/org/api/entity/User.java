package org.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-06-22 20:03
 */
@Data
@Builder
@AllArgsConstructor
@TableName("base_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {

    private String username;

    private String password;

    private String email;

}
