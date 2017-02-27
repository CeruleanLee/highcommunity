package cn.hi028.android.highcommunity.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hpw.mvpframe.base.CoreBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hi028.android.highcommunity.R;

public class PublishActivity extends CoreBaseActivity {


    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.tochooseLoc)
    ImageView tochooseLoc;
    @BindView(R.id.rylistview_imgs)
    GridView rylistviewImgs;
    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.tv_publish)
    TextView tv_publish;

    @Override
    public int getLayoutId() {
        return R.layout.act_publish;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tv_publish.setOnClickListener(clickListener);
        tochooseLoc.setOnClickListener(clickListener);
        edContent.setFocusable(true);
        edContent.setFocusableInTouchMode(true);
        edContent.requestFocus();
       InputMethodManager inputManager = (InputMethodManager)edContent.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(edContent, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_publish:
                    publish();
                break;
                case R.id.tochooseLoc:
                    tochooseLoc();
                break;
            }
        }


    };

    /**
     * 选择发帖地址
     */
    private void tochooseLoc() {

    }

    /**
     * 发帖
     */
    private void publish() {

    }
}
