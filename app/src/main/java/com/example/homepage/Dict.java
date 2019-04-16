package com.example.homepage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import static android.content.ContentValues.TAG;
import static android.content.Intent.getIntent;

public class Dict {
    Map<String, String> dictionary;
    Context context;
    View view;



    public Dict(Context context, String filename) throws Exception{
        this.context = context;

        String[] lines = readLines(filename, 4000);
        dictionary = makeDictionary(lines);
    }

    public String getDefinition(String word){
        return dictionary.get(word);
    }


    public Set<Map.Entry<String, String>> entrySet() {
        return dictionary.entrySet();
    }

    public Map<String, String> makeDictionary(String[] lines) throws Exception{
        Map<String, String> dictionary = new TreeMap<>();

        Random rand = new Random(10);
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split(",");

            String word = removeQuotes(parts[0]);
            String definition = removeQuotes(parts[2]);

            if (rand.nextInt(2) == 0) {
                dictionary.put(word, definition);
            }
        }

        return dictionary;
    }

    public String removeQuotes(String s){
        return s.substring(1, s.length() - 1);
    }

    public String[] readLines(String filename, int lineCount) throws Exception{
        Log.d(TAG, "readLines: " + this.context);
        InputStream is = this.context.getAssets().open(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String[] lines = new String[lineCount];
        for (int i = 0; i < lineCount; i++) {
            lines[i] = br.readLine();
        }

        return lines;
    }

}