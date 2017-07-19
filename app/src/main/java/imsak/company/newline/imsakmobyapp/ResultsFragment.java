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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import adapter.imsak.ResultsAdapter;
import model.imask.EventsModel;
import model.imask.Results;

/**
 * Created by HUZY_KAMZ on 2/11/2017.
 */

public class ResultsFragment extends Fragment {

    private Spinner categories;
    private Intent inn;
    private String EventId = "";
    ProgressBar pd;
    private RecyclerView rv;
    private Context c;
    String num = "";

    public ResultsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_video_fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_results, container, false);


        categories = (Spinner) v.findViewById(R.id.spinner_results);
        inn = getActivity().getIntent();
        EventId = inn.getStringExtra("EventId");


        rv = (RecyclerView) v.findViewById(R.id.rv_results);
        pd = (ProgressBar) v.findViewById(R.id.progressBar_results);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(c));


        SpinnerItemsList();


        return v;
    }


    private void SpinnerItemsList() {

        Intent i = getActivity().getIntent();
        final String compId = i.getStringExtra("COMP_ID");


        Toast.makeText(getActivity(), "" + compId, Toast.LENGTH_LONG).show();

        // 192.168.43.104
        final String url = "http://imsakug.org/Mobile/Default.aspx?DataFormat=EventsByCompetition&CompID=" + compId;


        Ion.with(ResultsFragment.this)
                .load(url)
                .progressBar(pd)
                .as(new TypeToken<List<EventsModel>>() {
                })
                .setCallback(new FutureCallback<List<EventsModel>>() {

                    @Override
                    public void onCompleted(Exception e, final List<EventsModel> itemList) {

                        try {

                            final List<String> items = new ArrayList<String>();


                            for (int i = 0; i < itemList.size(); i++) {
                                items.add(itemList.get(i).getEventName());


                                ArrayAdapter<String> resdap = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);

                                resdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                // Attach the Adapter.
                                categories.setAdapter(resdap);
                                categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        EventsModel selectEvent = itemList.get(position);
                                        //  Toast.makeText(getActivity(),""+selectEvent.getEventID(),Toast.LENGTH_LONG).show();
                                        Load(selectEvent.getEventID().toString(), compId);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }


                        } catch (Exception ex) {
                            Toast.makeText(getActivity(), "There was a problem in loading " + ex, Toast.LENGTH_SHORT).show();
                            System.out.println("Error " + ex);
                            pd.setVisibility(View.INVISIBLE);
                        }
                    }
                });


    }


    public void Load(String EventId, String CompId) {


        Intent i = getActivity().getIntent();
        String compId = i.getStringExtra("COMP_ID");

        // 192.168.43.104
        final String url = "http://imsakug.org/Mobile/Default.aspx?DataFormat=OverallResults&EID=" + EventId + "&CompID=" + CompId;


        pd.setVisibility(View.VISIBLE);


        Ion.with(ResultsFragment.this)
                .load(url)
                .progressBar(pd)
                .as(new TypeToken<List<Results>>() {
                })
                .setCallback(new FutureCallback<List<Results>>() {

                    @Override
                    public void onCompleted(Exception e, List<Results> itemList) {
                        final ResultsAdapter adapter = new ResultsAdapter(c, itemList);

                        try {


                            rv.setAdapter(adapter);
                            rv.hasFixedSize();
                            rv.setLayoutManager(new LinearLayoutManager(getActivity()));


                            pd.setVisibility(View.INVISIBLE);
                        } catch (Exception ex) {
                            Toast.makeText(getActivity(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
                            pd.setVisibility(View.INVISIBLE);
                        }
                    }
                });


    }


}
