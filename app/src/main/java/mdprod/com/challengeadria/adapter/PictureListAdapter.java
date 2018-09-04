package mdprod.com.challengeadria.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mdprod.com.challengeadria.R;
import mdprod.com.challengeadria.data.model.Picture;
import mdprod.com.challengeadria.ui.full_picture.FullPictureActivity;
import mdprod.com.challengeadria.util.Constant;

/**
 * Created by mac on 4/09/18.
 */

public class PictureListAdapter extends BaseAdapter {

    private List<Picture> pictureList;
    private Context context;

    public PictureListAdapter(List<Picture> pictureList, Context context) {
        this.context = context;
        this.pictureList = pictureList;
    }

    @Override
    public int getCount() {
        if(pictureList != null){
            return pictureList.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View mView, ViewGroup parent) {

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.picture_item, null);
        ImageView picture =  mView.findViewById(R.id.picture);
        Picasso.get()
                .load(pictureList.get(position).getPictureUrl())
                .into(picture);

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullPictureActivity.class);
                intent.putExtra(Constant.Picture_ID, String.valueOf(pictureList.get(position).getId()));
                context.startActivity(intent);
            }
        });

        return mView;

    }
}
