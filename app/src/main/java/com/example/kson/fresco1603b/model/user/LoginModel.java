package com.example.kson.fresco1603b.model.user;

import android.os.Handler;

import com.example.kson.fresco1603b.common.UserApi;
import com.example.kson.fresco1603b.contract.user.LoginContract;
import com.example.kson.fresco1603b.entity.UserEntity;
import com.example.kson.fresco1603b.net.OkHttpUtils;
import com.example.kson.fresco1603b.net.RequestCallback;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/08/29
 * Description:
 */
public class LoginModel implements LoginContract.ILoginModel {

    Handler handler = new Handler();


    @Override
    public void login(HashMap<String, String> params, final onLoginResponse loginResponse) {
        OkHttpUtils.getInstance().postData(UserApi.LOGIN_URL, params, new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {

                if (loginResponse != null) {
                    loginResponse.failure("请求失败");
                }

            }

            @Override
            public void onResponse(Call call, final Response response) {

//                    System.out.println("result:"+response.body().string());
//                    System.out.println(response.body().string());
                if (loginResponse != null) {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                loginResponse.success(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }


            }
        });
    }

    public interface onLoginResponse {
        void success(String str);

        void failure(String msg);
    }
}
