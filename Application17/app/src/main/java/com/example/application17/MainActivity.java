package com.example.application17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"};
        // Replace the Array adapter with your custom adapter.
        // ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListAdapter customListAdapter = new CustomAdapter(this,foods);// Pass the food arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.custom_ListView);
        customListView.setAdapter(customListAdapter);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
