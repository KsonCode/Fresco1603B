package com.example.kson.fresco1603b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kson.fresco1603b.contract.user.LoginContract;
import com.example.kson.fresco1603b.entity.UserEntity;
import com.example.kson.fresco1603b.presenter.user.LoginPresenter;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView{
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();


    }

    private void initData() {
        loginPresenter = new LoginPresenter(this);
        HashMap<String,String> params = new HashMap<>();
        params.put("mobile","18612991023");
        params.put("password","222222");
        loginPresenter.login(params);
    }

    @Override
    public void loginSucces(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginPresenter!=null){
            loginPresenter.detach();
        }
    }
}
