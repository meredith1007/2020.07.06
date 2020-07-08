package cn.bywin.bywinTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan("cn.bywin.*.dao")
@SpringBootApplication(scanBasePackages = "cn.bywin")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }
}