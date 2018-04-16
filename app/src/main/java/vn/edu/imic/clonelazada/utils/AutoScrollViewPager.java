package vn.edu.imic.clonelazada.utils;

import android.app.Activity;
import android.support.v4.view.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MyPC on 12/03/2018.
 */

public class AutoScrollViewPager {
    private static Timer timer;
    public static void pagerSwitcher(int seconds, int numberPage,Activity activity, ViewPager viewPager){
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(activity,viewPager,numberPage),0,seconds * 1000);
    }

    public static class RemindTask extends TimerTask{
        Activity context;
        ViewPager viewPager;
        int page = 0;
        int numberPage;
        public RemindTask(Activity context, ViewPager viewPager, int numberPage){
            this.context = context;
            this.viewPager = viewPager;
            this.numberPage = numberPage;
        }
        @Override
        public void run() {
            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page > numberPage){
                        page = 0;
                        //timer.cancel();
                    }else {
                        viewPager.setCurrentItem(page++);
                    }
                }
            });
        }
    }
}
