package vn.edu.imic.clonelazada.screens.main;

import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import vn.edu.imic.clonelazada.R;
import vn.edu.imic.clonelazada.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @BindView(R.id.bb_menu)
    BottomBar bbMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvents();
    }

    private void initEvents() {
        bbMenu.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.tab_trangchu:

                        break;
                    case R.id.tab_nganhhang:
                        break;
                    case R.id.tab_giohang:
                        break;
                    case R.id.tab_taikhoan:
                        break;
                }
            }
        });

        bbMenu.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                switch (tabId){
                    case R.id.tab_trangchu:
                        break;
                    case R.id.tab_nganhhang:
                        break;
                    case R.id.tab_giohang:
                        break;
                    case R.id.tab_taikhoan:
                        break;
                }
            }
        });
    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }
}
