package com.zxyoyo.hosition.login_mvp.login;

import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * time:2018/12/22
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 * 网络请求类
 **/
public class LoginRepository {

    private OkHttpClient okHttpClient;


    public LoginRepository(){
        if(okHttpClient ==null){
            okHttpClient = new OkHttpClient()
                            .newBuilder()
                            .callTimeout(10,TimeUnit.SECONDS)// 设置连接超时时间
                            .build();
        }
    }

    public  Observable<String> getUserInfo(String url,String name,String pwd){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // 表单方式提交参数
                RequestBody requestBody = new FormBody.Builder()
                        .add("username",name)// username 与 服务器对应，服务器也是通过这个 拿到 name的值
                        .add("userpassword",pwd)
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();
                // 开始请求服务器
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        //请求失败
                        emitter.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        //请求成功
                        emitter.onNext(response.body().string());
                    }
                });
            }
        })
                .observeOn(AndroidSchedulers.mainThread())// 指定 最后拿到数据操，解析，显示发生在主线程
                .subscribeOn(Schedulers.io());// 指定 网络请求耗时操作发生在子线程
    }

}
