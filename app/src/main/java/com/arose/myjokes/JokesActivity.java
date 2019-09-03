package com.arose.myjokes;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokesActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String API_URL = "http://api.icndb.com/jokes/random";
    Button btnJoke;
    BubbleTextView txtJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
       txtJoke = (BubbleTextView)findViewById(R.id.txtJoke);
       btnJoke = (Button)findViewById(R.id.btnJoke);
        btnJoke.setOnItemClickListener(new View.OnItemClickListener() {
            @Override
            public void onClick (View V){
                AsyncTask<String,Void,String>asyncTask=new AsyncTask<String, Void, String>( ) {
                    progressDialog mDialog = new progressDialog(JokesActivity.this);
                    asynctask.execute();
                }
            }
            @Override
            protected void onPreExecute(){
                mDialog.setTitle("please wait ...");
                mDialog.show();
            }
            @Override
            protected String doInBackground(String...paramas){
                Helper helper = new Helper();
                return helper.getHTTPData(API_URL)
            }
            @Override
            protected void onPostExecute(String s){
                mDialog.dismiss();
                chuckNorris chuckNorris = new Gson().fromJson(s,chuckNorris.class);
                txtJoke.setText (chuckNorris.value .joke);
                if(txtJoke.getVisibility()==view.INVISIBLE);
                txtJoke.setVisibilty(View.VISIBLE);

            }
        });


    }
}

