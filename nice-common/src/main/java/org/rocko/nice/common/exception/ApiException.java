package org.rocko.nice.common.exception;

public class ApiException extends Exception{
    private final int code;

    private final String msg;

    public ApiException(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
