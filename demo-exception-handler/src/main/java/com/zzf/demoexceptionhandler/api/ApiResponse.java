package com.zzf.demoexceptionhandler.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zzf
 * @date 2021/3/8 10:04 上午
 */
@Data
@AllArgsConstructor
public class  ApiResponse {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public static ApiResponse success(Object data) {
        return new ApiResponse(1,null,data);
    }

    public static ApiResponse fail(String msg,Object data) {
        return new ApiResponse(-1,msg,data);
    }
}
