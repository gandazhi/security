package com.gandazhi.handler;

import com.gandazhi.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gandazhi
 * @create 2017-12-18 上午11:22
 **/
@RestControllerAdvice
public class CustomHandler {

    @ExceptionHandler(value = CustomException.class)
    public String demo(){
        return "捕获异常成功";
    }
}
