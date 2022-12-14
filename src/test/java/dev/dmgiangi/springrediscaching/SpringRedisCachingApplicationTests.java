package dev.dmgiangi.springrediscaching;

import dev.dmgiangi.springrediscaching.controllers.ScanContextController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringRedisCachingApplicationTests {
    @Autowired
    ScanContextController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
