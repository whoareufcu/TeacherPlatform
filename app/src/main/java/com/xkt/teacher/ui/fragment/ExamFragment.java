package com.xkt.teacher.ui.fragment;

import com.xkt.teacher.ui.activity.MainActivity;
import com.xkt.teacher.R;
import com.xkt.teacher.common.MyFragment;

public class ExamFragment extends MyFragment<MainActivity> {

    public static ExamFragment newInstance() {
        return new ExamFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_exam;
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
