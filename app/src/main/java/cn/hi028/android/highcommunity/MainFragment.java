package cn.hi028.android.highcommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.helper.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public class MainFragment extends CoreBaseFragment<MainPresenter, MainModel> implements Contract.MainView, Thread.UncaughtExceptionHandler {
    static final String TAG = "MainFragment:";
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabs)
    TabLayout tabs;
//    @BindView(R.id.viewpager)
//    ViewPager viewpager;
//    @BindView(R.id.tabs)
//    TabLayout tabs;

    public static MainFragment newInstance(int position) {
        Log.e(TAG, "newInstance");
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.ARG_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在OnCreate方法中调用下面方法，然后再使用线程，就能在uncaughtException方法中捕获到异常
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void showTabList(String[] mTabs) {
        Log.e(TAG, "showTabList");
        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序
        Log.e(TAG, "showTabList：" + mTabs.length + ",toString:" + mTabs.toString());
        for (int i = 0; i < mTabs.length; i++) {
            Log.e(TAG, "showTabList loop " + i);
            if (tabs!=null){

                tabs.addTab(tabs.newTab().setText(mTabs[i]));
            }else{
                Log.e(TAG, "---null---  " );

            }
//            tabs.addTab(tabs.newTab());

            Log.e(TAG, "showTabList loop " + i + "step 1");

            switch (i) {
                case 0:
                    Log.e(TAG, "showTabList loop " + i + "step 2");

                    fragments.add(new FriendsshipFrag());
                    break;
                case 1:
                    fragments.add(new FriendsshipFrag());
                    break;
                case 2:
                    fragments.add(new FriendsshipFrag());
                    break;
                default:
                    fragments.add(new FriendsshipFrag());
                    break;
            }
        }
        Log.e(TAG, "showTabList loop " + "ok ");

        int position = getArguments().getInt(Constants.ARG_POSITION, 1);
        Log.e(TAG, "showTabList 1111");

        viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        viewpager.setCurrentItem(position);//要设置到viewpager.setAdapter后才起作用
        tabs.setupWithViewPager(viewpager);
        Log.e(TAG, "showTabList 222");

        tabs.setVerticalScrollbarPosition(position);
        for (int i = 0; i < mTabs.length; i++) {
            Log.e(TAG, "showTabList     " + i);

            tabs.getTabAt(i).setText(mTabs[i]);
        }
    }

    @Override
    public int getLayoutId() {
        Log.e(TAG, "getLayoutId");
        return R.layout.app_bar_main;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showError(String msg) {

    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //在此处理异常， arg1即为捕获到的异常
        Log.i("AAA", "uncaughtException   " + e);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
