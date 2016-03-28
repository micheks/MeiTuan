package com.kylin.meituan;

import android.app.Application;

import org.xutils.x;

/**
 * Package com.kylin.meituan
 * 创建人：wxianing
 * 作 用：
 * 时 间：2016/3/28
 * 修改人：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
