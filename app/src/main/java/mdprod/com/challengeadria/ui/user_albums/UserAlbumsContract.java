package mdprod.com.challengeadria.ui.user_albums;

import com.facebook.GraphResponse;

import org.json.JSONArray;

import java.util.List;

import mdprod.com.challengeadria.data.model.Album;

/**
 * Created by mac on 3/09/18.
 */

public class UserAlbumsContract {

    interface View {
        void showAlbumList(List<Album> listAlbum);

    }

    interface Presenter {
        void getAlbums(String userId);
        void extractAlbumsData(GraphResponse response);
    }
}
