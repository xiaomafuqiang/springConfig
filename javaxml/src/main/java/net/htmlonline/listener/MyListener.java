package net.htmlonline.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("initial...");
        System.out.println(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("destroyed...");
    }
}
