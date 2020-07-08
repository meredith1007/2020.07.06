package cn.bywin.bywinTest;

import cn.bywin.common.utils.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Hurricane
 * @Date 2018/7/17 0017
 */

@Profile({"dev"})
@EnableSwagger2
@Configuration
public class Swagger2 {

    private static Map<String, String> model2TableMap = new HashMap<>();

    static {
        model2TableMap.put("ClassInfo", "class_info");
        model2TableMap.put("StudentInfo", "student_info");
        model2TableMap.put("StudentScore", "student_score");
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.bywin.bywinTest.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Map<String,Object> desc = new HashMap<>();
        desc.put("controllerPath", "cn.bywin.bywinTest.controller");
        desc.put("model2Table", model2TableMap);
        return new ApiInfoBuilder()
                .title("API数据接口文档")
                .description(JsonUtil.toJson(desc))
                //这里写项目名称
                .termsOfServiceUrl("2020.07.06")
                .version("1.0")
                .build();
    }

}