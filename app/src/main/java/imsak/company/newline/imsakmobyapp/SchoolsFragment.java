package imsak.company.newline.imsakmobyapp;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import adapter.imsak.SchoolFragmentAdapter;
import model.imask.SchoolModel;


/**
 * Created by HUZY_KAMZ on 2/11/2017.
 */

public class SchoolsFragment extends Fragment {
    private Context c;
    private RecyclerView rv;

    ProgressBar pd;
   /* public SchoolsFragment() {
        // Required empty public constructor
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_video_fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_schools, container, false);
        rv = (RecyclerView) v.findViewById(R.id.rv_frag_schools);
        pd = (ProgressBar) v.findViewById(R.id.progressBar_schools);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(c));

        Load();

        return v;
    }


    public void Load() {


        View v = null;

        Intent i = getActivity().getIntent();
        String compId = i.getStringExtra("COMP_ID");

        // 192.168.43.104
        final String url = "http://imsakug.org/Mobile/Default.aspx?DataFormat=Schools&CompID=" + compId;


        pd.setVisibility(View.VISIBLE);


        Ion.with(SchoolsFragment.this)
                .load(url)
                .progressBar(pd)
                .as(new TypeToken<List<SchoolModel>>() {
                })
                .setCallback(new FutureCallback<List<SchoolModel>>() {

                    @Override
                    public void onCompleted(Exception e, List<SchoolModel> itemList) {
                        final SchoolFragmentAdapter adapter = new SchoolFragmentAdapter(c, itemList);

                        try {


                            rv.setAdapter(adapter);
                            rv.hasFixedSize();
                            rv.setLayoutManager(new LinearLayoutManager(c));


                            pd.setVisibility(View.INVISIBLE);
                        } catch (Exception ex) {
                            Toast.makeText(c, "No Internet Connection!", Toast.LENGTH_SHORT).show();
                            pd.setVisibility(View.INVISIBLE);
                        }
                    }
                });


    }


}