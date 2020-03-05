package com.project.zzd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestResult<T> {

    private Integer code;

    private T data;

    private String message;
}
