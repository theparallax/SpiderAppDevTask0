package com.example.rogith.spiderappddevtask0;

import android.content.Context;
import android.content.SharedPreferences;
//import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView CounterTextView;
    int counter=0;
    public static final String COUNTER="MyCounter";
    public static final String MyPREFERENCES = "MyPrefs";
    Context mContext;
    SharedPreferences localPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CounterTextView=(TextView) findViewById(R.id.CountetTextID);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTER",counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter=getFromFile();

    }

    @Override
    protected void onStart() {
        super.onStart();
        counter = getFromFile();
        CounterTextView.setText(String.valueOf(counter));
    }


    @Override
    protected void onStop() {
        super.onStop();
        writeToFile(counter);
    }

    private void writeToFile(int value){
        SharedPreferences.Editor editor=localPreferences.edit();
        editor.putInt(COUNTER,value);
        editor.apply();
    }


    private int getFromFile(){
        localPreferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        if(localPreferences.contains(COUNTER))
            return localPreferences.getInt(COUNTER,0);
        else return 0;
    }

    public void OnBtnClick(View v)
    {
        counter=counter+1;
        writeToFile(counter);
        CounterTextView.setText(String.valueOf(counter));
    }

}
