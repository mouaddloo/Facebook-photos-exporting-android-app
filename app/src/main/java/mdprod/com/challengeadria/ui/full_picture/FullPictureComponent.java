package mdprod.com.challengeadria.ui.full_picture;

import dagger.Component;
import mdprod.com.challengeadria.di.ActivityScope;
import mdprod.com.challengeadria.di.component.AppComponent;

/**
 * Created by mac on 3/09/18.
 */


@ActivityScope
@Component(dependencies = AppComponent.class, modules = FullPictureModule.class)
public interface FullPictureComponent {

    void inject(FullPictureActivity activity);

}

