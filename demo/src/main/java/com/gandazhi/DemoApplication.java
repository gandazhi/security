package com.gandazhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gandazhi
 * @create 2017-12-16 下午9:03
 **/
@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
