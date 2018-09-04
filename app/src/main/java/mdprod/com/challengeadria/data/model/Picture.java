package mdprod.com.challengeadria.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2/09/18.
 */

public class Picture {

    String id;
    String pictureUrl;

    public Picture() {

    }

    public Picture(String id, String pictureUrl) {
        this.id = id;
        this.pictureUrl = pictureUrl;
    }

    public String getId() {
        return id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public ArrayList<String> getPictureUrlList(List<Picture> pics) {

        ArrayList<String> pictureList = new ArrayList<>();
        for(int i=0;i<pics.size();i++){
            pictureList.add(pics.get(i).getPictureUrl());
        }
        return pictureList;
    }

}
