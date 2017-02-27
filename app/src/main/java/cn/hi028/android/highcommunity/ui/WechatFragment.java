package cn.hi028.android.highcommunity.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;
import com.hpw.mvpframe.widget.recyclerview.CoreRecyclerView;

import java.util.List;

import cn.hi028.android.highcommunity.R;
import cn.hi028.android.highcommunity.WXItemBean;
import cn.hi028.android.highcommunity.ZhihuContract;
import cn.hi028.android.highcommunity.model.WechatModel;
import cn.hi028.android.highcommunity.presenter.WechatPresenter;

/**
 * Created by hpw on 16/11/6.
 */

public class WechatFragment extends CoreBaseFragment<WechatPresenter, WechatModel> implements ZhihuContract.WechatView {
    CoreRecyclerView coreRecyclerView;
    private static int pageNum = 50;

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public View getLayoutView() {
        coreRecyclerView = new CoreRecyclerView(mContext).init(new BaseQuickAdapter<WXItemBean, BaseViewHolder>(R.layout.item_msg) {
            @Override
            protected void convert(BaseViewHolder helper, WXItemBean item) {
                Log.e("xx ","convert:"+item.getTitle());
//                Glide.with(mContext).load(item.getPicUrl()).crossFade().into((ImageView) helper.getView(R.id.iv_wechat_item_image));
//                helper.setText(R.id.tv_wechat_item_title, item.getTitle())
//                        .setText(R.id.tv_wechat_item_from, item.getDescription())
//                        .setText(R.id.tv_wechat_item_time, item.getCtime())
//                        .setOnClickListener(R.id.ll_click, v -> {
//                            WechatDetailsActivity.start(mContext, item.getTitle(), item.getUrl());
//                        });
            }
        })
//                .openLoadMore(pageNum, page -> mPresenter.getWechatData(pageNum, page))
//                .openRefresh()
        ;
        return coreRecyclerView;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showContent(List<WXItemBean> mList) {
        coreRecyclerView.getAdapter().addData(mList);
    }

    @Override
    public void showError(String msg) {
        showToast(msg + " api key失效,自己去http://www.tianapi.com/#wxnew申请key");
    }
}
