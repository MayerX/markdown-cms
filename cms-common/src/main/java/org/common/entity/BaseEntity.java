package org.common.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {

//    @JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty("主键id")
//    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

}
