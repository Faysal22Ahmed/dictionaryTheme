package com.example.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class View_words extends AppCompatActivity {

    private static final String TAG = "12";
    ListView listView;
    Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_words);

        try {
            Dict dictionary = new Dict(getApplicationContext(), "dictionary.csv");
            
            listView = (ListView) findViewById(R.id.listView);

            
            ArrayList<String> arrayList = new ArrayList<>();

            for (Map.Entry<String,String> entry : dictionary.entrySet()){
                String word = entry.getKey();
                String definition = entry.getValue();
                arrayList.add(word + ": \nMeaning -> " + definition);
                Log.d(TAG, "onCreate: " + entry.getValue());
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(arrayAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}