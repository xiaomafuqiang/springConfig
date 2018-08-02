package net.htmlonline.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * spring bean 运行配置
 * 可与 web 无必然关
 *
 * */
@Configuration
//扫描bean，过滤web相关的
@ComponentScan(basePackages = {"net.htmlonline"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        }
)
public class RootConfig {
}