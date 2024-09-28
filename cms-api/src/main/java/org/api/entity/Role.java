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
@TableName("base_role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity implements Serializable {

    //<column name="name" type="varchar(64)" remarks="用户名称" />
    //<column name="display_name" type="varchar(128)" remarks="显示用户名称" />
    //<column name="level" type="bigint" remarks="角色等级" />
    //<column name="remark" type="varchar(128)" remarks="备注" />

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String displayName;

    private Integer level;

    private String remark;

}
