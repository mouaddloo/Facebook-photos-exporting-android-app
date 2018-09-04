package mdprod.com.challengeadria.ui.album_pictures;

import com.facebook.GraphResponse;

import java.util.List;

import mdprod.com.challengeadria.data.model.Picture;

/**
 * Created by mac on 3/09/18.
 */

public class AlbumPicturesContract {

    interface View {
        void showPictureGrid(List<Picture> listPicture);

    }

    interface Presenter {
        void getAlbumPictures(String AlbumId);
        void extractAlbumPicturesData(GraphResponse response);
    }
}
