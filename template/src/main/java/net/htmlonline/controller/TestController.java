package net.htmlonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/")
    public String test(){
        System.out.println("ok...");
        ModelAndView m = new ModelAndView("/index");
        return "index";
    }

    @RequestMapping("/index")
    public ModelAndView index() {

        TestController controller = new TestController();

        System.out.println(controller.test());
        ModelAndView m = new ModelAndView("home");

        return m;
    }

    @RequestMapping("/some")
    public String some() {
        return "home";
    }
}