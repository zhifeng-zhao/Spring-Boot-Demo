package com.zzf.demoactuator.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @author zzf
 * @date 2021/3/4 10:15 上午
 */
@Component
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    @ReadOperation
    private String custom() {
        return "custom";
    }
}
