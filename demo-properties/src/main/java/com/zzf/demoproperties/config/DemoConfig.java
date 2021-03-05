package com.zzf.demoproperties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zzf
 * @date 2021/3/3 10:34 上午
 */
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class DemoConfig {
    private String name;

    private Integer age;
}
