package mdprod.com.challengeadria.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

import butterknife.ButterKnife;
import mdprod.com.challengeadria.R;
import mdprod.com.challengeadria.ui.login.LoginActivity;

/**
 * Created by mac on 4/09/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private CallbackManager mCallBackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCallBackManager = CallbackManager.Factory.create();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public void initView() {
    }


    private void bindViews() {
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                LoginManager.getInstance().logOut();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
