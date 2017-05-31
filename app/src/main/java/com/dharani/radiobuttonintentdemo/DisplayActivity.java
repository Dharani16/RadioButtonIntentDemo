package com.dharani.radiobuttonintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView tvDispaly;
    Button btMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDispaly = (TextView)findViewById(R.id.textView8);
        btMain = (Button)findViewById(R.id.button2) ;

        String getName = getIntent().getStringExtra("myname");
        String getEmail = getIntent().getStringExtra("myemail");
        String getYear = getIntent().getStringExtra("year");

        tvDispaly.setText( "Name :" + getName + "\n" + "Email ID : "+getEmail + "\n" + "Passed out : "+getYear);

        btMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(DisplayActivity.this,MainActivity.class);
                startActivity(main);
            }
        });

    }
}
