package viewholder.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import imsak.company.newline.imsakmobyapp.R;


/**
 * Created by HUZY_KAMZ on 2/12/2017.
 */


public class SchoolViewHolder extends RecyclerView.ViewHolder {

    public View root;
    public TextView school_txt;


    public SchoolViewHolder(final View itemView, final Context c) {
        super(itemView);
        root = itemView;

        school_txt = (TextView) itemView.findViewById(R.id.school_txt);


    }
}

