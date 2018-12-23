package com.zxyoyo.hosition.login_mvp;

/**
 * time:2018/12/21
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 * 基础接口：presenter
 **/
public interface BasePresenter {
    void subscribe();// 订阅 用于绑定view
    void unsubscribe();// 解除与view的绑定
}
