package com.example.homepage;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button themeButton;
    View view;
    private LinearLayout MainLayout;
    private static final int Const=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.search);
        button2 = (Button) findViewById(R.id.view);
        themeButton = (Button) findViewById(R.id.themeButtonId);
        MainLayout =(LinearLayout) findViewById(R.id.mainPageId);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch_words();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openView_words();
            }
        });
        themeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTheme();
            }
        });



    }

    public void openSearch_words(){
        Intent intent = new Intent(this, Search_words.class);
        startActivity(intent);
    }

    public void openView_words(){
        Intent intent = new Intent(this, View_words.class);
        startActivity(intent);
    }
    public void openTheme(){
        Intent intent = new Intent(this, ThemeActivity.class);
        startActivity(intent);
    }
    public void onSelectColor(View view){
        Intent myIntent = new Intent(MainActivity.this,ThemeActivity.class);
        startActivityForResult(myIntent,Const);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case Const:
                if(resultCode== RESULT_OK){
                    String COLOR = data.getExtras().getString("color");
                    findViewById(R.id.button).setBackgroundColor(Color.parseColor(COLOR));
                }

        }
    }
}
