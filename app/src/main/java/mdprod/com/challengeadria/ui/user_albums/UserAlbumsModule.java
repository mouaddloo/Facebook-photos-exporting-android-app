package mdprod.com.challengeadria.ui.user_albums;

import dagger.Module;
import dagger.Provides;
import mdprod.com.challengeadria.di.ActivityScope;

/**
 * Created by mac on 3/09/18.
 */

@Module
public class UserAlbumsModule {

    private UserAlbumsContract.View mView;


    public UserAlbumsModule(UserAlbumsContract.View mView) {
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    public UserAlbumsContract.View provideContext(){
        return mView;
    }

}


