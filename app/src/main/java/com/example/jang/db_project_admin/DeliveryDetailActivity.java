package com.example.jang.db_project_admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        String result = getIntent().getStringExtra("num");

        user = getIntent().getParcelableExtra("user");

        etname = (EditText)findViewById(R.id.etname_deliverydetail);
        etnum = (EditText)findViewById(R.id.etnum_deliverydetail);
        etday = (EditText)findViewById(R.id.etday_deliverydetail);

        btnaccept = (Button)findViewById(R.id.btnaccep_deliverydetaildetail);
        btncancel = (Button)findViewById(R.id.btncancel_deliverydetaildetail);

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));

        listView = (ListView) findViewById(R.id.listview_deliverydetail);
        res = getResources();
        adapter = new IconTextListAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {          //리스트 뷰에서 리스트 중 하나를 클릭 했을 때발생
                final IconTextItem curItem = (IconTextItem) adapter.getItem(position);
                String[] curData = curItem.getData();
//                delete_position = position;
//                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(DeliveryDetailActivity.this);
                alert_confirm.setMessage("배송하시겠습니까?").setCancelable(false).setPositiveButton("확인",     //팝업 작동
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 'YES'
//                                Cursor c = db.query("schedule", null, null, null, null, null, null);
//
//                                delete(delete_position + (c.moveToNext() ? c.getInt(c.getColumnIndex("_id")) : 0));

                                onResume();
                            }
                        }).setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 'No'
                                return;
                            }
                        });
                AlertDialog alert = alert_confirm.create();
                alert.show();


            }

        });

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

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                result, "C++ ", "20시13분  "
        ));

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
