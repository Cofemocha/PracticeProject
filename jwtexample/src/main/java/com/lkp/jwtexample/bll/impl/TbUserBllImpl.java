package com.lkp.jwtexample.bll.impl;

import com.lkp.jwtexample.autogenerator.entity.TbUser;
import com.lkp.jwtexample.autogenerator.service.ITbUserService;
import com.lkp.jwtexample.autogenerator.service.impl.TbUserServiceImpl;
import com.lkp.jwtexample.bll.TbUserBll;
import com.lkp.jwtexample.exp.MyException;
import com.lkp.jwtexample.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUserBllImpl  implements TbUserBll  {
    @Autowired
    TbUserServiceImpl userService;

    @Override
    public TbUser login(LoginParams loginParams) {
        //根据用户名获得用户
        TbUser user = userService.selectByName(loginParams.getName());

        if (user != null) {
            if (user.getPassword().equals(loginParams.getPassword())) {
                   return user;
               }
            else {
                   throw new MyException("password error!",-1);
               }
           }
        else {
               throw  new MyException("user not exist!",-2);
           }
       }

}
