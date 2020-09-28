package com.xkt.teacher.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xkt.teacher.R;
import com.xkt.teacher.base.BaseDialog;
import com.xkt.teacher.common.MyActivity;
import com.xkt.teacher.common.MyFragment;
import com.xkt.teacher.ui.activity.MainActivity;
import com.xkt.teacher.ui.dialog.CompileMsgDialog;
import com.xkt.teacher.ui.view.SmartTextView;


public class MyMsgFragment extends MyFragment<MyActivity> {

    private SmartTextView compileTv;

    public static MyMsgFragment newInstance() {
        return new MyMsgFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_msg;
    }

    @Override
    protected void initView() {
        compileTv= (SmartTextView) getId(R.id.compile_tv);
        setOnClickListener(compileTv);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.compile_tv:
//                toast("编辑资料");
                showCompileMsgDialog();
                break;
        }
    }

    private void showCompileMsgDialog(){
        new CompileMsgDialog.Builder(getContext())
                // 标题可以不用填写
                .setTitle("我是标题")
                // 内容可以不用填写
                .setContent("我是内容")
                // 提示可以不用填写
                .setHint("我是提示")
                // 确定按钮文本
                .setConfirm(getString(R.string.common_confirm))
                // 设置 null 表示不显示取消按钮
                .setCancel(getString(R.string.common_cancel))
                // 设置点击按钮后不关闭对话框
                //.setAutoDismiss(false)
                .setListener(new CompileMsgDialog.OnListener() {

                    @Override
                    public void onConfirm(BaseDialog dialog, String content) {
                        toast("确定了：" + content);
                    }

                    @Override
                    public void onCancel(BaseDialog dialog) {
                        toast("取消了");
                    }
                })
                .show();
    }
}
