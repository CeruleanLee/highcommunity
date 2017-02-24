package cn.hi028.android.highcommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hpw.mvpframe.base.CoreBaseFragment;
import com.hpw.mvpframe.widget.recyclerview.BaseQuickAdapter;
import com.hpw.mvpframe.widget.recyclerview.BaseViewHolder;
import com.hpw.mvpframe.widget.recyclerview.CoreRecyclerView;

/**
 * @说明：
 * @作者： Lee_yting
 * @时间：2017/2/24 0024
 */

public class FriendsshipFrag extends CoreBaseFragment<FriendsshipPresenter, FriendsshipModel> implements Contract.FriendsshipView {

    CoreRecyclerView coreRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FriendsshipFrag: ","onCreate");
    }

    @Override
    public void showContent(CommunityListBean mList) {
        coreRecyclerView.getAdapter().addData(mList.getData());

    }

    @Override
    public View getLayoutView() {

        coreRecyclerView = new CoreRecyclerView(mContext).init(new BaseQuickAdapter<CommunityListBean.CommunityBean, BaseViewHolder>(R.layout.item_msg) {
            @Override
            protected void convert(BaseViewHolder helper, CommunityListBean.CommunityBean item) {
                Glide.with(mContext).load(item.getAg_pic()).crossFade().into((ImageView) helper.getView(R.id.civl_communityItem_avatar));
                helper.setText(R.id.msg_name, item.getTitle())
                        .setText(R.id.msg_time, item.getCreate_time())
                        .setText(R.id.msg_content, item.getContent())
                        .setText(R.id.msg_locaion, item.getSite())
                        .setText(R.id.tv_communityItem_comment, "评论 "+item.getP_count())
                        .setText(R.id.tv_communityItem_Assist, "点赞 "+item.getD_count());
                helper.setOnClickListener(R.id.msg_more, clickListener)
                        .setOnClickListener(R.id.tv_communityItem_Assist, clickListener)
                        .setOnClickListener(R.id.tv_communityItem_comment, clickListener);
                helper.setOnItemClickListener(R.id.msg_item_layout,itemClickListener);
            }
        })
//                .openLoadMore(pageNum, page -> mPresenter.getWechatData(pageNum, page))
//                .openRefresh()
        ;
        return coreRecyclerView;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showError(String msg) {

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.msg_more:
                    showToast("click more");
                    break;
                case R.id.tv_communityItem_Assist:
                    showToast("click Assist");
                    break;
                case R.id.tv_communityItem_comment:
                    showToast("click comment");

                    break;
            }
        }
    };
    AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            showToast("点击第"+position+"个item");
        }
    };
}
