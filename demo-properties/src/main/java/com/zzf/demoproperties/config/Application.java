package com.zzf.demoproperties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zzf
 * @date 2021/3/3 3:43 下午
 */
@Data
@Component
@ConfigurationProperties(prefix = "application")
public class Application {

    private String name;

    private String version;
}
