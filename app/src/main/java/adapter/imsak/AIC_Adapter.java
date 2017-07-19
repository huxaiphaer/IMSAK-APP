package adapter.imsak;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.List;


import imsak.company.newline.imsakmobyapp.MainActivity;
import imsak.company.newline.imsakmobyapp.R;
import model.imask.AIC_Model;

import viewholder.imsak.AIC_ViewHolder;


/**
 * Created by HUZY_KAMZ on 2/10/2017.
 */

public class AIC_Adapter  extends RecyclerView.Adapter<AIC_ViewHolder> {

    private List<AIC_Model> itemList;
    private Context context;

    public AIC_Adapter(Context context, List<AIC_Model> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public AIC_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_aic, null);
        AIC_ViewHolder rcv = new AIC_ViewHolder(layoutView,context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(AIC_ViewHolder holder, int position) {
        final  AIC_Model sr = itemList.get(position);

        holder.competition_name_txt.setText(sr.getCompName());
        holder.year_txt.setText(sr.getCompYear());
      // holder.date_txt.setText(sr.getCompDate());
        holder.venue_txt.setText(sr.getCompVenue());

        final String COMP_ID = sr.getCompID();
        final String COMP_NAME = sr.getCompName();

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AIC_Adapter.this.context, MainActivity.class);
                i.putExtra("COMP_ID",COMP_ID);
                i.putExtra("COMP_NAME",COMP_NAME);
              //  Toast.makeText(AIC_Adapter.this.context,""+COMP_ID,Toast.LENGTH_LONG).show();
                context.startActivity(i);
            }
        });

    }



        @Override
        public int getItemCount () {

        return this.itemList.size();


    }

}
