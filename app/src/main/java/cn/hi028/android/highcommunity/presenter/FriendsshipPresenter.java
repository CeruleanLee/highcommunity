package cn.hi028.android.highcommunity.presenter;

import cn.hi028.android.highcommunity.CommunityListBean;
import cn.hi028.android.highcommunity.Contract;
import rx.Observer;
import rx.functions.Action1;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public class FriendsshipPresenter extends Contract.FriendsshipPresenter {
    @Override
    public void getMsgData(int num, int page) {
        Action1<CommunityListBean> action1 = new Action1<CommunityListBean>() {
            @Override
            public void call(CommunityListBean mList) {
                mView.showContent(mList);
            }
        };
        mRxManager.add(mModel.getFriendsshipData()
                .subscribe((Observer<? super Object>) action1));
    }

    @Override
    public void onStart() {
        getMsgData(10, 1);
    }
}
