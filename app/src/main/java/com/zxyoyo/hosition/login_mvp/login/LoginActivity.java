package com.zxyoyo.hosition.login_mvp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.zxyoyo.hosition.login_mvp.R;

public class LoginActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginFragment loginFragment = LoginFragment.getInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,loginFragment,LoginFragment.class.toString()).commit();
        // 将 presenter 与 view 关联起来
        new LoginPresenter(loginFragment);
    }

}
