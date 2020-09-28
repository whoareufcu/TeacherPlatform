package com.xkt.teacher.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xkt.teacher.R;
import com.xkt.teacher.common.MyActivity;
import com.xkt.teacher.common.MyFragment;

public class MyAccountFragment extends MyFragment<MyActivity> {

    public static MyAccountFragment newInstance() {
        return new MyAccountFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_account;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}