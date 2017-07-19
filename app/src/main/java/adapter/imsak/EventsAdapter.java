package adapter.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import imsak.company.newline.imsakmobyapp.R;
import model.imask.EventsModel;
import viewholder.imsak.EventViewHolder;

/**
 * Created by HUZY_KAMZ on 2/12/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<EventsModel> itemList;
    private Context context;

    public EventsAdapter(Context context, List<EventsModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_event, null);
        EventViewHolder rcv = new EventViewHolder(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final EventsModel sr = itemList.get(position);
        holder.event_name_txt_comp.setText(sr.getEventName());
        holder.max_score_txt.setText(sr.getMaximumScore());


    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
