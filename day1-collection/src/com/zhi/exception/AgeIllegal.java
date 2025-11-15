package com.zhi.exception;


//自定义编译时异常类
public class AgeIllegal extends  Exception{
    public AgeIllegal(String message) {
        super(message);
    }
    public AgeIllegal() {
    }
}
