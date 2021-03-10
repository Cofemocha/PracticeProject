package com.lkp.jwtexample.autogenerator.service.impl;

import com.lkp.jwtexample.autogenerator.entity.TbUser;
import com.lkp.jwtexample.autogenerator.mapper.TbUserMapper;
import com.lkp.jwtexample.autogenerator.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author code generator
 * @since 2021-03-08
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    public TbUser selectByName(String username) {
        return baseMapper.selectByName(username);
    }
}
