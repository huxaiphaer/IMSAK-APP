package viewholder.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import imsak.company.newline.imsakmobyapp.R;


/**
 * Created by HUZY_KAMZ on 2/13/2017.
 */

public class ResultsViewHolder  extends RecyclerView.ViewHolder {

    public View root;
    public TextView schoolname;
    public TextView marks_scored;
    public TextView position_xt;



    public ResultsViewHolder(final View itemView, final Context c) {
        super(itemView);
        root = itemView;

        schoolname = (TextView) itemView.findViewById(R.id.school_results_txt);
        marks_scored=(TextView)itemView.findViewById(R.id.marks_scored_results_txt);
        position_xt=(TextView)itemView.findViewById(R.id.position_txt);

    }
}
