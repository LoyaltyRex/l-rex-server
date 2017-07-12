package org.loyaltyrex.server.test.core.persistence;

import org.loyaltyrex.server.core.persistence.config.PgRepositoryConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration for the PostgreSQL repository implementation tests.
 * 
 * @author nickavv
 * @since 0.1.0
 */
@Configuration
@Import({ PgRepositoryConfiguration.class })
@PropertySource(name = "test-application.properties", value = {
        "classpath:/test-application.properties"
})
public class RepositoryTestConfiguration {

}
