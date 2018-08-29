package com.example.kson.fresco1603b.common;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/29
 * Description:
 */
public class UserApi {

    public static String LOGIN_URL = Contants.isRelease==true?Contants.BASE_RELEASE_URL+"user/login":Contants.BASE_DEBUG_URL+"user/login";
}
