package net.xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description 旭瑶&小滴课堂 xdclass.net
 * 什么是注册中心（服务治理）
 * 服务注册：服务提供者provider，启动的时候向注册中心上报自己的网络信息
 * 服务发现：服务消费者consumer,启动的时候向注册中心上报自己的网络信息，拉取provider的相关网络信息
 * 核心:服务管理,是有个服务注册表，心跳机制动态维护，服务实例在启动时注册到服务注册表，并在关闭时注销。
 * @Author 二当家小D  代码、笔记和技术指导联系我即可
 * @Version 1.0
 **/

@SpringBootApplication
@MapperScan("net.xdclass.dao")
@EnableDiscoveryClient
public class VideoApplication {

    public static void main(String [] args){

        SpringApplication.run(VideoApplication.class,args);
    }


}
