package vn.edu.imic.clonelazada.di.component;

import javax.inject.Singleton;

import dagger.Component;
import vn.edu.imic.clonelazada.di.module.SharedPrefModule;
import vn.edu.imic.clonelazada.screens.main.MainActivity;

/**
 * Created by MyPC on 03/03/2018.
 */
@Singleton
@Component(modules = {SharedPrefModule.class})
public interface SharedComponent {
    void inject(MainActivity activity);
}
