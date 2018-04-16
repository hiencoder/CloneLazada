package vn.edu.imic.clonelazada.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MyPC on 02/03/2018.
 */
@Module
public class SharedPrefModule {
    private Context context;

    public SharedPrefModule(Context context){
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
