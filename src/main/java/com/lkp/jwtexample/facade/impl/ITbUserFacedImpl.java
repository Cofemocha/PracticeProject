package com.lkp.jwtexample.facade.impl;

import com.lkp.jwtexample.autogenerator.entity.TbUser;
import com.lkp.jwtexample.bll.TbUserBll;
import com.lkp.jwtexample.dto.UserDto;
import com.lkp.jwtexample.facade.ITbUserFaced;
import com.lkp.jwtexample.util.JwtUtil;
import com.lkp.jwtexample.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ITbUserFacedImpl implements ITbUserFaced {
    @Autowired
    TbUserBll userBll;

    @Override
    public UserDto login(LoginParams loginParams) {
        TbUser user = userBll.login(loginParams);
        UserDto  dto = new UserDto();
       //由bll传来的user如果为空
        Map<String,String>  map = new HashMap<String, String>();
        map.put("username",loginParams.getName());
        String token = JwtUtil.generateToken(map);
        //Dto对象设置
        dto.setUsername(loginParams.getName());
        dto.setToken(token);
        return dto;
    }
}
