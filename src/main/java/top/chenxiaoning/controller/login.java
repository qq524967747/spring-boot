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
    //拿到用户的数据，给数据库，
    @RequestMapping("/reg")
    public Result cxz(@RequestBody User user){
        Integer con = userService.SeIByName(user.getUserName());
        Result result;
        if(con > 0){
            result = Result.error();
        }else {
           userService.InByName(user.getUserName(),user.getPassword());
      result = Result.ok();
        }
        return result;
        //
    }
    @RequestMapping("/gg")
    public Result zxc(@RequestBody  User user){

        Integer con =userService.UpDatePassWord(user.getPassword(),user.getId());
        Result result;
        result=Result.ok();
        result.setMessage("改成成功");
        return result;

    }
    @RequestMapping("/Delete")
    public Result xcx(@RequestBody User user){

        Integer con=userService.DeleUserId(user.getId());
       Result result;
       result=Result.ok();
       result.setMessage("删除成功啦");
    return result;
    }


}
