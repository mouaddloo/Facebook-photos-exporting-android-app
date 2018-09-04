package mdprod.com.challengeadria.ui.user_albums;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mdprod.com.challengeadria.App;
import mdprod.com.challengeadria.R;
import mdprod.com.challengeadria.adapter.AlbumListAdapter;
import mdprod.com.challengeadria.data.model.Album;
import mdprod.com.challengeadria.ui.base.BaseActivity;
import mdprod.com.challengeadria.util.Constant;

public class UserAlbumsActivity extends BaseActivity implements UserAlbumsContract.View {

    @BindView(R.id.album_list) RecyclerView albumList;

    @Inject
    UserAlbumsPresenter presenter;


    String userId;
    AlbumListAdapter albumListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_albums);

        DaggerUserAlbumsComponent.builder()
                .appComponent(((App)getApplicationContext()).getAppComponent())
                .userAlbumsModule(new UserAlbumsModule(this))
                .build()
                .inject(this);


        userId = getIntent().getStringExtra(Constant.User_ID);
        if(userId != null){
            presenter.getAlbums(userId);
        }


    }

    @Override
    public void showAlbumList(List<Album> listAlbum) {
        albumListAdapter = new AlbumListAdapter(listAlbum, this);
        LinearLayoutManager layoutManager =  new GridLayoutManager(getApplicationContext(), 2);
        albumList.setLayoutManager(layoutManager);
        albumList.setAdapter(albumListAdapter);
    }
}
