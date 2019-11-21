package com.example.workflowcli.common.config;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileReader;
import java.io.IOException;

/**
 * Create Time: 2019/10/1 12:22
 * Description: Swagger可视化API配置
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() throws IOException, XmlPullParserException {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns.modular.system.controller"))     //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() throws IOException, XmlPullParserException {
        MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
        Model model = mavenXpp3Reader.read(new FileReader("pom.xml"));
        return new ApiInfoBuilder()
                .title("MMF API") // 页面标题
                .description("Multi-ModulesFrame API文档") // 描述
//                .termsOfServiceUrl("https://baidu.com")
                .contact(new Contact("Eden Carolus", "https://gogs.analyticservice.net/shawsail.xiao/Multi-Modules-Frame", "ShawSail.Xaio@analyticservice.net")) // 创建人
                .version("1.0") // 版本号
                .version(model.getVersion())
                .build();
    }

}