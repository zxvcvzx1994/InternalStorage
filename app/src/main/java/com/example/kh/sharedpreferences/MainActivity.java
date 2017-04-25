package com.example.kh.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kh.sharedpreferences.ViewHolder.Module.main_activity;

public class MainActivity extends AppCompatActivity {

  private SharedPreferences sharedPreferences ;
     private main_activity holder ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        holder = new main_activity();
        sharedPreferences = getSharedPreferences("vinh", MODE_PRIVATE);
        holder.txt = (TextView)  findViewById(R.id.txt);
        holder.btnPreferences = (Button) findViewById(R.id.btnSharedPreferences);
        holder.btnShowdata = (Button) findViewById(R.id.btnShowData);

        holder.btnPreferences.setOnClickListener(onclicklistener);
        holder.btnShowdata.setOnClickListener(onclicklistener);



    }
    private View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnSharedPreferences:
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("a","ten toi la vinh");
                    editor.commit();
                    break;
                case R.id.btnShowData:
                 String name =    sharedPreferences.getString("a","name not found");
                    holder.txt.setText(name);
                    break;
            }
        }
    };

}
