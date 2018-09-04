package mdprod.com.challengeadria;

import android.app.Application;

import butterknife.ButterKnife;
import mdprod.com.challengeadria.di.component.AppComponent;
import mdprod.com.challengeadria.di.component.DaggerAppComponent;
import mdprod.com.challengeadria.di.module.AppModule;

/**
 * Created by mac on 3/09/18.
 */

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
