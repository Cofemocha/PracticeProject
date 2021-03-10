package com.lkp.jwtexample.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lkp.jwtexample.controller.BaseController;
import com.lkp.jwtexample.exp.MyException;
import com.lkp.jwtexample.exp.ResponseResult;
import com.lkp.jwtexample.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JwtInterceptor extends BaseController implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        ResponseResult rs = null;
        boolean flag = false;
        String token = "";
      //  从请求中获取Token
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("token")){
                    flag= true;
                    token = cookie.getValue();
                }
            }
        }
        //Token存在
        if(flag) {
            try {
                JwtUtil.verlify(token);
                return true;
            } catch (Exception e) {
                rs=renderError(new MyException("Token invalidate",-10));
               // map.put("msg", "request failed！");


            }
        }
        else {
            rs =renderError(new MyException("Token Not Found!",-20));
            //map.put("msg","无Token");
           // response.sendRedirect("/index");

        }
        //将Map转成Json,输出请求失败的原因
        String json =new ObjectMapper().writeValueAsString(rs);
        response.setContentType("application/json;charset=GBK");
        response.getWriter().println(json);
        return false;
    }
}
