package net.htmlonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/")
    public String test(@ModelAttribute("xxx") String xxx){
        System.out.println(xxx);
//        System.out.println(model);
//        can use ${xxx} in .jsp
        return "home";
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView m = new ModelAndView("home");
        return m;
    }

    @RequestMapping("/some")
    public String some() {
        return "home";
    }

    @ModelAttribute
    public void init(Model model) {
        System.out.println(model);
        model.addAttribute("xxx", "-----/////--------------");
    }

    @RequestMapping("/testView")
    public String testView() {
        System.out.println("controller");
        return "aaa";
    }
}