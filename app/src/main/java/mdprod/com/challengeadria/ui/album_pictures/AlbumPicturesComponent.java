package mdprod.com.challengeadria.ui.album_pictures;

import dagger.Component;
import mdprod.com.challengeadria.di.ActivityScope;
import mdprod.com.challengeadria.di.component.AppComponent;


/**
 * Created by mac on 3/09/18.
 */


@ActivityScope
@Component(dependencies = AppComponent.class, modules = AlbumPicturesModule.class)
public interface AlbumPicturesComponent {

    void inject(AlbumPicturesActivity activity);

}

