package mdprod.com.challengeadria.ui.user_albums;

import dagger.Component;
import mdprod.com.challengeadria.di.ActivityScope;
import mdprod.com.challengeadria.di.component.AppComponent;

/**
 * Created by mac on 3/09/18.
 */


@ActivityScope
@Component(dependencies = AppComponent.class, modules = UserAlbumsModule.class)

public interface UserAlbumsComponent {

    void inject(UserAlbumsActivity activity);

}

