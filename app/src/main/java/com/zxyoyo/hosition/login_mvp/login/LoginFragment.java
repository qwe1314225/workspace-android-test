package com.zxyoyo.hosition.login_mvp.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zxyoyo.hosition.login_mvp.MainActivity;
import com.zxyoyo.hosition.login_mvp.R;

/**
 * time:2018/12/22
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 **/
public class LoginFragment extends Fragment implements ILoginContract.View {

    private ILoginContract.Presenter presenter;
    private View view;
    private ProgressBar pb;
    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initView();
        presenter.subscribe();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 登录按钮的点击事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //执行登录操作
                presenter.doLogin(etName.getText().toString(),etPwd.getText().toString());
            }
        });
    }

    private void initView() {
        pb = view.findViewById(R.id.pb_login);
        etName = view.findViewById(R.id.et_name);
        etPwd = view.findViewById(R.id.et_pwd);
        btnLogin = view.findViewById(R.id.btn_login);
    }

    @Override
    public void showProgressBar(Boolean isShow) {
        if(isShow){
            // 显示 转圈圈
            pb.setVisibility(View.VISIBLE);
        }else {
            // 隐藏
            pb.setVisibility(View.GONE);

        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToMainActivity(User user) {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra("user",user);
        getContext().startActivity(intent);
    }

    @Override
    public void setPresenter(ILoginContract.Presenter presenter) {
        if(presenter!=null) this.presenter = presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();//解除订阅，
    }
}
