package vn.edu.imic.clonelazada.screens.loginandregister.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.edu.imic.clonelazada.screens.loginandregister.fragment.FragmentLogin;
import vn.edu.imic.clonelazada.screens.loginandregister.fragment.FragmentRegister;

/**
 * Created by MyPC on 05/03/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentLogin();
                break;
            case 1:
                fragment = new FragmentRegister();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Đăng nhập";
                break;
            case 1:
                title = "Đăng ký";
                break;
            default:
                title = "";
                break;
        }
        return title;
    }
}
