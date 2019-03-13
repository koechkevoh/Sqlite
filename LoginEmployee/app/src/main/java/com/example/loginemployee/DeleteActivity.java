package com.example.loginemployee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    DatabaseLogin myDb;
    EditText editTextId;
    Button btnDelete,btnDelete2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myDb = new DatabaseLogin(this);
        editTextId = (EditText)findViewById(R.id.idDelete);
        btnDelete = (Button)findViewById(R.id.btDelete);
        btnDelete2 = (Button)findViewById(R.id.btnDelete);
        btnDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        DeleteData();
    }
    public void DeleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                if(TextUtils.isEmpty(id)){
                    Toast.makeText(DeleteActivity.this, "Please Enter Id Which You Want To Delete", Toast.LENGTH_SHORT).show();
                    return;
                }
                Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                    if(deletedRows>0) {
                        Toast.makeText(DeleteActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        editTextId.setText("");
                    }
                    else{
                        Toast.makeText(DeleteActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }
}
