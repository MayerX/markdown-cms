package org.common.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.common.constant.RespCodeEnums;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-09-15 22:18
 */
@Data
@Slf4j
@Builder
public class ResultEntity<T extends Serializable> {

    // 状态码
    private int code;

    // 返回消息
    private String msg;

    // 返回的数据
    private T data;

    // 默认情况下，@Builder 将自动生成构造函数
    // 你不再需要手动定义构造函数，Lombok 会自动处理
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now(); // 默认值

    @Builder.Default
    private Map<String, Object> extra = new HashMap<>(); // 初始化 extra

    public static <T extends Serializable> ResultEntity<T> success(T data) {
        return ResultEntity.<T>builder()
                .code(RespCodeEnums.SUCCESS.getCode())
                .msg(RespCodeEnums.SUCCESS.getMsg())
                .data(data)
                .build();
    }

    public static <T extends Serializable> ResultEntity<T> success() {
        return ResultEntity.<T>builder()
                .code(RespCodeEnums.SUCCESS.getCode())
                .msg(RespCodeEnums.SUCCESS.getMsg())
                .build();
    }

    public static <T extends Serializable> ResultEntity<T> fail(int code, String msg) {
        log.error("Error code: {}, message: {}", code, msg);
        return ResultEntity.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static <T extends Serializable> ResultEntity<T> fail(int code, String msg, T data) {
        log.error("Error code: {}, message: {}, data: {}", code, msg, data);
        return ResultEntity.<T>builder()
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    // 添加扩展字段
    public ResultEntity<T> addExtra(String key, Object value) {
        this.extra.put(key, value);
        return this;
    }

}
