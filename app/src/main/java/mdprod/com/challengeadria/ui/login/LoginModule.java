package mdprod.com.challengeadria.ui.login;

import dagger.Module;
import dagger.Provides;
import mdprod.com.challengeadria.di.ActivityScope;

/**
 * Created by mac on 3/09/18.
 */

@Module
public class LoginModule {

    private LoginContract.View mView;


    public LoginModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    public LoginContract.View provideContext(){
        return mView;
    }

}


