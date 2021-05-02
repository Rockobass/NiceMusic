package org.rocko.nice.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NiceResponse {
    private Integer code;

    private String msg;

    private Object data;

    public static NiceResponse build(){
        return new NiceResponse();
    }

    public static NiceResponse ok(String msg) {
        return new NiceResponse(200, msg, null);
    }

    public static NiceResponse ok(String msg, Object data) {
        return new NiceResponse(200, msg, data);
    }

    public static NiceResponse error(String msg) {
        return new NiceResponse(500, msg, null);
    }

    public static NiceResponse error(String msg, Object data) {
        return new NiceResponse(500, msg, data);
    }

    public static NiceResponse forbidden(String msg) {
        return new NiceResponse(403, msg, null);
    }

    public static NiceResponse unauthorized(){
        return new NiceResponse(401, "unauthorized", null);
    }
}
