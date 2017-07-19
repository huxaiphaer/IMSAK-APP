package adapter.imsak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import imsak.company.newline.imsakmobyapp.R;
import model.imask.MenuItems;
import viewholder.imsak.MenuViewHolder;

/**
 * Created by HUZY_KAMZ on 12/20/2016.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private List<MenuItems> itemList;
    private Context context;

    public MenuAdapter(Context context, List<MenuItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, null);
        MenuViewHolder rcv = new MenuViewHolder(layoutView, context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {
        final MenuItems sr = itemList.get(position);
        holder.txt_menu.setText(sr.getName());
        holder.img_menu.setImageResource(sr.getPhoto());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Toast.makeText(context, "" + position, Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        break;
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
