package top.chenxiaoning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.chenxiaoning.dao.Result;
import top.chenxiaoning.dao.User;
import top.chenxiaoning.service.UserService;
import top.chenxiaoning.utils.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class login {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        String pwd = user.getPassword();
        String name = user.getUserName();
        Result result;
        if (pwd.equals("")||name.equals("")){
            result = Result.loginError();
            return result;
        }
        String readPwd = util.md5Encryption(pwd);
        int count = userService.SelByNameAndPwd(user.getUserName(), readPwd);

        if (count == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("USER",user);
            result = Result.ok();
            /*try {
                response.sendRedirect(request.getContextPath()+"index");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            return result;
        } else {
            result = Result.loginError();
        }
        return result;
    }

}
