package com.reboot16.notes.model;

public enum ErrorCode {
    NOT_FOUND("404", "Data Not Found"),
    BAD_REQUEST("400", "Data Not Valid."),
    INTERNAL_SERVER_ERROR("500", "Something wrong with System"),
    OK("200", "OK");

    private String code;
    private String message;
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }
}
