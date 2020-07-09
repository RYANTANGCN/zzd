package com.project.zzd.config;

import com.project.zzd.common.RequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public RequestResult<String> validateException(ConstraintViolationException constraintViolationException) {
        return RequestResult.error(constraintViolationException.getLocalizedMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RequestResult<String> systemError(Exception e){
        logger.error("Error Found:", e);
        return RequestResult.error("Server Error");
    }

}
