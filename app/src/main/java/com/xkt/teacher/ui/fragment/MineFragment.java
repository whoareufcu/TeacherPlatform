package com.xkt.teacher.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.xkt.teacher.base.BaseFragmentAdapter;
import com.xkt.teacher.ui.activity.MainActivity;
import com.xkt.teacher.R;
import com.xkt.teacher.common.MyFragment;

public class MineFragment extends MyFragment<MainActivity> {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    /**
     * ViewPager 适配器
     */
    private BaseFragmentAdapter<MyFragment> mPagerAdapter;

    public static MineFragment newInstance() {
        return new MineFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        tabLayout= (TabLayout) getId(R.id.tablayout);
        viewPager= (ViewPager) getId(R.id.viewpager_mine);
        mPagerAdapter = new BaseFragmentAdapter<>(this);

    }

    @Override
    protected void initData() {
        mPagerAdapter.addFragment(MyMsgFragment.newInstance(),"个人信息");
        mPagerAdapter.addFragment(MyAccountFragment.newInstance(),"修改密码");
        // 设置成懒加载模式
        mPagerAdapter.setLazyMode(true);
        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean isStatusBarEnabled() {
        //使用沉浸式状态栏
        return !super.isStatusBarEnabled();

    }

}
