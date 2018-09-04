package mdprod.com.challengeadria.ui.album_pictures;

import dagger.Module;
import dagger.Provides;
import mdprod.com.challengeadria.di.ActivityScope;

/**
 * Created by mac on 3/09/18.
 */

@Module
public class AlbumPicturesModule {

    private AlbumPicturesContract.View mView;


    public AlbumPicturesModule(AlbumPicturesContract.View mView) {
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    public AlbumPicturesContract.View provideContext(){
        return mView;
    }

}


