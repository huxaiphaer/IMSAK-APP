package imsak.company.newline.imsakmobyapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import adapter.imsak.AIC_Adapter;
import model.imask.AIC_Model;


public class AIC_Activity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aic_);
       /* getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Annual IMSAK Competitions");*/

        rv = (RecyclerView) findViewById(R.id.rv_aic);
        rv.hasFixedSize();
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        Load();

    }


    public void Load() {


        // 192.168.43.104

        final String url = "http://imsakug.org/Mobile/Default.aspx?DataFormat=Competition";


        final ProgressBar pd;
        pd = (ProgressBar) findViewById(R.id.progressBar_aic);
        pd.setVisibility(View.VISIBLE);


        Ion.with(getBaseContext())
                .load(url)
                .progressBar(pd)
                .as(new TypeToken<List<AIC_Model>>() {
                })
                .setCallback(new FutureCallback<List<AIC_Model>>() {

                    @Override
                    public void onCompleted(Exception e, List<AIC_Model> itemList) {
                        final AIC_Adapter adapter = new AIC_Adapter(AIC_Activity.this, itemList);

                        if (!itemList.equals(null)) {

                            try {

                                rv.setAdapter(adapter);
                                rv.hasFixedSize();
                                rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));


                                pd.setVisibility(View.INVISIBLE);
                            } catch (Exception ex) {
                                Toast.makeText(getApplicationContext(), "No Internet Connection!", Toast.LENGTH_SHORT).show();
                                pd.setVisibility(View.INVISIBLE);
                            }

                        }


                    }
                });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
