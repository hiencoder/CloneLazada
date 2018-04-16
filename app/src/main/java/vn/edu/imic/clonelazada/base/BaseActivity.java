package vn.edu.imic.clonelazada.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import vn.edu.imic.clonelazada.R;
import vn.edu.imic.clonelazada.screens.main.MainActivity;

/**
 * Created by MyPC on 26/02/2018.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutResourceId();

    public boolean dispatchTouchEvent(MotionEvent ev){
        View v = getCurrentFocus();
        if (v != null && ((ev.getAction() == MotionEvent.ACTION_UP
                || ev.getAction() == MotionEvent.ACTION_MOVE) && (v instanceof EditText)
                && !v.getClass().getName().startsWith("android.webkit."))) {
            int[] scrcoords = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = (ev.getRawX() + ((float) v.getLeft())) - ((float) scrcoords[0]);
            float y = (ev.getRawY() + ((float) v.getTop())) - ((float) scrcoords[1]);
            if (x < ((float) v.getLeft())
                    || x > ((float) v.getRight())
                    || y < ((float) v.getTop())
                    || y > ((float) v.getBottom())) {
                hideKeyboard(this);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Phương thức ẩn bàn phím
     * @param activity
     */
    private void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null
                && activity.getWindow().getDecorView() != null) {
            ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(
                            activity.getWindow().getDecorView().getWindowToken(), 0);
        }

    }

    /**
     *
     * @param containerViewId
     * @param fragment
     * @param fragmentTag
     * @param isAddToBackStack
     */
    protected void addFragment(int containerViewId, Fragment fragment,
                               String fragmentTag, boolean isAddToBackStack){
        try{
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(containerViewId,fragment,fragmentTag);
            if (isAddToBackStack){
                transaction.addToBackStack(fragmentTag);
            }else {
                transaction.disallowAddToBackStack();
            }
            transaction.commitAllowingStateLoss();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param containerViewId
     * @param fragment
     * @param fragmentTag
     * @param isAddToBackStack
     */
    protected void replaceFragment(int containerViewId, Fragment fragment,
                                   String fragmentTag, boolean isAddToBackStack){
        try{
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(containerViewId,fragment,fragmentTag);
            if (isAddToBackStack){
                transaction.addToBackStack(fragmentTag);
            }else {
                transaction.disallowAddToBackStack();
            }
            transaction.commitAllowingStateLoss();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Phương thức show toast
    public void showToast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    //Phương thức show long toast
    public void showLongToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    //Phương thức show snackbar vs time LENG_SHORT
    public void showSnackBar(Activity context, String message){
        Snackbar.make(context.findViewById(R.id.activity_main),message,Snackbar.LENGTH_SHORT).show();
    }

    //Phương thức show snackbar vs time duration
    public void showSnackbar(Activity context, String message, int duration){
        Snackbar.make(context.findViewById(R.id.activity_main),message,duration).show();
    }

    //Phương thức hiển thị dialog
    protected void showDialog(String message){
        if (progressDialog == null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(true);
        }
        progressDialog.show();
    }

    //Phương thức ẩn dialog
    protected void hideDialog(){
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    //Điều hướng về MainActivity
    protected void navigateMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //Phương thức exit app
    public void exitApp(){
        finish();
        killApp();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void killApp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                Process.killProcess(Process.myPid());
            }
        }).start();
    }
}
