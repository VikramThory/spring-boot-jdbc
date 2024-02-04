package com.vikram.singh.springbootjdbc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceConfiguration {

    private final String dbUrl;

    private final String dbUsername;

    private final String dbPassword;

    private final String driverClassName;

    private final long connectionTimeout;

    private final int minimumIdle;

    private final int maximumPoolSize;

    private final long idleTimeout;

    private final long maxLifetime;

    private final boolean autoCommit;

    private final boolean isolateInternalQueries;

    private final String poolName;

    public DataSourceConfiguration(@Value( "${jdbc-app.datasource.readWrite.url}" ) String dbUrl,
                                   @Value( "${jdbc-app.datasource.readWrite.username}" ) String dbUsername,
                                   @Value( "${jdbc-app.datasource.readWrite.password}" ) String dbPassword,
                                   @Value( "${spring.datasource.driver-class-name}" ) String driverClassName,
                                   @Value( "${spring.datasource.hikari.connection-timeout}" ) long connectionTimeout,
                                   @Value( "${spring.datasource.hikari.minimum-idle}" ) int minimumIdle,
                                   @Value( "${spring.datasource.hikari.maximum-pool-size}" ) int maximumPoolSize,
                                   @Value( "${spring.datasource.hikari.idle-timeout}" ) long idleTimeout,
                                   @Value( "${spring.datasource.hikari.max-lifetime}" ) long maxLifetime,
                                   @Value( "${spring.datasource.hikari.auto-commit}" ) boolean autoCommit,
                                   @Value( "${spring.datasource.hikari.isolate-internal-queries}" ) boolean isolateInternalQueries,
                                   @Value( "${spring.datasource.hikari.pool-name}" ) String poolName) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.driverClassName = driverClassName;
        this.connectionTimeout = connectionTimeout;
        this.minimumIdle = minimumIdle;
        this.maximumPoolSize = maximumPoolSize;
        this.idleTimeout = idleTimeout;
        this.maxLifetime = maxLifetime;
        this.autoCommit = autoCommit;
        this.isolateInternalQueries = isolateInternalQueries;
        this.poolName = poolName;
    }

    @Primary
    @Bean
    DataSource datasource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUsername);
        config.setPassword(dbPassword);
        commonDatasourceConfiguration(config);
        return new HikariDataSource(config);
    }

    private void commonDatasourceConfiguration(HikariConfig config) {
        config.setDriverClassName(driverClassName);
        config.setConnectionTimeout(connectionTimeout);
        config.setMinimumIdle(minimumIdle);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setIdleTimeout(idleTimeout);
        config.setMaxLifetime(maxLifetime);
        config.setAutoCommit(autoCommit);
        config.setIsolateInternalQueries(isolateInternalQueries);
        config.setPoolName(poolName);
    }
}
