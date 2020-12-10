package top.chenxiaoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.chenxiaoning.dao.Result;
import top.chenxiaoning.dao.User;
import top.chenxiaoning.service.UserService;

@RestController
public class login {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
       int count = userService.SelByNameAndPwd(user.getUserName(),user.getPassword());
        Result result;
        if (count ==1){
            result = Result.ok();
        }else {
            result = Result.loginError();
        }
        return result;
    }

}
