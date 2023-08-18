package com.project.board.exception;

import lombok.Getter;

public enum ExceptionCode {

    /* COMMON */
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    ACCESS_FORBIDDEN(403, "ACCESS FORBIDDEN"),
    METHOD_NOT_ALLOWED(405, "METHOD NOT ALLOWED"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL SERVER ERROR"),
    NOT_IMPLEMENTATION(501, "NOT IMPLEMENTATION"),
    INVALID_VALUES(400, "INVALID VALUES"),
    INVALID_DATE(400, "INVALID DATE"),

    /* USER */
    USER_NOT_FOUND(404, "USER NOT FOUND"),
    USER_EXIST(409, "USER EXISTS"),

    /* BOARD */
    BOARD_NOT_FOUND(404, "BOARD NOT FOUND"),
    BOARD_EXIST(409, "BOARD EXISTS");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
