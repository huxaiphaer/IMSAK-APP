package viewholder.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



import imsak.company.newline.imsakmobyapp.R;


/**
 * Created by HUZY_KAMZ on 2/11/2017.
 */

public class AIC_ViewHolder   extends RecyclerView.ViewHolder {

    public View root;
    public TextView competition_name_txt;
    public TextView year_txt;
  //  public TextView date_txt;
    public TextView venue_txt;


    public AIC_ViewHolder(final View itemView, final Context c) {
        super(itemView);
        root = itemView;

        competition_name_txt = (TextView) itemView.findViewById(R.id.competition_name_txt);
        year_txt=(TextView)itemView.findViewById(R.id.year_txt);
       // date_txt=(TextView)itemView.findViewById(R.id.date_txt);
        venue_txt=(TextView)itemView.findViewById(R.id.venue_txt);

    }
}