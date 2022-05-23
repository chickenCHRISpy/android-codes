package com.example.a12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner genderSelect;
    TextView nameTv,genderTv,degTv;
    RadioGroup radioGroup;
    RadioButton radioBranchButton;
    EditText nameEt;
    Button submitBtn;

    String gender[] = {"Male","Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderSelect = findViewById(R.id.spinner_gender);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        genderTv = findViewById(R.id.gender_tv);
        nameEt = findViewById(R.id.name_et);
        nameTv = findViewById(R.id.name_tv);
        submitBtn = findViewById(R.id.button);


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item,gender);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSelect.setAdapter(ad);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId=radioGroup.getCheckedRadioButtonId();
                radioBranchButton=(RadioButton)findViewById(selectedId);
                nameTv.setText(nameEt.getText().toString());
                degTv.setText(radioBranchButton.getText());
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        genderTv.setText(gender[i].toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}