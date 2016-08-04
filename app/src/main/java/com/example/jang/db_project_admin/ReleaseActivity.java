package com.example.jang.db_project_admin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jang on 2016-07-31.
 */
public class ReleaseActivity extends Activity {
    User user;
    EditText etname, etnum, etday;
    Button btnaccept, btncancel;

    Resources res;
    IconTextListAdapter adapter;
    ListView listView;

    protected void onResume() {
        super.onResume();
        listView.setAdapter(adapter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_layout);



        btnaccept = (Button)findViewById(R.id.bntaccept_release);
        btncancel = (Button)findViewById(R.id.bntcancel_release);

        etname = (EditText)findViewById(R.id.etname_release);
        etnum = (EditText)findViewById(R.id.etnum_release);
        etday = (EditText)findViewById(R.id.etday_release);

        user = getIntent().getParcelableExtra("user");
        etname.setText(user.getName());
        etnum.setText(user.getEmployee_number());

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));

        listView = (ListView) findViewById(R.id.listview_release);
        res = getResources();
        adapter = new IconTextListAdapter(this);
        listView.setAdapter(adapter);



    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();

    }
}
