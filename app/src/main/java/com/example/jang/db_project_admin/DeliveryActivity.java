package com.example.jang.db_project_admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jang on 2016-07-30.
 */
public class DeliveryActivity extends Activity {

    User user;
    IconTextListAdapter adapter;
    ListView listView;
    Resources res;
    Button btnsearch;
    EditText etname, etday, etnum, etbookcase, etbarcode;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_layout);

        user = getIntent().getParcelableExtra("user");

        etname = (EditText) findViewById(R.id.etname_delivery);
        etnum = (EditText) findViewById(R.id.etnum_delivery);
        etday = (EditText) findViewById(R.id.etday_delivery);

        adapter = new IconTextListAdapter(this);
        listView = (ListView) findViewById(R.id.listview_delivery);
        res = getResources();

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));


        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "201032\t", "남코딩\t", "123123\t "
        ));

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "201033\t", "황초보\t", "123124\t "
        ));

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "201045\t", "박성공\t", "123125\t "
        ));

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "201036\t", "이미래\t", "123127\t "
        ));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {          //리스트 뷰에서 리스트 중 하나를 클릭 했을 때발생
                IconTextItem curItem = (IconTextItem) adapter.getItem(position);
                String[] curData = curItem.getData();
//                delete_position = position;
//                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(DeliveryActivity.this);
                alert_confirm.setMessage("배송하시겠습니까?").setCancelable(false).setPositiveButton("확인",     //팝업 작동
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 'YES'
//                                Cursor c = db.query("schedule", null, null, null, null, null, null);
//
//                                delete(delete_position + (c.moveToNext() ? c.getInt(c.getColumnIndex("_id")) : 0));
                                Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
                                intent.putExtra("user", user);
                                startActivity(intent);
                                finish();

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


