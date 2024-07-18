package com.sany.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: SanyQAQ
 * @create: 2024-07-17-19:28
 * 这个类为了提供网页的状态码和描述
 */
@Getter
@AllArgsConstructor
public enum ReturnCodeEnum {
    RC200("200","懒得写那么多，自己大概知道什么意思"),
    RC201("201","懒得写那么多，自己大概知道什么意思"),
    RC202("202","懒得写那么多，自己大概知道什么意思"),
    RC203("203","懒得写那么多，自己大概知道什么意思"),
    RC204("204","懒得写那么多，自己大概知道什么意思"),
    RC401("401","懒得写那么多，自己大概知道什么意思"),
    RC403("403","懒得写那么多，自己大概知道什么意思"),
    RC404("404","懒得写那么多，自己大概知道什么意思"),
    RC500("500","懒得写那么多，自己大概知道什么意思"),
    RC375("375","懒得写那么多，自己大概知道什么意思");

    private final String code;
    private final String describe;
    public static ReturnCodeEnum getReturnCode(String code){
        for (ReturnCodeEnum element:
             ReturnCodeEnum.values()) {
            if(element.getCode().equalsIgnoreCase(code)){
                return element;
            }
        }
        return null;
    }

}
