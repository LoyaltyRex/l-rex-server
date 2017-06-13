package org.loyaltyrex.server.test.repository;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * A base test class for testing PostgreSQL repositories. Uses the test configuration class to populate the Spring
 * context
 * 
 * @author nickavv
 * @since 0.1.0
 */
@ContextConfiguration(classes = { PgRepositoryTestConfiguration.class })
public class PgRepositoryBaseTest extends AbstractTestNGSpringContextTests {

}
