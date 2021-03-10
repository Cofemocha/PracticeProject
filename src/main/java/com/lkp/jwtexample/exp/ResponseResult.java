package com.lkp.jwtexample.exp;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ResponseResult<T> {
    private  String message;
    private  int status;
    private  T content;
    @Override
    public String toString() {
        return "ResponseResult{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
