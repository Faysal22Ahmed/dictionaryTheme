package com.example.homepage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ThemeActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    private LinearLayout linearLayout, MainLayout;
    private boolean appTheme1;

    Intent SelectColorIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        b1 =(Button) findViewById(R.id.b1Id);
        b2 =(Button) findViewById(R.id.b2Id);
        b3 =(Button) findViewById(R.id.b3Id);
        b4 =(Button) findViewById(R.id.b4Id);
        b5 =(Button) findViewById(R.id.b5Id);
        b6 =(Button) findViewById(R.id.b6Id);
        b7 =(Button) findViewById(R.id.b7Id);
        b8 =(Button) findViewById(R.id.b8Id);
        b9 =(Button) findViewById(R.id.b9Id);
        b10 =(Button) findViewById(R.id.b10Id);
        linearLayout =(LinearLayout) findViewById(R.id.linearId);




        if(loadColor()!=getResources().getColor(R.color.colorPrimary)){
            linearLayout.setBackgroundColor(loadColor());
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.Coral));
                storeColor(getResources().getColor(R.color.Coral));


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.HotPink));
                storeColor(getResources().getColor(R.color.HotPink));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.SandyBrown));
                storeColor(getResources().getColor(R.color.SandyBrown));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.Crimson));
                storeColor(getResources().getColor(R.color.Crimson));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.DarkSalmon));
                storeColor(getResources().getColor(R.color.DarkSalmon));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.Violet));
                storeColor(getResources().getColor(R.color.Violet));
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.OrangeRed));
                storeColor(getResources().getColor(R.color.OrangeRed));
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                storeColor(getResources().getColor(R.color.colorPrimary));
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.Orange));
                storeColor(getResources().getColor(R.color.Orange));
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.PaleVioletRed));
                storeColor(getResources().getColor(R.color.PaleVioletRed));
            }
        });



    }
    private void storeColor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("mycolor",color);
        editor.commit();
    }
    private int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("BackgroundColor", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("mycolor",getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}
