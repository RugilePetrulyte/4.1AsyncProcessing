package com.example.a41asyncprocessing;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.ArrayList;

public class DataLoader extends AsyncTask<List<String>, Void, List<String>> {

    protected List<String> doInBackground(List<String>... params) {
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
        }
            return new ArrayList<>();
    }
}
