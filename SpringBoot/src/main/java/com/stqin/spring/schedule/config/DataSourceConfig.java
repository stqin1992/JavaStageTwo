package com.stqin.spring.schedule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSourceTest")
    @ConfigurationProperties(prefix = "spring.datasource-test")
    public DataSource dataSourceTest() {
        return DataSourceBuilder.create().build();
    }
}
