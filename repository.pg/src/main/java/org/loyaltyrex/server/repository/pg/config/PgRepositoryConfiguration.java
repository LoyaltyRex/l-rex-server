package org.loyaltyrex.server.repository.pg.config;

import java.io.IOException;
import java.nio.file.FileSystems;

import org.apache.commons.dbcp2.BasicDataSource;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.loyaltyrex.server.domain.repository.api.IBusinessRepository;
import org.loyaltyrex.server.repository.pg.impl.PgBusinessRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coronaide.lockdown.CredentialStore;

/**
 * Spring configuration for the PostgreSQL repository implementations.
 * 
 * @author nickavv
 * @since 0.1.0
 */
@Configuration
public class PgRepositoryConfiguration {

    @Bean
    public BasicDataSource dataSource(@Value("${repository.pg.url}") String jdbcUrl,
            @Value("${repository.pg.maxPoolSize}") int maxPoolSize,
            @Value("${repository.pg.credentialsPath}") String credentialsPath,
            @Value("${lockdown.privateKeyPath}") String privateKeyPath) throws InvalidCipherTextException, IOException {
        BasicDataSource dataSource = new BasicDataSource();
        CredentialStore pgCredentials = CredentialStore.load(FileSystems.getDefault().getPath(credentialsPath));

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setMaxIdle(maxPoolSize);
        dataSource.setMaxTotal(maxPoolSize);
        pgCredentials.accessCredentials(jdbcUrl, FileSystems.getDefault().getPath(privateKeyPath),
                (username, password) -> {
            dataSource.setUsername(username);
            dataSource.setPassword(new String(password));
        });

        return dataSource;
    }

    @Bean
    public IBusinessRepository businessRepository(BasicDataSource dataSource) {
        return new PgBusinessRepository(dataSource);
    }

}
