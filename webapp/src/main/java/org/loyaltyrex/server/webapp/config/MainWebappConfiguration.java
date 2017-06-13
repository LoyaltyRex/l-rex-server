package org.loyaltyrex.server.webapp.config;

import org.loyaltyrex.server.repository.pg.config.PgRepositoryConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PgRepositoryConfiguration.class })
public class MainWebappConfiguration {

}
