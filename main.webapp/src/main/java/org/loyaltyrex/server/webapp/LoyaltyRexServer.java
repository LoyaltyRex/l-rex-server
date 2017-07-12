package org.loyaltyrex.server.webapp;

import org.loyaltyrex.server.webapp.config.MainWebappConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * The main class, for launching the LoyaltyRex server web application
 * 
 * @author nickavv
 * @since 0.1.0
 */
@SpringBootApplication
@Import({ MainWebappConfiguration.class })
public class LoyaltyRexServer {

    public static void main(String[] args) {
        SpringApplication.run(LoyaltyRexServer.class, args);
    }

}
