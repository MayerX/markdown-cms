package org.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.common.entity.BaseEntity;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@TableName("base_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String email;

    private Boolean isEnable;

}
