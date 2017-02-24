package cn.hi028.android.highcommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.utils.helper.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public class MainFragment extends CoreBaseFragment<MainPresenter, MainModel> implements Contract.MainView {
    static final String TAG="MainFragment:";
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabs)
    TabLayout tabs;

    public static MainFragment newInstance(int position) {
        Log.e(TAG,"newInstance");
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.ARG_POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void showTabList(String[] mTabs) {
        Log.e(TAG,"showTabList");

        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序
        Log.e(TAG,"showTabList："+mTabs.length+",toString:"+mTabs.toString());
        for (int i = 0; i < mTabs.length; i++) {
            tabs.addTab(tabs.newTab().setText(mTabs[i]));
            switch (i) {
                case 0:
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
        int position = getArguments().getInt(Constants.ARG_POSITION, 1);
        viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments));
        viewpager.setCurrentItem(position);//要设置到viewpager.setAdapter后才起作用
        tabs.setupWithViewPager(viewpager);
        tabs.setVerticalScrollbarPosition(position);
        for (int i = 0; i < mTabs.length; i++) {
            tabs.getTabAt(i).setText(mTabs[i]);
        }
    }

    @Override
    public int getLayoutId() {
        Log.e(TAG,"getLayoutId");
        return R.layout.app_bar_main;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showError(String msg) {

    }


}
