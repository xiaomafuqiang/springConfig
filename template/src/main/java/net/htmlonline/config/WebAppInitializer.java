package net.htmlonline.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置spring上下文
     * @return config
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 配置dispatcher上下文
     * @return config
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 绑定dispatcher的映射路径
     * @return paths
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
