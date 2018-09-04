package mdprod.com.challengeadria.ui.album_pictures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mdprod.com.challengeadria.App;
import mdprod.com.challengeadria.R;
import mdprod.com.challengeadria.adapter.PictureListAdapter;
import mdprod.com.challengeadria.data.model.Picture;
import mdprod.com.challengeadria.ui.base.BaseActivity;
import mdprod.com.challengeadria.util.Constant;


public class AlbumPicturesActivity extends BaseActivity implements AlbumPicturesContract.View{

    @BindView(R.id.picture_grid) GridView pictureGrid;

    @Inject
    AlbumPicturesPresenter presenter;

    String albumId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_pictures);

        DaggerAlbumPicturesComponent.builder()
                .appComponent(((App)getApplicationContext()).getAppComponent())
                .albumPicturesModule(new AlbumPicturesModule(this))
                .build()
                .inject(this);

        albumId = getIntent().getStringExtra(Constant.Album_ID);
        if(albumId != null){
            presenter.getAlbumPictures(albumId);
        }

    }


    @Override
    public void showPictureGrid(List<Picture> listPicture) {
        pictureGrid.setAdapter(new PictureListAdapter(listPicture,this));
    }
}
