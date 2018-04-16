package vn.edu.imic.clonelazada.screens.intro;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;
import vn.edu.imic.clonelazada.R;
import vn.edu.imic.clonelazada.base.BaseActivity;
import vn.edu.imic.clonelazada.screens.intro.adapter.IntroAdapter;

/**
 * Created by MyPC on 06/03/2018.
 */

public class IntroActivity extends BaseActivity{
    @BindView(R.id.vp_intro)
    ViewPager vpIntro;
    @BindView(R.id.ci_intro)
    CircleIndicator ciIntro;
    private IntroAdapter introAdapter;

    private int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initEvent();
    }

    private void initEvent() {
        vpIntro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        introAdapter = new IntroAdapter(this);
        vpIntro.setAdapter(introAdapter);
        vpIntro.setCurrentItem(0);
        ciIntro.setViewPager(vpIntro);
        //AutoScrollViewPager.pagerSwitcher(3,2,this,vpIntro);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_intro;
    }

    @OnClick({R.id.img_next, R.id.img_back})
    void onClick(View v){
        switch (v.getId()){
            case R.id.img_back:
                handleNextPage();
                break;
            case R.id.img_next:
                handleBackPage();
                break;
        }
    }

    private void handleBackPage() {
        if (page < 3 && page > 0){
            page--;
            vpIntro.setCurrentItem(page);
        }
    }

    private void handleNextPage() {
        if (page < 2){
            page++;
            vpIntro.setCurrentItem(page);
        }
    }
}
