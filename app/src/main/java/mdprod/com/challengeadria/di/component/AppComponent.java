package mdprod.com.challengeadria.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import mdprod.com.challengeadria.di.module.AppModule;

/**
 * Created by mac on 3/09/18.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Application application();
}
