package cn.hi028.android.highcommunity.presenter;

import cn.hi028.android.highcommunity.Contract;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public class MainPresenter extends Contract.MainPresenter {
    @Override
    public void getTabList() {
        mView.showTabList(mModel.getTabs());
    }

    @Override
    public void onStart() {
        getTabList();
    }
}
