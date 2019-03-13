package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextId,editTextName,editTextEstablishment,editTextLocation,editTextFood,editTextHour;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextId = findViewById(R.id.id);
        editTextName = findViewById(R.id.establishment);
        editTextEstablishment = findViewById(R.id.type);
        editTextLocation = findViewById(R.id.location);
        editTextFood = findViewById(R.id.food);
        editTextHour = findViewById(R.id.hours);

    }
    private  boolean idValidate(){
        String idInput =editTextId.getText().toString().trim();
        if(idInput.isEmpty()){
            editTextId.setError("Id is Required");
            return false;

        }
        else{
            editTextId.setError(null);
            return true;
        }
    }
    private  boolean nameValidate(){
        String nameInput =editTextName.getText().toString().trim();
        if(nameInput.isEmpty()){
            editTextName.setError("Name is Required");
            return false;

        }
        else{
            editTextName.setError(null);
            return true;
        }
    }

    private  boolean estValidate(){
        String estInput =editTextEstablishment.getText().toString().trim();
        if(estInput.isEmpty()){
            editTextEstablishment.setError("The establishment is Required");
            return false;

        }
        else{
            editTextEstablishment.setError(null);
            return true;
        }
    }
    public void confirmInput(){
        if(!idValidate() | !nameValidate() | !estValidate()){
            return;
        }
        String input= "Id: " +editTextId.getText().toString();
        input += "\n";
        input +="name: " +editTextName.getText().toString();
        input += "\n";
        input +="Type of establishment: " +editTextEstablishment.getText().toString();
        input += "\n";
        input +="Food: " +editTextFood.getText().toString();
        input += "\n";
        input +="Location: " +editTextLocation.getText().toString();
        input += "\n";
        input +="Open Hours: " +editTextHour.getText().toString();


    }
}
