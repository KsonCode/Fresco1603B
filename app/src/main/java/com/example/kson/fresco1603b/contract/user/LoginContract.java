package com.example.kson.fresco1603b.contract.user;

import com.example.kson.fresco1603b.entity.UserEntity;
import com.example.kson.fresco1603b.model.user.LoginModel;

import java.util.HashMap;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/29
 * Description:登录的契约类
 */
public interface LoginContract {

    //view层
    interface ILoginView{
        void loginSucces(String string);
        void failure(String msg);
    }

    interface  ILoginModel{

        void login(HashMap<String,String> params, LoginModel.onLoginResponse loginResponse);

    }

    interface ILoginPresenter{

        void login(HashMap<String,String> params);

    }
}
