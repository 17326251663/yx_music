package com.czxy.yx.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class PasswordUtil {

    public static String encrypt(String password) {

        try {
            byte[] bytes = password.getBytes("utf-8");

            for (int i = 0; i < bytes.length; i++) {
                bytes[i]= (byte) (bytes[i]^123);
            }

            return new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }

    }

    public static String coding(String password) throws UnsupportedEncodingException {
        return URLEncoder.encode(password,"utf-8");
    }

    public static String decode(String password) throws UnsupportedEncodingException {
        return URLDecoder.decode(password,"utf-8");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
      String x = "sfsadada";
        String encrypt = encrypt(x);
        System.out.println(encrypt);
        System.out.println();
        System.out.println(coding(encrypt));
        System.out.println("------------------");
        String decode = decode("%08%1D%08%1A%1F%1A%1F%1A");
        System.out.println(decode);
        System.out.println(encrypt(decode));
    }
}
