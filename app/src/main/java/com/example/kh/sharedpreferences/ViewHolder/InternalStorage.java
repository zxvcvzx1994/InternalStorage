package com.example.kh.sharedpreferences.ViewHolder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kh.sharedpreferences.R;
import com.example.kh.sharedpreferences.ViewHolder.Module.InternalOpenHelper;
import com.example.kh.sharedpreferences.ViewHolder.Module.ViewHolderInternalStorage;

import java.io.IOException;

public class InternalStorage extends AppCompatActivity {
    private static final String FILENAME ="mydata" ;
    private ViewHolderInternalStorage holder;
    private InternalOpenHelper internalOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        holder = new ViewHolderInternalStorage();
        holder.txt = (TextView) findViewById(R.id.txtshowdata);
        holder.btninteralstorage = (Button) findViewById(R.id.btninternalstorage);
        holder.btnShowdata = (Button) findViewById(R.id.btnshowdata1);
        holder.etdata = (EditText) findViewById(R.id.etdata);

        internalOpenHelper = new InternalOpenHelper();
        holder.btninteralstorage.setOnClickListener(onclicklistener);
        holder.btnShowdata.setOnClickListener(onclicklistener);
    }
    private  View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btninternalstorage:

                    try {
                        internalOpenHelper.getInstance().setData(FILENAME,holder.etdata.getText().toString().trim(),getApplicationContext());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case R.id.btnshowdata1:
                    try {
                     String data=   internalOpenHelper.getInstance().getData(FILENAME,getApplicationContext());
                        holder.txt.setText(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
}
