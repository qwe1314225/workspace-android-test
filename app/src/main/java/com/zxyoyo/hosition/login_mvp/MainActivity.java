package com.zxyoyo.hosition.login_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zxyoyo.hosition.login_mvp.login.User;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_sex;
    private TextView tv_age;
    private TextView tv_mobile;
    private TextView tv_describe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        User user = (User) getIntent().getSerializableExtra("user");
        if(user!=null){
            tv_name.setText(tv_name.getText().toString()+""+user.getName());
            tv_sex.setText(tv_sex.getText().toString()+""+user.getSex());
            tv_age.setText(tv_age.getText().toString()+""+user.getAge());
            tv_mobile.setText(tv_mobile.getText().toString()+""+user.getMobile());
            tv_describe.setText(tv_name.getText().toString()+"\n"+user.getDescribe());
        }
    }

    private void initView() {
        tv_name = findViewById(R.id.tv_name);
        tv_sex = findViewById(R.id.tv_sex);
        tv_age = findViewById(R.id.tv_age);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_describe = findViewById(R.id.tv_describe);
    }
}
