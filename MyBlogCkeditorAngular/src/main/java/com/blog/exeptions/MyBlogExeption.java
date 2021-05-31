package com.blog.exeptions;

public class MyBlogExeption extends RuntimeException {
    public MyBlogExeption(String message) {
        super(message);
    }
}