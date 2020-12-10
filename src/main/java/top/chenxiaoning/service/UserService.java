package top.chenxiaoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.chenxiaoning.mapper.UserMapper;

import java.beans.IntrospectionException;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Integer SelByNameAndPwd(String userName, String pwd) {
        return userMapper.SelByNameAndPwd(userName, pwd);
    }
    public Integer SeIByName(String userName){
        Integer count = userMapper.SelByName(userName);
        return count;
    }
    public void InByName(String userName,String pwd){
        userMapper.InsertUser(userName,pwd);
    }
    public Integer UpDatePassWord(String passWord,Integer id){
        return userMapper.UpDatePID(passWord,id);

    }
    public Integer DeleUserId(Integer id){
      return   userMapper.DeleteName(id);
    }
}
