package com.xkt.teacher.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xkt.teacher.R;
import com.xkt.teacher.base.BaseActivity;
import com.xkt.teacher.base.BaseFragmentAdapter;
import com.xkt.teacher.common.MyActivity;
import com.xkt.teacher.common.MyFragment;
import com.xkt.teacher.helper.ActivityStackManager;
import com.xkt.teacher.helper.DoubleClickHelper;
import com.xkt.teacher.other.KeyboardWatcher;
import com.xkt.teacher.ui.fragment.ClassRoomFragment;
import com.xkt.teacher.ui.fragment.ExamFragment;
import com.xkt.teacher.ui.fragment.MineFragment;
import com.xkt.teacher.ui.fragment.WorkFragment;


public class MainActivity extends MyActivity implements BottomNavigationView.OnNavigationItemSelectedListener, KeyboardWatcher.SoftKeyboardStateListener, ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";
    private BottomNavigationView mBottomNavigationView;
    private ViewPager mViewPager;
    /**
     * ViewPager 适配器
     */
    private BaseFragmentAdapter<MyFragment> mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        mBottomNavigationView = (BottomNavigationView) getId(R.id.bv_home_navigation);
        mViewPager = (ViewPager) getId(R.id.main_vp);

        // 不使用图标默认变色
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);


        mViewPager.setOnPageChangeListener(this);
    }

    @Override
    protected void initData() {
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(ClassRoomFragment.newInstance());
        mPagerAdapter.addFragment(ExamFragment.newInstance());
        mPagerAdapter.addFragment(WorkFragment.newInstance());
        mPagerAdapter.addFragment(MineFragment.newInstance());
        // 设置成懒加载模式
        mPagerAdapter.setLazyMode(true);
        mViewPager.setAdapter(mPagerAdapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.home_found:
                mViewPager.setCurrentItem(1);
                return true;
            case R.id.home_message:
                mViewPager.setCurrentItem(2);
                return true;
            case R.id.home_me:
                mViewPager.setCurrentItem(3);
                return true;
            default:
                break;
        }
        return false;
    }

    /**
     * {@link KeyboardWatcher.SoftKeyboardStateListener}
     */
    @Override
    public void onSoftKeyboardOpened(int keyboardHeight) {
        mBottomNavigationView.setVisibility(View.GONE);
    }

    @Override
    public void onSoftKeyboardClosed() {
        mBottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 回调当前 Fragment 的 onKeyDown 方法
        if (mPagerAdapter.getShowFragment().onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (DoubleClickHelper.isOnDoubleClick()) {
            // 移动到上一个任务栈，避免侧滑引起的不良反应
            moveTaskToBack(false);
            postDelayed(() -> {

                // 进行内存优化，销毁掉所有的界面
                ActivityStackManager.getInstance().finishAllActivities();
                // 销毁进程（注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
                // System.exit(0);

            }, 300);
        } else {
            toast(R.string.home_exit_hint);
        }
    }

    @Override
    protected void onDestroy() {
        mViewPager.setAdapter(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }

    @Override
    public boolean isSwipeEnable() {
        return false;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.e(TAG, "onPageSelected: "+position );
        switch (position){
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.home_found);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.home_message);
                break;
            case 3:
                mBottomNavigationView.setSelectedItemId(R.id.home_me);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
