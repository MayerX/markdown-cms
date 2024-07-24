package org.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.common.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(defaultValue = "主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @Schema(defaultValue = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @Schema(defaultValue = "更新时间")
    private Date updateTime;

    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(defaultValue = "创建人ID")
    private Long createUser;

    @JsonSerialize(using = ToStringSerializer.class)
    @Schema(defaultValue = "更新人ID")
    private Long updateUser;

}
