package vn.edu.imic.clonelazada.screens.intro.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.imic.clonelazada.R;

/**
 * Created by MyPC on 06/03/2018.
 */

public class IntroAdapter extends PagerAdapter{
    private Context context;
    private int[] intro = {R.layout.intro_screen1,R.layout.intro_screen2,R.layout.intro_screen3};

    public IntroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(intro[position],null);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
