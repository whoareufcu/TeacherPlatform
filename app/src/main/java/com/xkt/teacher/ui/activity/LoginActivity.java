package com.xkt.teacher.ui.activity;

import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import com.xkt.teacher.R;
import com.xkt.teacher.common.MyActivity;
import com.xkt.teacher.helper.InputTextHelper;
import com.xkt.teacher.ui.view.ClearEditText;
import com.xkt.teacher.ui.view.PasswordEditText;

public class LoginActivity extends MyActivity {
    private static final String TAG = "LoginActivity";
    private ClearEditText mClearEditText;
    private PasswordEditText mPasswordEditText;
    private AppCompatButton mLoginButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mClearEditText = (ClearEditText) getId(R.id.accont_et);
        mPasswordEditText = (PasswordEditText) getId(R.id.passwd_et);
        mLoginButton = (AppCompatButton) getId(R.id.login_bt);

//        InputTextHelper.with(this)
//                .addView(mClearEditText)
//                .addView(mPasswordEditText)
//                .setMain(mLoginButton)
//                .build();

        setOnClickListener(mLoginButton);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            if (mClearEditText.getText().toString().equals("123") ){
                if (mPasswordEditText.getText().toString().equals("123")){
                    showDialog("登录中...");
                    postDelayed(()->{
                        hideDialog();
                        startActivity(MainActivity.class);
                    },3000);

                }else {
                    toast(R.string.error_password);
                    Log.e(TAG, "onClick: "+mPasswordEditText.getText().toString() );
                }
            }else {
                toast(R.string.error_account);
                Log.e(TAG, "onClick: "+mClearEditText.getText().toString() );
            }

        }
    }
}
