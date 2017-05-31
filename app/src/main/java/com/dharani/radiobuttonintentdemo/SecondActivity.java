package com.dharani.radiobuttonintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText etName,etEmail,etYear;
    Button btSubmit,btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etName = (EditText)findViewById(R.id.editText);
        etEmail = (EditText)findViewById(R.id.editText2);
        etYear = (EditText)findViewById(R.id.editText3);

        btSubmit = (Button)findViewById(R.id.button4);
        btBack = (Button)findViewById(R.id.button3);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String year = etYear.getText().toString();

                Intent in = new Intent(SecondActivity.this,DisplayActivity.class);
                in.putExtra("myname",name);
                in.putExtra("myemail",email);
                in.putExtra("year",year);
                startActivity(in);
               // Toast.makeText(SecondActivity.this, "Move to next activity", Toast.LENGTH_SHORT).show();
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
