package mdprod.com.challengeadria.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mdprod.com.challengeadria.App;
import mdprod.com.challengeadria.R;
import mdprod.com.challengeadria.ui.base.BaseActivity;
import mdprod.com.challengeadria.ui.user_albums.UserAlbumsActivity;
import mdprod.com.challengeadria.util.Constant;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.login_button) LoginButton loginButton;

    @Inject
    LoginPresenter presenter;

    CallbackManager callbackManager;
    AccessToken accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .appComponent(((App)getApplicationContext()).getAppComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        callbackManager = CallbackManager.Factory.create();
        accessToken = AccessToken.getCurrentAccessToken();

        if(accessToken != null && !accessToken.isExpired()){
            loginSuccess(accessToken.getUserId());
        }else {
            loginButton.setReadPermissions("user_photos");
            presenter.loginClickCallBack(loginButton,callbackManager);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void loginSuccess(String userId) {
        Intent intent = new Intent(LoginActivity.this,UserAlbumsActivity.class);
        intent.putExtra(Constant.User_ID,userId);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
    }
}
