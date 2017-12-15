package com.yanggy.cloud.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * Created by derrick.yang on 12/15/17.
 */

@EnableZipkinStreamServer
@SpringBootApplication
@EnableDiscoveryClient
public class SleuthServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApp.class, args);
    }
}
