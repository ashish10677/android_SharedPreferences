package com.example.ashish.shared;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    EditText etName;
    Button btnsubmit;
    public static final String MY_PREFS = "com.example.ashish.shared.name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        etName = (EditText)findViewById(R.id.etname);
        btnsubmit = (Button)findViewById(R.id.btnsubmit);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS,MODE_PRIVATE);
        String user = prefs.getString("user","");

        tvWelcome.setText("Welcome "+user+" to my App!");
    }


    public void clickme(View v){

        String name = etName.getText().toString().trim();
        tvWelcome.setText("Welcome "+name+" to my App!");

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();
        editor.putString("user",name);
        editor.commit();

    }
}
