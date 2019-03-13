package com.example.loginemployee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    DatabaseLogin myDb;
    EditText editFname,editSname,editEmail,editEmployeeNo,editSalary,editTextId;
    Button btnUpdate,btnUpdate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDb =new DatabaseLogin(this);
        editFname = (EditText)findViewById(R.id.fnameUpdate);
        editSname = (EditText)findViewById(R.id.snameUpdate);
        editEmail = (EditText)findViewById(R.id.emailUpdate);
        editEmployeeNo =(EditText)findViewById(R.id.empNoUpdate);
        editTextId =(EditText)findViewById(R.id.idUpdate);
        editSalary = (EditText)findViewById(R.id.salooUpdate);

        btnUpdate =(Button)findViewById(R.id.btnUpdate1);
        btnUpdate2=(Button)findViewById(R.id.btnUpdate2);
        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        UpdateData();
    }
    public void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                if(TextUtils.isEmpty(id)){
                    Toast.makeText(UpdateActivity.this, "Please Enter Id You Want To Update", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isUpdate =myDb.updateData(
                        editTextId.getText().toString(),
                        editFname.getText().toString(),
                        editSname.getText().toString(),
                        editEmail.getText().toString(),
                        editEmployeeNo.getText().toString(),
                        editSalary.getText().toString());

                if(isUpdate==true){
                    Toast.makeText(UpdateActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                    editTextId.setText("");
                    editFname.setText("");
                    editSname.setText("");
                    editEmail.setText("");
                    editEmployeeNo.setText("");
                    editSalary.setText("");

                }
                else
                    Toast.makeText(UpdateActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
