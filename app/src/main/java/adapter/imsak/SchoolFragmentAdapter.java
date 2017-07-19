package adapter.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import imsak.company.newline.imsakmobyapp.R;
import model.imask.SchoolModel;
import viewholder.imsak.SchoolViewHolder;

/**
 * Created by HUZY_KAMZ on 2/12/2017.
 */

public class SchoolFragmentAdapter extends RecyclerView.Adapter<SchoolViewHolder> {

    private List<SchoolModel> itemList;
    private Context context;

    public SchoolFragmentAdapter(Context context, List<SchoolModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_school, null);
        SchoolViewHolder rcv = new SchoolViewHolder(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SchoolViewHolder holder, int position) {
        final SchoolModel sr = itemList.get(position);
        holder.school_txt.setText(sr.getSchoolName());


    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
