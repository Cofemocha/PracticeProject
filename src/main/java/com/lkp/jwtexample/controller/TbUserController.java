package com.lkp.jwtexample.controller;


import com.lkp.jwtexample.dto.UserDto;
import com.lkp.jwtexample.exp.ResponseResult;
import com.lkp.jwtexample.exp.MyException;
import com.lkp.jwtexample.faced.TbUserFaced;
import com.lkp.jwtexample.params.LoginParams;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author code generator
 * @since 2021-03-08
 */
@RestController
@MapperScan("com.lkp.jwtexample.autogenerator")

public class TbUserController extends BaseController{
    @Autowired
    TbUserFaced  userFaced;



    //登录逻辑
    @RequestMapping("/user/login")
    public ResponseResult loginHandler(@RequestBody  LoginParams loginParams, HttpServletResponse response){
       UserDto dto  = userFaced.login(loginParams);
       if(dto==null){
            return renderError(new MyException("login error",-3));
       }
       else {
           Cookie cookie = new Cookie("token",dto.getToken());
           cookie.setMaxAge(60*30);
           response.addCookie(cookie);
           return  renderSuccess(dto.getToken());
       }


    }

    //测试用接口,只有登录才可访问
    @RequestMapping("/user/test")
    public ResponseResult tokenTest(){
        return  renderSuccess();

    }

}

