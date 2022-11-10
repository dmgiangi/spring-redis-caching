package dev.dmgiangi.springrediscaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringRedisCachingApplication class.
 *
 * @author Gianluigi De Marco
 */
@SpringBootApplication
public class SpringRedisCachingApplication {

    /**
     * Spring entrypoint.
     *
     * @param args an array of {@link java.lang.String} objects
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCachingApplication.class, args);
    }

}
