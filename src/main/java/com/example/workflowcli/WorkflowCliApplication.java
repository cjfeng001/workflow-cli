package com.example.workflowcli;

import com.example.workflowcli.workflow.config.AppDispatcherServletConfiguration;
import com.example.workflowcli.workflow.config.ApplicationConfiguration;
import org.flowable.ui.modeler.conf.DatabaseConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(value = {
        //因为引入conf,需自行引入DatabaseConfiguration,否则将导致500异常
        DatabaseConfiguration.class,
        //引入修改后的配置
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
@SpringBootApplication(exclude = {
        //移除Security登录验证
        SecurityAutoConfiguration.class,
        ManagementWebSecurityAutoConfiguration.class
})
@MapperScan("com.example.workflowcli.*.mapper")
public class WorkflowCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowCliApplication.class, args);
    }

}
