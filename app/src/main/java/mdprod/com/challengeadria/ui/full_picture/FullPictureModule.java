package mdprod.com.challengeadria.ui.full_picture;

import dagger.Module;
import dagger.Provides;
import mdprod.com.challengeadria.di.ActivityScope;

/**
 * Created by mac on 3/09/18.
 */

@Module
public class FullPictureModule {

    private FullPictureContract.View mView;


    public FullPictureModule(FullPictureContract.View mView) {
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    public FullPictureContract.View provideContext(){
        return mView;
    }

}


