package com.example.kson.fresco1603b.presenter.user;

import com.example.kson.fresco1603b.contract.user.LoginContract;
import com.example.kson.fresco1603b.entity.UserEntity;
import com.example.kson.fresco1603b.model.user.LoginModel;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/29
 * Description:
 */
public class LoginPresenter implements LoginContract.ILoginPresenter {

    private LoginModel loginModel;
    private LoginContract.ILoginView iLoginView;
    private WeakReference<LoginContract.ILoginView> weakReference;

    public LoginPresenter(LoginContract.ILoginView iLoginView) {
        this.loginModel = new LoginModel();
        attach(iLoginView);
    }

    /**
     * 绑定view对象，设置成若引用
     * @param iLoginView
     */
    public void attach(LoginContract.ILoginView iLoginView){

        weakReference = new WeakReference<>(iLoginView);
        this.iLoginView = weakReference.get();//得到若引用的view
    }

    /**
     * 通过弱引用回收view对象
     */
    public void detach(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference = null;
        }
    }

    @Override
    public void login(HashMap<String, String> params) {

        loginModel.login(params, new LoginModel.onLoginResponse() {
            @Override
            public void success(String str) {
                iLoginView.loginSucces(str);
            }

            @Override
            public void failure(String msg) {

                iLoginView.failure(msg);

            }
        });

    }
}
