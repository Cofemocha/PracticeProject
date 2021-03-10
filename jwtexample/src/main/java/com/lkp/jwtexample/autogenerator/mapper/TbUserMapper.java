package com.lkp.jwtexample.autogenerator.mapper;

import com.lkp.jwtexample.autogenerator.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper ½Ó¿Ú
 * </p>
 *
 * @author code generator
 * @since 2021-03-08
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {
    public  TbUser selectByName(String username);
}
