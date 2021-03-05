package com.zzf.demoactuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义HealthIndicator
 * @author zzf
 * @date 2021/3/4 10:09 上午
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.down().build();
    }
}
