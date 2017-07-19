package adapter.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import imsak.company.newline.imsakmobyapp.R;
import model.imask.Results;
import viewholder.imsak.ResultsViewHolder;

/**
 * Created by HUZY_KAMZ on 2/13/2017.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsViewHolder> {

    private List<Results> itemList;
    private Context context;

    public ResultsAdapter(Context context, List<Results> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ResultsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_results, null);
        ResultsViewHolder rcv = new ResultsViewHolder(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ResultsViewHolder holder, int position) {

        int answer;

        answer = position + 1;
        final Results sr = itemList.get(position);
        holder.schoolname.setText(sr.getSchoolName());
        holder.marks_scored.setText(sr.getMarkScored() + "%");
        holder.position_xt.setText("" + answer + "");


    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
