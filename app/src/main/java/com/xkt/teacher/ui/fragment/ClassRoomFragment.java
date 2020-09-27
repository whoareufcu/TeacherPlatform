package com.xkt.teacher.ui.fragment;

import com.xkt.teacher.ui.activity.MainActivity;
import com.xkt.teacher.R;
import com.xkt.teacher.common.MyFragment;

public class ClassRoomFragment extends MyFragment<MainActivity> {

    public static ClassRoomFragment newInstance() {
        return new ClassRoomFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classroom;
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
