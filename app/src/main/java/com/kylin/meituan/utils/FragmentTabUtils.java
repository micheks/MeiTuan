package com.kylin.meituan.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.kylin.meituan.R;

import java.util.ArrayList;

/**
 * Package com.kylin.meituan
 * 创建人：wxianing
 * 作 用：
 * 时 间：2016/3/28
 * 修改人：
 */
public class FragmentTabUtils implements RadioGroup.OnCheckedChangeListener {

    private ArrayList<Fragment> fragments;
    private RadioGroup rgs;
    private FragmentManager fragmentManager;
    private int containerId;

    public FragmentTabUtils(ArrayList<Fragment> fragments, RadioGroup rgs, FragmentManager fragmentManager, int containerId) {
        this.fragments = fragments;
        this.rgs = rgs;
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
        //显示首页
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerId, fragments.get(0));
        transaction.show(fragments.get(0));
        transaction.commit();
        rgs.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            Fragment fragment = fragments.get(i);
            if (checkedId == group.getChildAt(i).getId()) {
                addFragment(fragment);
            } else {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.hide(fragment);
                transaction.commit();
            }
        }
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.main_fragment_contenter, fragment);
            //排队
        }
        transaction.show(fragment);
        transaction.commit();
    }
}

