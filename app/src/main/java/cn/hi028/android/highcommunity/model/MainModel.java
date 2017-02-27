package cn.hi028.android.highcommunity.model;

import cn.hi028.android.highcommunity.Contract;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public class MainModel implements Contract.MainModel {
    @Override
    public String[] getTabs() {
        String[] mTabs = {"主页", "服务", "圈子", "我的"};

        return mTabs;
    }
}
