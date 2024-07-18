package com.sany.resp;

import lombok.Data;

/**
 * 为了统一Controller层的返回类型
 *
 * @author: SanyQAQ
 * @create: 2024-07-17-20:20
 */
@Data
public class ResultData<T> {
    private String Code;
    private String describe;
    private T data;
    //时间戳，为了确定什么时候调用了这个接口
    private long timestamp;

    public ResultData(){
        this.timestamp=System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData resultData = new ResultData<T>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setDescribe(ReturnCodeEnum.RC200.getDescribe());
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultData<T> fail(String code,String describe){
        ResultData resultData = new ResultData<T>();
        resultData.setCode(code);
        resultData.setDescribe(describe);
        resultData.setData(null);
        return resultData;
    }

}
