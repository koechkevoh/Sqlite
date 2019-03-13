package com.example.loginemployee;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    DatabaseLogin db;

    EditText editEmail,editPass1,editPass2;
    Button register;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseLogin(this);


        editEmail =(EditText)findViewById(R.id.email);
        editPass1 = (EditText)findViewById(R.id.pass1);
        editPass2 = (EditText)findViewById(R.id.pass2);
        register = (Button) findViewById(R.id.btn);





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 =editEmail.getText().toString();
                String s2 =editPass1.getText().toString();
                String s3 = editPass2.getText().toString();
                if(s1.equals("")|| s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)){
                        Boolean chkEmail = db.chkEmail(s1);
                        if(chkEmail==true){
                            Boolean insertData = db.insertDataLogin(s1,s2);
                            if(insertData==true){
                                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }

        });


    }


}
