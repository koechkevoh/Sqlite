package com.example.loginemployee;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReadActivity extends AppCompatActivity {
    Button btnList,btnRead;
    DatabaseLogin myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        myDb = new DatabaseLogin(this);
        btnList = (Button)findViewById(R.id.btnInsert);
        btnRead =(Button)findViewById(R.id.btnBkRead);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

       // viewAll();
    btnList.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ReadActivity.this,ContentActivity.class);
            startActivity(intent);
        }
    });
    }
    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    /*public void viewAll(){
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if(res.getCount()==0){
                    showMessage("Alert","Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id :"+res.getString(0)+"\n");
                    buffer.append("First Name :"+res.getString(1)+"\n");
                    buffer.append("Second Name :"+res.getString(2)+"\n");
                    buffer.append("Email :"+res.getString(3)+"\n");
                    buffer.append("Employee No :"+res.getString(4)+"\n");
                    buffer.append("Salary :"+res.getString(5)+"\n");
                }
                showMessage("Data",buffer.toString());
            }
        });

    }*/
}
