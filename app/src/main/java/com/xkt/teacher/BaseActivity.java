//package com.xkt.teacher;
//
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.inputmethod.InputMethodManager;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public abstract class BaseActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initActivity();
//    }
//    protected void initActivity() {
//        initLayout();
//        initView();
//        initData();
//    }
//
//    /**
//     * 获取布局 ID
//     */
//    protected abstract int getLayoutId();
//
//    /**
//     * 初始化控件
//     */
//    protected abstract void initView();
//
//    /**
//     * 初始化数据
//     */
//    protected abstract void initData();
//
//    /**
//     * 初始化布局
//     */
//    protected void initLayout() {
//        if (getLayoutId() > 0) {
//            setContentView(getLayoutId());
//            initSoftKeyboard();
//        }
//    }
//
//    /**
//     * 初始化软键盘
//     */
//    protected void initSoftKeyboard() {
//        // 点击外部隐藏软键盘，提升用户体验
//        getContentView().setOnClickListener(view -> hideSoftKeyboard());
//    }
//
//    /**
//     * 和 setContentView 对应的方法
//     */
//    public ViewGroup getContentView() {
//        return findViewById(Window.ID_ANDROID_CONTENT);
//    }
//
//    public Context getContext() {
//        return this;
//    }
//
//    /**
//     * 隐藏软键盘
//     */
//    private void hideSoftKeyboard() {
//        // 隐藏软键盘，避免软键盘引发的内存泄露
//        View view = getCurrentFocus();
//        if (view != null) {
//            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            if (manager != null && manager.isActive(view)) {
//                manager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//            }
//        }
//    }
//}
