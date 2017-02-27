package cn.hi028.android.highcommunity.model;

import com.hpw.mvpframe.data.entity.CoreDataResponse;
import com.hpw.mvpframe.data.net.RxService;
import com.hpw.mvpframe.utils.helper.RxUtil;

import java.util.List;

import cn.hi028.android.highcommunity.Constants;
import cn.hi028.android.highcommunity.WXItemBean;
import cn.hi028.android.highcommunity.WechatApi;
import cn.hi028.android.highcommunity.ZhihuContract;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by hpw on 16/11/6.
 */
public class WechatModel implements ZhihuContract.WechatModel {
    @Override
    public Observable<List<WXItemBean>> getWechatData(int num, int page) {
        return RxService.createApi(WechatApi.class, WechatApi.HOST)
                .getWXHot(Constants.WEIXIN_KEY, num, page)
                .compose(RxUtil.rxSchedulerHelper())
//        .subscribe()
                .compose(RxUtil.handleResult())
//                .compose(new Observable.Transformer<CoreDataResponse<List<WXItemBean>>, List<WXItemBean>>() {
//
//                    @Override
//                    public Observable<List<WXItemBean>> call(Observable<CoreDataResponse<List<WXItemBean>>> coreDataResponseObservable) {
//                        return coreDataResponseObservable.flatMap(new Func1<CoreDataResponse<List<WXItemBean>>, Observable<?>>() {
//                            @Override
//                            public Observable<?> call(CoreDataResponse<List<WXItemBean>> listCoreDataResponse) {
//                                return null;
//                            }
//                        });
//
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
