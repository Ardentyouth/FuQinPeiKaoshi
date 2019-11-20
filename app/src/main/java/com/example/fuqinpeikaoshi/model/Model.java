package com.example.fuqinpeikaoshi.model;

import android.util.AndroidException;

import com.example.fuqinpeikaoshi.Myservice;
import com.example.fuqinpeikaoshi.bean.PicBean;
import com.example.fuqinpeikaoshi.callback.Mcallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements ModelBack {
    @Override
    public void onCallback(Mcallback mcallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myservice.geturl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<PicBean> pic = myservice.getPic();
        pic.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PicBean picBean) {

                        mcallback.onSuress(picBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mcallback.onFile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
