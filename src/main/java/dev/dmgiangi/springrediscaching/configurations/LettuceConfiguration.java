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

/**
 * LettuceConfiguration class.
 *
 * @author Gianluigi De Marco
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Setter
public class LettuceConfiguration {
    private String host;
    private String password;

    private int database;

    /**
     * redisConnectionFactory.
     *
     * @param defaultRedisConfig a {@link org.springframework.data.redis.connection.RedisConfiguration} object
     * @return a {@link org.springframework.data.redis.connection.RedisConnectionFactory} object
     */
    @Bean
    @Primary
    public RedisConnectionFactory redisConnectionFactory(RedisConfiguration defaultRedisConfig) {
        LettuceClientConfiguration clientConfig =
                LettuceClientConfiguration.builder()
                        .build();
        return new LettuceConnectionFactory(defaultRedisConfig, clientConfig);
    }

    /**
     * defaultRedisConfig.
     *
     * @return a {@link org.springframework.data.redis.connection.RedisConfiguration} object
     */
    @Bean
    public RedisConfiguration defaultRedisConfig() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setDatabase(database);
        config.setHostName(host);
        config.setPassword(RedisPassword.of(password));
        return config;
    }
}
