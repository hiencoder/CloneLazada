package vn.edu.imic.clonelazada.screens.loginandregister;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.BindView;
import butterknife.OnClick;
import vn.edu.imic.clonelazada.R;
import vn.edu.imic.clonelazada.base.BaseActivity;
import vn.edu.imic.clonelazada.screens.loginandregister.adapter.MyPagerAdapter;

/**
 * Created by MyPC on 26/02/2018.
 */

public class LoginAndRegisterActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar tbLoginAndRegister;
    private PagerSlidingTabStrip pstsLoginAndRegister;
    private ViewPager vpLoginAndRegister;
    private MyPagerAdapter myPagerAdapter;
    private LinearLayout llMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(tbLoginAndRegister);
        //Init dữ liệu
        initView();
        initData();

/*
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vpLoginAndRegister.setAdapter(myPagerAdapter);
        pstsLoginAndRegister.setViewPager(vpLoginAndRegister);
*/
    }

    //initdata
    private void initData() {
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vpLoginAndRegister.setAdapter(myPagerAdapter);
        pstsLoginAndRegister.setViewPager(vpLoginAndRegister);
        vpLoginAndRegister.setCurrentItem(0);
    }

    //init view
    private void initView() {
        //pstsLoginAndRegister = (PagerSlidingTabStrip) findViewById(R.id.pager_sliding_tabtrip);
        llMain = (LinearLayout) findViewById(R.id.activity_login_and_register);
        pstsLoginAndRegister = new PagerSlidingTabStrip(this);
        pstsLoginAndRegister.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50));
        pstsLoginAndRegister.setShouldExpand(true);
        pstsLoginAndRegister.setAllCaps(false);
        pstsLoginAndRegister.setTextSize(25);
        pstsLoginAndRegister.setTextColor(getResources().getColor(R.color.colorOrange));
        //pstsLoginAndRegister.setDividerColor(getResources().getColor(R.color.colorOrange));
        pstsLoginAndRegister.setDividerPadding(4);
        pstsLoginAndRegister.setIndicatorColor(getResources().getColor(R.color.colorOrange));
        pstsLoginAndRegister.setIndicatorHeight(3);
        //pstsLoginAndRegister.setUnderlineColor(getResources().getColor(R.color.colorOrange));

        llMain.addView(pstsLoginAndRegister);

        vpLoginAndRegister = (ViewPager) getLayoutInflater()
                .inflate(R.layout.layout_view_pager,null)
                .findViewById(R.id.view_pager);
        llMain.addView(vpLoginAndRegister);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login_and_register;
    }

    @OnClick(R.id.btn_close)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_close:
                onBackPressed();
                break;
        }
    }
}
