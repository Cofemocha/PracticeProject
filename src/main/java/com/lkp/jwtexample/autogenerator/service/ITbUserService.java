package com.lkp.jwtexample.autogenerator.service;

import com.lkp.jwtexample.autogenerator.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author code generator
 * @since 2021-03-08
 */
public interface ITbUserService extends IService<TbUser> {
     TbUser selectByName(String username);
}
