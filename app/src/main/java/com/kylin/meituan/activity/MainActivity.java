package com.kylin.meituan.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.kylin.meituan.R;
import com.kylin.meituan.fragments.HomeFragment;
import com.kylin.meituan.fragments.MoreFragment;
import com.kylin.meituan.fragments.MyFragment;
import com.kylin.meituan.fragments.ShopsFragment;
import com.kylin.meituan.utils.FragmentTabUtils;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRadioGroup;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        initView();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_bottom_rgs);
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ShopsFragment());
        mFragments.add(new MyFragment());
        mFragments.add(new MoreFragment());
        new FragmentTabUtils(mFragments, mRadioGroup, getSupportFragmentManager(), R.id.main_fragment_contenter);
    }
}
