package mdprod.com.challengeadria.ui.login;

import dagger.Component;
import mdprod.com.challengeadria.di.ActivityScope;
import mdprod.com.challengeadria.di.component.AppComponent;

/**
 * Created by mac on 3/09/18.
 */


@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity activity);

}

