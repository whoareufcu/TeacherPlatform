package com.xkt.teacher.ui.fragment;

import com.xkt.teacher.ui.activity.MainActivity;
import com.xkt.teacher.R;
import com.xkt.teacher.common.MyFragment;

public class MineFragment extends MyFragment<MainActivity> {

    public static MineFragment newInstance() {
        return new MineFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        //使用沉浸式状态栏
        return !super.isStatusBarEnabled();

    }
}
