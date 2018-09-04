package mdprod.com.challengeadria.ui.full_picture;

import com.facebook.GraphResponse;

/**
 * Created by mac on 3/09/18.
 */

public class FullPictureContract {

    interface View {
        void showPicture(String pictureUrl);
    }

    interface Presenter {
        void getPicture(String pictureId);
        void extractPictureData(GraphResponse response);
    }
}
