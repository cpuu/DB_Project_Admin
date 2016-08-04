package com.example.jang.db_project_admin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jang on 2016-08-04.
 */
public class DeliveryDetailActivity extends Activity {
    User user;
    EditText etname, etnum, etday;
    Button btnaccept, btncancel;

    Resources res;
    IconTextListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliverydetail_layout);



        user = getIntent().getParcelableExtra("user");

        etname = (EditText)findViewById(R.id.etname_deliverydetail);
        etnum = (EditText)findViewById(R.id.etnum_deliverydetail);
        etday = (EditText)findViewById(R.id.etday_deliverydetail);

        btnaccept = (Button)findViewById(R.id.btnaccep_deliverydetaildetail);
        btncancel = (Button)findViewById(R.id.btncancel_deliverydetaildetail);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));

        listView = (ListView) findViewById(R.id.listview_release);
        res = getResources();
        adapter = new IconTextListAdapter(this);
        listView.setAdapter(adapter);

        btnaccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {            //확인

                Intent intent = new Intent(getApplicationContext(),DeliveryActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });


        btncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {            //취소

                Intent intent = new Intent(getApplicationContext(),DeliveryActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });



    }
}
