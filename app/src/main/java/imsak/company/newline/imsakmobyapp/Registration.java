package imsak.company.newline.imsakmobyapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.body.StreamBody;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import model.imask.EventsModel;

public class Registration extends AppCompatActivity {

    private Spinner  selectclass,spinner_event;
    private EditText name_edt;
    private Button register_bt;
    String EventId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register a Student");

        selectclass = (Spinner) findViewById(R.id.selectclass);
        spinner_event = (Spinner) findViewById(R.id.spinner_event);
        name_edt =(EditText)findViewById(R.id.name_edt);
        register_bt = (Button) findViewById(R.id.register_bt_);

        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit();
                //GetToast();
            }
        });



        String classes_list [] = {"S.1","S.2","S.3","S.4","S.5","S.6"};

        ArrayAdapter<String> classAdap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,classes_list);

        // Drop down layout style - list view with radio button
        classAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Attach the Adapter.
        selectclass.setAdapter(classAdap);

        SpinnerItemsList();

    }





    private void SpinnerItemsList(){

        Intent i  = getIntent();
        final String compId = i.getStringExtra("COMP_ID");


        // 192.168.43.104
        final String url = "http://imsakug.org/Mobile/Default.aspx?DataFormat=EventsByCompetition&CompID="+compId;



        Ion.with(Registration.this)
                .load(url)
                .as(new TypeToken<List<EventsModel>>() {
                })
                .setCallback(new FutureCallback<List<EventsModel>>() {

                    @Override
                    public void onCompleted(Exception e, final List<EventsModel> itemList) {

                        try {

                            final List<String> items = new ArrayList<String>();



                            for ( int i = 0; i < itemList.size(); i++) {
                                items.add(itemList.get(i).getEventName());



                                ArrayAdapter<String> resdap = new ArrayAdapter<String>(Registration.this,android.R.layout.simple_spinner_item,items);

                                resdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                // Attach the Adapter.
                                spinner_event.setAdapter(resdap);
                                spinner_event.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        EventsModel selectEvent = itemList.get(position);
                                       // Toast.makeText(getApplicationContext(),""+selectEvent.getEventID(),Toast.LENGTH_LONG).show();
                                       // Load(selectEvent.getEventID().toString(),compId);


                                         EventId = selectEvent.getEventID().toString();

                                    }
                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                            }


                        }
                        catch (Exception ex){
                            Toast.makeText(getApplicationContext(), "There was a problem in loading "+ex, Toast.LENGTH_SHORT).show();
                            System.out.println("Error "+ ex );

                        }
                    }
                });







    }
    private final String GetSpinnerId(){

        return EventId;
    }



    private void GetToast (){

        Toast.makeText(getApplicationContext(),""+GetSpinnerId(),Toast.LENGTH_LONG).show();
    }

    private void Submit(){
        final   ProgressDialog pd;
        pd = new ProgressDialog(Registration.this);
        pd.setMessage("Registering...");
        pd.setCancelable(false);
        pd.show();
        //computer ip address 192.168.43.104:82
       final String   Studentusername = name_edt.getText().toString();
        final String ClassName = selectclass.getSelectedItem().toString();
      //  final String EventId = GetSpinnerId();
        Intent i  = getIntent();
        final String compId = i.getStringExtra("COMP_ID");
        final String UserName = i.getStringExtra("USERNAME");

      //  Toast.makeText(getApplicationContext(),"Event Id "+EventId,Toast.LENGTH_LONG).show();




        final String url_ = "http://imsakug.org/Mobile/Default.aspx?DataFormat=Register&CompID="+compId+
                "&EVEID="+GetSpinnerId()+"&Name="+Studentusername+"&Class="+ClassName
                +"&UseN="+UserName;

        Ion.with(Registration.this)
                .load(url_)
                .progressDialog(pd)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {



                           Toast.makeText(Registration.this, result, Toast.LENGTH_LONG).show();



                        pd.dismiss();
                        name_edt.getText().clear();


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
