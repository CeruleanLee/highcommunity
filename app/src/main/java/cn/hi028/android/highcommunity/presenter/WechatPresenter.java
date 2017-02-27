package cn.hi028.android.highcommunity.presenter;


import java.util.List;

import cn.hi028.android.highcommunity.WXItemBean;
import cn.hi028.android.highcommunity.ZhihuContract;
import rx.functions.Action1;

/**
 * Created by hpw on 16/11/6.
 */
public class WechatPresenter extends ZhihuContract.WechatPresenter {
    @Override
    public void onStart() {
        getWechatData(50, 1);
    }

    @Override
    public void getWechatData(int num, int page) {
        Action1<List<WXItemBean>> action1 = new Action1<List<WXItemBean>>() {
            @Override
            public void call(List<WXItemBean> mList) {
                mView.showContent(mList);
            }
        };
        mRxManager.add(mModel.getWechatData(num, page)
                .subscribe(action1
                ));
    }
}
