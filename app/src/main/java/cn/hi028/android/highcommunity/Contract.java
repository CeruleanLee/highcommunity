package cn.hi028.android.highcommunity;

import com.hpw.mvpframe.base.CoreBaseModel;
import com.hpw.mvpframe.base.CoreBasePresenter;
import com.hpw.mvpframe.base.CoreBaseView;
import com.hpw.mvpframe.data.entity.CoreDataResponse;

import rx.Observable;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public interface Contract {

    abstract class FriendsshipPresenter extends CoreBasePresenter<FriendsshipModel, FriendsshipView> {
        public abstract void getMsgData(int num, int page);
    }
    interface FriendsshipModel extends CoreBaseModel {
        Observable<CommunityListBean> getFriendsshipData();
    }

    interface FriendsshipView extends CoreBaseView {
        void showContent(CommunityListBean mList);
    }

    //主页
    abstract class MainPresenter extends CoreBasePresenter<MainModel, MainView> {
        public abstract void getTabList();
    }

    interface MainModel extends CoreBaseModel {
        String[] getTabs();
    }

    interface MainView extends CoreBaseView {
        void showTabList(String[] mTabs);
    }
}
