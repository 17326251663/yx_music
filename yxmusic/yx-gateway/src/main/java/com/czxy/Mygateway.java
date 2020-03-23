package com.czxy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class Mygateway {
    public static void main(String[] args) {
        SpringApplication.run(Mygateway.class,args);
    }

}
