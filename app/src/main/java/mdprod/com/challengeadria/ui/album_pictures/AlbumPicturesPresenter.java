package mdprod.com.challengeadria.ui.album_pictures;

import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;

import mdprod.com.challengeadria.data.model.Picture;


/**
 * Created by mac on 3/09/18.
 */

public class AlbumPicturesPresenter implements AlbumPicturesContract.Presenter{

    AlbumPicturesContract.View mView;

    @Inject
    public AlbumPicturesPresenter(AlbumPicturesContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getAlbumPictures(String AlbumId) {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/"+AlbumId+"/photos?fields=picture",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.i("AlbumPicture_FB",response.toString());
                        extractAlbumPicturesData(response);
                    }
                }
        ).executeAsync();
    }

    @Override
    public void extractAlbumPicturesData(GraphResponse response) {
        ArrayList<Picture> pictures = new ArrayList<>();
        try {
            JSONObject dataResponse = response.getJSONObject();
            JSONArray data = dataResponse.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                pictures.add(new Picture(
                        data.getJSONObject(i).getString("id"),
                        data.getJSONObject(i).getString("picture")
                ));
            }
            mView.showPictureGrid(pictures);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
