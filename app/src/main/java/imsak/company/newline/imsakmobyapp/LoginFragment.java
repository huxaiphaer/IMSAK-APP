package imsak.company.newline.imsakmobyapp;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by HUZY_KAMZ on 3/10/2017.
 */

public class LoginFragment extends Fragment {

    private Spinner categories;
    private Intent inn;
    private String EventId = "";

    private RecyclerView rv;
    String num = "";
    EditText ed_Pass, edt_Reg;
    Button login;
    ProgressDialog pd;

    private Context c;

    public LoginFragment() {
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


        View v = inflater.inflate(R.layout.login, container, false);
        edt_Reg = (EditText) v.findViewById(R.id.edt_Reg);
        ed_Pass = (EditText) v.findViewById(R.id.ed_Pass);
        login = (Button) v.findViewById(R.id.bt_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnLoggingIn();
            }
        });


        return v;
    }


    private void OnLoggingIn() {
        //computer ip address 192.168.43.104:82
        final String username = edt_Reg.getText().toString();
        final String password = ed_Pass.getText().toString();

        Intent i = getActivity().getIntent();
        final String compId = i.getStringExtra("COMP_ID");


        pd = new ProgressDialog(getActivity());
        pd.setMessage("Logging in...");
        pd.setCancelable(false);
        pd.show();
        final String url_ = "http://imsakug.org/Mobile/login.aspx?Username=" + username + "&Password=" + password;

        Ion.with(LoginFragment.this)
                .load(url_)
                .progressDialog(pd)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {


                        if (result.toString().equals("Accepted")) {
                            Intent myIntent = new Intent(getActivity(), Registration.class);
                            //  myIntent.putExtra("username", username.getText().toString().toLowerCase());
                            myIntent.putExtra("USERNAME", username);
                            myIntent.putExtra("COMP_ID", compId);

                            startActivity(myIntent);
                            Toast.makeText(getActivity(), "Logged in", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "Invalid User Name or Password ", Toast.LENGTH_LONG).show();
                        }


                        pd.dismiss();

                        ed_Pass.getText().clear();

                    }
                });

    }


}

