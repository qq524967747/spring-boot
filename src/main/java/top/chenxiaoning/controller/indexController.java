package top.chenxiaoning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Object login() {

        System.out.println("aaa");
        return "home/login";
    }
}
