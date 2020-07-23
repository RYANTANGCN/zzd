package com.project.zzd.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class RequestResult<T> implements Serializable {

    private Integer code;

    private T data;

    private String message;

    private Long count;

    public RequestResult(Integer code,T data,String message){
        this.code = code;
        this.data = data;
        this.message=message;
    }

    public static <T> RequestResult<T> success(T data){
        return new RequestResult<>(1, data, "success");
    }

    public static <T> RequestResult<T> error(T data){
        return new RequestResult<>(-1, data, "error");
    }
}
