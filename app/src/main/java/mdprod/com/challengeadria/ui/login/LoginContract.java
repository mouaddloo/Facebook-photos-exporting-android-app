package mdprod.com.challengeadria.ui.login;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.GraphResponse;
import com.facebook.login.widget.LoginButton;

/**
 * Created by mac on 3/09/18.
 */

public class LoginContract {

    interface View {
        void loginSuccess(String userId);
        void loginFailed();
    }

    interface Presenter {
        void loginClickCallBack(LoginButton loginButton, CallbackManager callbackManager);
    }
}
