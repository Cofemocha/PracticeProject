package com.lkp.jwtexample.util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

@Component
public class   JwtUtil {
    //签名
    private  static  final  String  SIGNATURE= "#afjslkaj352#@4jlk";
    /*
    * 生成Token
    * */

    public  static String generateToken(Map<String,String> map){
        JWTCreator.Builder  builder = JWT.create();
        //设置Token时效
        Calendar  calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);
        //把所有都返回了，可以定制
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SIGNATURE));
        return token;
    }
    /*
    * 验证Token
    * */
    public static  void verlify(String token){
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /*
    * 获取Token payload
    *
    * */
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
