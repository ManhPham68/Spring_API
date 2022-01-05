package com.example.demo.dto;

public class BaseResponse<T> {
    public int status =1;
    public String message ="Success";
    public T data;
}
