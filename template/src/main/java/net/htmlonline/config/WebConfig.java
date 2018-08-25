package net.htmlonline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * web配置相关
 * scan最好web类
 * 主要viewResolver 视图解析
 *
 *
 * */

//声明为spring的配置类
@Configuration
//开启springMvc
// *******************  EnableWebMvc ==   extends WebMvcConfigurationSupport 可以取消了
// ### @EnableWebMvc
//开启组件扫描，注意只扫描web相关的内容
@ComponentScan("net.htmlonline.controller")
public class WebConfig extends WebMvcConfigurationSupport {
    /**
     * 配置jsp的视图解析器
     * @return InternalResourceViewResolver
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

    /*
    * 自定义视图内容渲染配置
    * 定义一个实现View 的bean
    * 实现接口即可
    * ReqMap( default=path)-> String: "beanName"
    * */
    @Bean
    public BeanNameViewResolver beanNameViewResolver(){
        BeanNameViewResolver viewResolver = new BeanNameViewResolver();
        viewResolver.setOrder(10);
        return viewResolver;
    }

    /**
     * 启用servlet容器对静态资源的处理
     * @param configurer 配置
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 添加静态资源支持
     * // @EnableWebMvc需要取消
     * */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        super.addResourceHandlers(registry);
    }
}
