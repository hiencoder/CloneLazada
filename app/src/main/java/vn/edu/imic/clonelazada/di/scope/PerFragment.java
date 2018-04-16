package vn.edu.imic.clonelazada.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by MyPC on 26/02/2018.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
