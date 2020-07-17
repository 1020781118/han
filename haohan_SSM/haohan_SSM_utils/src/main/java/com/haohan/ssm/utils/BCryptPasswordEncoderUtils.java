package com.haohan.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    public static String passwordEncode(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    public static void main(String[] args) {
        String s = passwordEncode("123");
        System.out.println(s);
    }
}
