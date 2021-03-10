package com.lkp.jwtexample.dto;

//DTO用于返回给门面层判断
public class UserDto {
    private String username;
    private  String token;
    private  int status;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
