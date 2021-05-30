package com.example.a41asyncprocessing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView tvContent;

    private ListView lvRate;
    private ArrayAdapter listAdapter;
    private ArrayList<String> CurrencyRatesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
        CurrencyRatesList = new ArrayList<String>();
        lvRate = findViewById(R.id.lvRate);
        listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, CurrencyRatesList);
        lvRate.setAdapter(listAdapter);

    }

    public void onBtnDownloadClick(View view) {
        CurrencyRatesList.clear();
        CurrencyRatesList.add("Loading...");
        listAdapter.notifyDataSetChanged();


        new DataLoader(){
            @Override
            public void onPostExecute(List<String> result)
            {
                tvContent.setText("Completed");
                CurrencyRatesList.clear();
                CurrencyRatesList.addAll(result);
                listAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}