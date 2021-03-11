package com.lkp.jwtexample.facade;

import com.lkp.jwtexample.dto.UserDto;
import com.lkp.jwtexample.params.LoginParams;


public interface ITbUserFaced {
    UserDto login(LoginParams loginParams);
}
