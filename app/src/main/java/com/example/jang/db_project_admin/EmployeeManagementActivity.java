package com.example.jang.db_project_admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jang on 2016-07-31.
 */
public class EmployeeManagementActivity extends Activity {
    User user;
    ArrayAdapter<CharSequence> adspinposition, adspindivision;
    Spinner spinnerposition, spinnerdivision;
    EditText etname, etday,etnum, etnameinput, etbirthday,etsign,etresign;
    Button btnsearch, btncreate, btninitialization, btnsave, btncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeemanagement_layout);

        init();

        spinnerdivision.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SearchActivity.this,
//                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerposition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SearchActivity.this,
//                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


            }
        });

        btncreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


            }
        });

        btninitialization.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), EmployeeManagementActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();

    }

    public void init()
    {

        user = getIntent().getParcelableExtra("user");

        etname = (EditText)findViewById(R.id.etname_employeemanagement);
        etday = (EditText)findViewById(R.id.etday_employeemanagement);
        etnum = (EditText)findViewById(R.id.etnum_employeemanagement);
        etnameinput = (EditText)findViewById(R.id.etnameinput_employeemanagement);
        etbirthday = (EditText)findViewById(R.id.etbirthday_employeemanagement);
        etsign = (EditText)findViewById(R.id.etsign_employeemanagement);
        etresign = (EditText)findViewById(R.id.etresign_employeemanagement);


        btncreate = (Button)findViewById(R.id.btncreate_employeemanagement);
        btnsearch = (Button)findViewById(R.id.btnsearch_employeemanagement);
        btninitialization = (Button)findViewById(R.id.btninitialization_employeemanagement);
        btnsave = (Button)findViewById(R.id.btnsave_employeemanagement);
        btncancel = (Button)findViewById(R.id.btncancel_employeemanagement);

        spinnerposition = (Spinner) findViewById(R.id.spinposition_employeemanagement);
        spinnerdivision = (Spinner) findViewById(R.id.spindivision_employeemanagement);

        adspinposition = ArrayAdapter.createFromResource(this, R.array.position,    android.R.layout.simple_spinner_item);
        adspinposition.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerposition.setAdapter(adspinposition);

        adspindivision = ArrayAdapter.createFromResource(this, R.array.division,    android.R.layout.simple_spinner_item);
        adspindivision.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdivision.setAdapter(adspindivision);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));
    }
}
