package top.chenxiaoning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/home")
    public String index() {

        System.out.println("aaa");
        return "index.html";
    }

}
