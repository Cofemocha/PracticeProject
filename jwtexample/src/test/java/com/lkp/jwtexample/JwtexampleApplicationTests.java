package com.lkp.jwtexample;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Signature;
import java.util.Calendar;
import java.util.HashMap;

/*@SpringBootTest*/
class JwtexampleApplicationTests {

	@Test
	void contextLoads() {
		//默认的jwt header是使用typ:jwt,alg:hsa256
		HashMap<String,Object> map = new HashMap<String,Object>(2);
		Calendar  instance = Calendar.getInstance();
		instance.add(Calendar.SECOND,100);
		String token =JWT.create().withHeader(map).
				withClaim("userId",21)
				.withClaim("username","lkp").withExpiresAt(instance.getTime())
				.sign(Algorithm.HMAC256("!sfafsaf"));
		System.out.println(token);
	}

	@Test
	public void Validate(){
		JWTVerifier validate=JWT.require(Algorithm.HMAC256("!sfafsaf")).build();
		DecodedJWT decodedJWT  =validate.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTUyMTEwNjUsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoibGtwIn0.iP6nBaKk3ZIFWVdHIpFIbFXjILzSCv5YTPuppkoOB-0");
		System.out.println(decodedJWT.getClaim("userId").asLong());
		System.out.println(decodedJWT.getClaim("username").asString());


	}

}
