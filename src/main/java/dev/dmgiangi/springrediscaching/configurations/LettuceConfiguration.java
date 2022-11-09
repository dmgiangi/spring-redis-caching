package dev.dmgiangi.springrediscaching.configurations;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Setter
public class LettuceConfiguration {
    private String host;
    private String password;

    private int database;

    @Bean
    @Primary
    public RedisConnectionFactory redisConnectionFactory(RedisConfiguration defaultRedisConfig) {
        LettuceClientConfiguration clientConfig =
                LettuceClientConfiguration.builder()
                        .build();
        return new LettuceConnectionFactory(defaultRedisConfig, clientConfig);
    }

    @Bean
    public RedisConfiguration defaultRedisConfig() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setDatabase(database);
        System.out.println(database);
        config.setHostName(host);
        config.setPassword(RedisPassword.of(password));
        return config;
    }
}
