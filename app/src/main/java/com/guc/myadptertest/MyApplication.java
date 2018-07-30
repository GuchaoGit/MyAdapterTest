package com.guc.myadptertest;

import android.app.Application;

import tech.linjiang.pandora.Pandora;

/**
 * Created by guc on 2018/7/30.
 * 描述：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Pandora.init(this).enableShakeOpen();
    }
}
