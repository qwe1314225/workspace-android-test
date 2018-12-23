package com.zxyoyo.hosition.login_mvp.login;

import com.zxyoyo.hosition.login_mvp.BasePresenter;
import com.zxyoyo.hosition.login_mvp.BaseView;

/**
 * time:2018/12/21
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 * 用于联系 presenter 与 view 的接口
 **/
public interface ILoginContract {

    interface View extends BaseView<Presenter> {
        void showProgressBar(Boolean isShow);//是否显示 progressbar
        void showMessage(String message);// 显示一些展示消息
        void goToMainActivity(User user);// 跳转到主界面，展示用户信息
    }
    interface Presenter extends BasePresenter {
        void doLogin(String name,String pwd);// 执行登录操作
    }
}
