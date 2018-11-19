package com.example.liangl.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;


/**
 * Created by cpekl-ddim-2 on 11/16/18.
 */

@Configuration
@EnableMongoRepositories(basePackages = "com.example.liangl")
public class MongoConfig extends AbstractMongoConfiguration{

    @Autowired
    private Environment env;

    @Override
    public MongoClient mongoClient() {

        MongoCredential credential = MongoCredential.createCredential(env.getProperty("mongo.username"),
                "OrdersDB", env.getProperty("mongo.password").toCharArray());
        return new MongoClient(new ServerAddress("localhost", 37017), Arrays.asList(credential));
    }

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }
}
