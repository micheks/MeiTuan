package com.kylin.meituan.activity;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.x;

/**
 * Package com.kylin.meituan
 * 创建人：wxianing
 * 作 用：
 * 时 间：2016/3/28
 * 修改人：
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
