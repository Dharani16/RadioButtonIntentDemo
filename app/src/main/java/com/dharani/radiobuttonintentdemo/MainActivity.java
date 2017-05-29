package com.dharani.radiobuttonintentdemo;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    CheckBox ten, twelve, ug, pg;
    Button button;
    RadioButton rb;
    Switch switchJob;
    Spinner spin;
    ToggleButton toggleButton;
    ConstraintLayout myConstraint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        ten = (CheckBox) findViewById(R.id.checkBox);
        twelve = (CheckBox) findViewById(R.id.checkBox2);
        ug = (CheckBox) findViewById(R.id.checkBox3);
        pg = (CheckBox) findViewById(R.id.checkBox4);
        switchJob = (Switch) findViewById(R.id.switch1);
        spin = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        myConstraint = (ConstraintLayout) findViewById(R.id.constraintLayoutID);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    myConstraint.setBackgroundColor(Color.RED);
                } else {
                    myConstraint.setBackgroundResource(R.drawable.bgcolor);
                }
            }
        });

        location();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender();
                qualification();
                jobStatus();

            }
            
            private void jobStatus() {
                if (switchJob.isChecked()) {
                    Toast.makeText(MainActivity.this, "Yeah ! Got job !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Looking job !", Toast.LENGTH_SHORT).show();
                }
            }
            // select gender
            private void gender() {
                int getGender = radioGroup.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(getGender);
                if (rb == null) {
                    Toast.makeText(getApplicationContext(), "Please select atleast one radiobutton", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Gender is " + rb.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }

            // check box using pick qualification
            private void qualification() {
                String checkOne = ten.getText().toString();
                String checkTwo = twelve.getText().toString();
                String checkThree = ug.getText().toString();
                String checkFour = pg.getText().toString();

                if (ten.isChecked()) {
                    Toast.makeText(MainActivity.this, "You choosed option is " + checkOne, Toast.LENGTH_SHORT).show();
                } else if (twelve.isChecked()) {
                    Toast.makeText(MainActivity.this, "You choosed option is " + checkTwo, Toast.LENGTH_SHORT).show();
                } else if (ug.isChecked()) {
                    Toast.makeText(MainActivity.this, "You choosed option is " + checkThree, Toast.LENGTH_SHORT).show();
                } else if (pg.isChecked()) {
                    Toast.makeText(MainActivity.this, "You choosed option is " + checkFour, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Fill qualification", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void location() {
        final String places[] = {"Choose place", "Pondicherry", "Muthialper", "Kalapet"};
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_style, R.id.spinLocation, places);
        adapter.setDropDownViewResource(R.layout.spinner_style);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, places[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Choose anyone", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
