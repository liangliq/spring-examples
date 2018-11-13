package com.example.liangl.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * Created by cpekl-ddim-2 on 11/12/18.
 */
@Configuration
public class DataSourceConfiguration {

    //default connect to jdbc:h2:mem:testdb
    @Profile("dev")
    @Bean
    public DataSource embeddedDataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql")
                .build();
    }

    @Profile("qa")
    @Bean
    public DataSource Data(){
        BasicDataSource bDs = new BasicDataSource();
        bDs.setDriverClassName("org.h2.Driver");
        bDs.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        bDs.setUsername("sa");
        bDs.setPassword("");
        bDs.setInitialSize(5);
        bDs.setMaxActive(10);
        return bDs;
    }

    @Profile("production")
    @Bean
    public DataSource dataSource(){
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpitterDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource)jndiObjectFactoryBean.getObject();
    }
}
