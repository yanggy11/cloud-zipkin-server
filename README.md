# cloud-zipkin-server
spring cloud 链路监控

引入maven依赖
```
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Dalston.SR4</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
        </dependency>

        <dependency>
            <groupId>io.zipkin.java</groupId>
            <artifactId>zipkin-autoconfigure-ui</artifactId>
        </dependency>
    </dependencies>
```
application.yml 添加配置
```
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8000/eureka/
server:
  port: 9411
spring:
  application:
    name: zipkin-server
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: derrick
```
启动类加入注解 
```
@EnableZipkinStreamServer //开启链路监控
@SpringBootApplication
@EnableDiscoveryClient //服务注册到注册中心
public class SleuthServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApp.class, args);
    }
}
```

启动项目， 浏览器中输入 localhost:9411 查看链路信息
