package org.common.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-09-15 22:30
 */
@Getter
public enum RespCodeEnums {

    SUCCESS(HttpStatus.OK.value(), "Success"),
    FAIL(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Internal Not Found");

    private final int code;

    private final String msg;

    RespCodeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
