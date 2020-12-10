package top.chenxiaoning.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    Integer SelByNameAndPwd(@Param("userName") String userName,@Param("password") String password);
    Integer SelByName(@Param("userName") String userName);
    void InsertUser(@Param("userName") String userName,@Param("password") String password);
    Integer UpDatePID(@Param("password") String password,@Param("id")  int id);
    Integer DeleteName(@Param("id") int id);

}

