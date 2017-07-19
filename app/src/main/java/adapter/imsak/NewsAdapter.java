package adapter.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import imsak.company.newline.imsakmobyapp.R;
import model.imask.News;
import viewholder.imsak.NewsViewHolder;

/**
 * Created by HUZY_KAMZ on 12/20/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<News> itemList;
    private Context context;

    public NewsAdapter(Context context, List<News> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null);
        NewsViewHolder rcv = new NewsViewHolder(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final News sr = itemList.get(position);
        holder.headlines.setText(sr.getHeadlines());
        holder.details.setText(sr.getDetails());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
