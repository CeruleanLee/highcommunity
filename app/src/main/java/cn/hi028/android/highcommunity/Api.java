package cn.hi028.android.highcommunity;

import com.hpw.mvpframe.data.entity.CoreDataResponse;

import retrofit2.http.POST;
import rx.Observable;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public interface Api {
    String HOST = "http://028hi.cn/api/";
    /**
     * 获取msg列表
     */
    @POST("smessage/index.html")
    Observable<CoreDataResponse<CommunityListBean>> getMsgList();

}
