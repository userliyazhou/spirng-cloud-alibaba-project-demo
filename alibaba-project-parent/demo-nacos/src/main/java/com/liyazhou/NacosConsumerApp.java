package com.liyazhou;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(NacosConsumerApp.class, args);

        ConfigurableEnvironment runEnvironment = run.getEnvironment();
        MutablePropertySources propertySources = runEnvironment.getPropertySources();
        String property = runEnvironment.getProperty("server.port");
        String property1 = runEnvironment.getProperty("local.server.port");
    }
}