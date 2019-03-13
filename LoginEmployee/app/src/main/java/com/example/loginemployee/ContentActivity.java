package com.example.loginemployee;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {
    DatabaseLogin myDb;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        listView = (ListView)findViewById(R.id.listVie);
        myDb = new DatabaseLogin(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor res =myDb.getAllData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = listView.getItemAtPosition(position).toString();
                Toast.makeText(ContentActivity.this, ""+text
                        , Toast.LENGTH_SHORT).show();
            }
        });

        if(res.getCount()==0){
            Toast.makeText(getApplicationContext(), "The Database Was Empty", Toast.LENGTH_SHORT).show();
        }
        else{

            while (res.moveToNext()){
                theList.add(res.toString());
                ListAdapter listAdapter = new ArrayAdapter<> (this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
