package top.chenxiaoning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Object home() {
        return "home/index";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Object index() {
        return "home/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Object login() {
        return "home/login";
    }

    @RequestMapping(value = "/orderList",method = RequestMethod.GET)
    public Object orderList() {
        return "order/order-list";
    }
}
