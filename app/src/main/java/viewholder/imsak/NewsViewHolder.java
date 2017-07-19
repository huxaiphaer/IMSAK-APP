package viewholder.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import imsak.company.newline.imsakmobyapp.R;


/**
 * Created by HUZY_KAMZ on 2/9/2017.
 */

public class NewsViewHolder  extends RecyclerView.ViewHolder {

    public View root;
    public TextView headlines;
    public TextView details;
    public ImageView newsImage;


    public NewsViewHolder(final View itemView, final Context c) {
        super(itemView);
        root = itemView;
        newsImage =(ImageView)itemView.findViewById(R.id.image_News);
        headlines = (TextView) itemView.findViewById(R.id.newsheadlines);
        details=(TextView)itemView.findViewById(R.id.newsdetails);


    }
}
