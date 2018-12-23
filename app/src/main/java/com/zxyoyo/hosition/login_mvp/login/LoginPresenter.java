package com.zxyoyo.hosition.login_mvp.login;

import android.text.TextUtils;

import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * time:2018/12/22
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 **/
public class LoginPresenter implements ILoginContract.Presenter {
    private ILoginContract.View view;
    private CompositeDisposable compositeDisposable;// 用于管理网络请求的线程
    private LoginRepository repository;
    private String url = "http://soyoyo.esy.es/testmvp.php";// 测试登录用的url
    private Gson gson;

    public LoginPresenter(ILoginContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void doLogin(String name,String pwd) {
        //显示 progressbar
        view.showProgressBar(true);
        Disposable disposable = repository.getUserInfo(url, name, pwd)
                .subscribe(next -> {
                    view.showProgressBar(false);
                    if (next.contains("错误")) {
                        // 登录失败
                        view.showMessage(next);
                    } else {
                        //登录成功
                        view.showMessage("登录成功！");
                        // 解析用户信息
                        User user = gson.fromJson(next, User.class);
                        view.goToMainActivity(user);

                    }
                }, error -> {
                    error.printStackTrace();
                    view.showMessage("登录失败");
                    view.showProgressBar(false);

                });
        compositeDisposable.add(disposable);
    }

    @Override
    public void subscribe() {
        // 初始化变量
        compositeDisposable = new CompositeDisposable();
        repository = new LoginRepository();
        gson = new Gson();
    }

    @Override
    public void unsubscribe() {
        repository = null;//手动置空
        if(compositeDisposable!=null){
            // 关闭所有网络请求，避免内存泄漏
            compositeDisposable.clear();
        }
    }
}
