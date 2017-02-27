package cn.hi028.android.highcommunity;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by hpw on 16/10/31.
 */

public interface ZhihuContract {
    //主页接口
    abstract class ZhihuMainPresenter extends CoreBasePresenter<ZhihuMainModel, ZhihuMainView> {
        public abstract void getTabList();
    }

    interface ZhihuMainModel extends CoreBaseModel {
        String[] getTabs();
    }

    interface ZhihuMainView extends CoreBaseView {
        void showTabList(String[] mTabs);
    }




    abstract class WechatPresenter extends CoreBasePresenter<WechatModel, WechatView> {
        public abstract void getWechatData(int num, int page);
    }

    interface WechatModel extends CoreBaseModel {
        Observable<List<WXItemBean>> getWechatData(int num, int page);
    }

    interface WechatView extends CoreBaseView {
        void showContent(List<WXItemBean> mList);
    }
}

