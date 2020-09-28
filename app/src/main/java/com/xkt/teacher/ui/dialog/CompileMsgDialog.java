package com.xkt.teacher.ui.dialog;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.StringRes;

import com.xkt.teacher.R;
import com.xkt.teacher.aop.SingleClick;
import com.xkt.teacher.base.BaseDialog;


/**
 *    desc   : 输入对话框
 */
public final class CompileMsgDialog {

    public static final class Builder extends UIDialog.Builder<Builder> implements BaseDialog.OnShowListener {

        private OnListener mListener;
        private final EditText nameEt;

        public Builder(Context context) {
            super(context);
            setCustomView(R.layout.dialog_compile_msg);

            nameEt = findViewById(R.id.name_et);

            addOnShowListener(this);
        }

        public Builder setHint(@StringRes int id) {
            return setHint(getString(id));
        }
        public Builder setHint(CharSequence text) {
            nameEt.setHint(text);
            return this;
        }

        public Builder setContent(@StringRes int id) {
            return setContent(getString(id));
        }
        public Builder setContent(CharSequence text) {
            nameEt.setText(text);
            int index = nameEt.getText().toString().length();
            if (index > 0) {
                nameEt.requestFocus();
                nameEt.setSelection(index);
            }
            return this;
        }

        public Builder setListener(OnListener listener) {
            mListener = listener;
            return this;
        }

        /**
         * {@link BaseDialog.OnShowListener}
         */
        @Override
        public void onShow(BaseDialog dialog) {
            postDelayed(() -> getSystemService(InputMethodManager.class).showSoftInput(nameEt, 0), 500);
        }

        @SingleClick
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_ui_confirm:
                    autoDismiss();
                    if (mListener != null) {
                        mListener.onConfirm(getDialog(), nameEt.getText().toString());
                    }
                    break;
                case R.id.tv_ui_cancel:
                    autoDismiss();
                    if (mListener != null) {
                        mListener.onCancel(getDialog());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public interface OnListener {

        /**
         * 点击确定时回调
         */
        void onConfirm(BaseDialog dialog, String content);

        /**
         * 点击取消时回调
         */
        default void onCancel(BaseDialog dialog) {}
    }
}