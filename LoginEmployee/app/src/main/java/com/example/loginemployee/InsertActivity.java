package com.example.loginemployee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {
    DatabaseLogin myDb;
    EditText editFName,editSName,editEmail,editEmpoNo,editSalary;
    Button btn1,btn2;
    private SQLiteDatabase sql;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        myDb = new DatabaseLogin(this);
        editFName =(EditText)findViewById(R.id.fname);
        editSName =(EditText)findViewById(R.id.sname);
        editEmail =(EditText)findViewById(R.id.email);
        editEmpoNo =(EditText)findViewById(R.id.empNo);
        editSalary =(EditText)findViewById(R.id.saloo);



        btn1 =(Button)findViewById(R.id.btn);
        btn2 = (Button)findViewById(R.id.bt2);





        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        AddData();


    }
    public void AddData(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 =editFName.getText().toString();
                String name2 =editSName.getText().toString();
                String email =editEmail.getText().toString();
                String employee=editEmpoNo.getText().toString();
                String salo =editSalary.getText().toString();
                if(TextUtils.isEmpty(name1)){
                    Toast.makeText(getApplicationContext(), "Please Enter First Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name2)){
                    Toast.makeText(getApplicationContext(), "Please Enter Second Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(employee)){
                    Toast.makeText(getApplicationContext(), "Please Enter Employee Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(salo)){
                    Toast.makeText(getApplicationContext(), "Please Enter Salary", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isInserted = myDb.insertData(name1,name2,email,employee,salo);
                if(isInserted==true){
                    Toast.makeText(InsertActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    editFName.setText("");
                    editSName.setText("");
                    editEmail.setText("");
                    editEmpoNo.setText("");
                    editSalary.setText("");




                }
                else
                    Toast.makeText(InsertActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
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

}
