package com.lkp.jwtexample.faced;

import com.lkp.jwtexample.dto.UserDto;
import com.lkp.jwtexample.params.LoginParams;
import org.springframework.stereotype.Service;


public interface TbUserFaced {
    UserDto login(LoginParams loginParams);
}
