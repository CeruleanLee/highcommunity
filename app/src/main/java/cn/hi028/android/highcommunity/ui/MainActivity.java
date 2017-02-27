package cn.hi028.android.highcommunity.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.hpw.mvpframe.base.CoreBaseActivity;

import butterknife.BindView;
import cn.hi028.android.highcommunity.R;

public class MainActivity extends CoreBaseActivity {

    @BindView(R.id.layout_container)
    LinearLayout layout_container;



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
//        StatusBarUtil.setTransparent(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        if (savedInstanceState == null) {
            loadRootFragment(R.id.layout_container, MainFragment.newInstance(0));
        }
//        recycleAdapter= new MyRecyclerAdapter(MainActivity.this , mDatas );
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        //设置布局管理器
//        recyclerView.setLayoutManager(layoutManager);
//        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//        //设置Adapter
//        recyclerView.setAdapter( recycleAdapter);
//        //设置增加或删除条目的动画
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
