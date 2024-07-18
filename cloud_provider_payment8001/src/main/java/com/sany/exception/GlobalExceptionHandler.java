package com.sany.exception;

import com.sany.resp.ResultData;
import com.sany.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 为了处理全局异常，也就是每当产生异常时就会走这个类的方法
 *
 * @author: SanyQAQ
 * @create: 2024-07-17-20:53
 */
@Slf4j
@RestControllerAdvice//声明这个是捕获Controller层出现的异常,只针对Controller层有效（大概）
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//表示只接收服务端发生的500错误
    public ResultData<String> exception1(Exception e){
        System.out.println("服务端出错");
        log.error("全局异常信息：{}",e.getMessage(),e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}

