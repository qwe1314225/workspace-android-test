package com.zxyoyo.hosition.login_mvp;

/**
 * time:2018/12/21
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 * 基础接口：view
 **/
public interface BaseView<T> {
    void setPresenter(T presenter);// 设置 presenter
}
