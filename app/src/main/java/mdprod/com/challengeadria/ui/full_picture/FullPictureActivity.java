package mdprod.com.challengeadria.ui.full_picture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mdprod.com.challengeadria.App;
import mdprod.com.challengeadria.R;
import mdprod.com.challengeadria.ui.base.BaseActivity;
import mdprod.com.challengeadria.util.Constant;

public class FullPictureActivity extends BaseActivity implements FullPictureContract.View {

    @BindView(R.id.full_picture) ImageView fullPicture;

    @Inject
    FullPicturePresenter presenter;

    String pictureId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_picture);

        DaggerFullPictureComponent.builder()
                .appComponent(((App)getApplicationContext()).getAppComponent())
                .fullPictureModule(new FullPictureModule(this))
                .build()
                .inject(this);

        pictureId = getIntent().getStringExtra(Constant.Picture_ID);
        if(pictureId != null){
            presenter.getPicture(pictureId);
        }

    }

    @Override
    public void showPicture(String pictureUrl) {
        Picasso.get()
                .load(pictureUrl)
                .into(fullPicture);
    }
}
