package mdprod.com.challengeadria.ui.login;



import android.content.Intent;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import javax.inject.Inject;

import mdprod.com.challengeadria.ui.user_albums.UserAlbumsActivity;
import mdprod.com.challengeadria.util.Constant;


/**
 * Created by mac on 3/09/18.
 */

public class LoginPresenter implements LoginContract.Presenter{

    LoginContract.View mView;

    @Inject
    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loginClickCallBack(LoginButton loginButton, CallbackManager callbackManager) {

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                if (accessToken.getUserId() != null) {
                    mView.loginSuccess(accessToken.getUserId());
                }
            }

            @Override
            public void onCancel() {}

            @Override
            public void onError(FacebookException exception) {
                mView.loginFailed();
            }
        });
    }
}
