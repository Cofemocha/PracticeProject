package com.lkp.jwtexample.bll;

import com.lkp.jwtexample.autogenerator.entity.TbUser;
import com.lkp.jwtexample.params.LoginParams;
import org.springframework.stereotype.Service;


public interface TbUserBll {
    public TbUser login(LoginParams loginParams);
}
