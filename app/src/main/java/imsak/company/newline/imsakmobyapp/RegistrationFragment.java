package imsak.company.newline.imsakmobyapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Spinner;

/**
 * Created by HUZY_KAMZ on 2/15/2017.
 */

public class RegistrationFragment extends Fragment {

    private Spinner categories;
    private Intent inn;
    private String EventId = "";
    ProgressBar pd;
    private RecyclerView rv;
    String num = "";
    private Context c;

    public RegistrationFragment() {
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

        return v;
    }


}
