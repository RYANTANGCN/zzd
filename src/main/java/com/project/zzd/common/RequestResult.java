package com.project.zzd.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestResult<T> implements Serializable {

    private Integer code;

    private T data;

    private String message;
}
