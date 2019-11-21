package com.example.workflowcli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.example.workflowcli.*.mapper")
public class WorkflowCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowCliApplication.class, args);
    }

}
