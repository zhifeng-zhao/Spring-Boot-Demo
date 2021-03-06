package com.zzf.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoLogbackApplicationTests {


	@Test
	void contextLoads() {
		MDC.put("id","1");
		log.info("info 日志");
	}

}
