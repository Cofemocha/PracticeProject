package com.lkp.jwtexample.autogenerator.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author code generator
 * @since 2021-03-08
 */
public class TbUser extends Model<TbUser> {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TbUser{" +
        "username=" + username +
        ", password=" + password +
        "}";
    }
}
