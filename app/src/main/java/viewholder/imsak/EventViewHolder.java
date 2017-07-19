package viewholder.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import imsak.company.newline.imsakmobyapp.R;


/**
 * Created by HUZY_KAMZ on 2/12/2017.
 */

public class EventViewHolder extends RecyclerView.ViewHolder {

    public View root;
    public TextView max_score_txt;
    public TextView event_name_txt_comp;


    public EventViewHolder(final View itemView, final Context c) {
        super(itemView);
        root = itemView;

        max_score_txt = (TextView) itemView.findViewById(R.id.max_score_txt);
        event_name_txt_comp = (TextView) itemView.findViewById(R.id.event_name_txt_comp);
    }
}