package cn.hi028.android.highcommunity;

import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;


import rx.Observable;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */
public class FriendsshipModel implements Contract.FriendsshipModel{
    //负责存储、检索、操纵数据
    @Override
    public Observable<Object> getFriendsshipData() {

        return RxService.createApi(Api.class, Api.HOST)
                .getMsgList()
                .compose(RxUtil.rxSchedulerHelper())
//                .compose(RxUtil.handleResult())
                ;
    }
}
