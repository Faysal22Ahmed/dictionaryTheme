package com.example.homepage;

import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class Search_words extends AppCompatActivity {

    EditText edit;
    Button button3;
    TextView tview;
    Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_words);

        Dict dictionary = null;
        try {
            dictionary = new Dict(getApplicationContext(), "dictionary.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

        button3 = (Button) findViewById(R.id.button);
        edit = (EditText) findViewById(R.id.editText);
        tview = (TextView) findViewById(R.id.textView3);

        final Dict finalDictionary = dictionary;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String s2 = finalDictionary.getDefinition(s);

                if(s2 == null){
                    tview.setText("    MEANING NOT FOUND!");
                }
                else
                    tview.setText(s2);
            }
        });
    }
}
