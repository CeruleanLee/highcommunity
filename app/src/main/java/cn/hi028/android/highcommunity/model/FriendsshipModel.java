package cn.hi028.android.highcommunity.model;

import com.hpw.mvpframe.data.entity.CoreDataResponse;
import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import cn.hi028.android.highcommunity.Api;
import cn.hi028.android.highcommunity.CommunityListBean;
import cn.hi028.android.highcommunity.Contract;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */
public class FriendsshipModel implements Contract.FriendsshipModel {
    //负责存储、检索、操纵数据


    @Override
    public Observable<CommunityListBean> getFriendsshipData() {

        return RxService.createApi(Api.class, Api.HOST)
                .getMsgList()
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
//                .compose(new Observable.Transformer<CoreDataResponse<CommunityListBean>, CommunityListBean>() {
//                    @Override
//                    public Observable<CommunityListBean> call(Observable<CoreDataResponse<CommunityListBean>> coreDataResponseObservable) {
//                        return coreDataResponseObservable.flatMap(new Func1<CoreDataResponse<CommunityListBean>, Observable<CommunityListBean>>() {
//                            @Override
//                            public Observable<CommunityListBean> call(CoreDataResponse<CommunityListBean> communityListBeanCoreDataResponse) {
////                                return createData(communityListBeanCoreDataResponse.getNewslist());
//                                return Observable.create(new Observable.OnSubscribe<CommunityListBean>() {
//                                    @Override
//                                    public void call(Subscriber<? super CommunityListBean> subscriber) {
//
//                                    }
//                                });
//                            }
//                        });
//                    }
//                })
                ;
    }


    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
