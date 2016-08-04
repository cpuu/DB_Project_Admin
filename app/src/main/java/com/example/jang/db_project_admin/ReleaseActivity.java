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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Jang on 2016-07-31.
 */
public class ReleaseActivity extends Activity {
    CommunicationWithServer cws;
    User user;
    EditText etname, etnum, etday, etworknum;
    Button btnaccept, btncancel, btnjobstart;

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


        btnjobstart = (Button) findViewById(R.id.btnjobstart_release);
        btnaccept = (Button) findViewById(R.id.bntaccept_release);
        btncancel = (Button) findViewById(R.id.bntcancel_release);

        etname = (EditText) findViewById(R.id.etname_release);
        etnum = (EditText) findViewById(R.id.etnum_release);
        etday = (EditText) findViewById(R.id.etday_release);
        etworknum = (EditText)findViewById(R.id.etworknum_release);

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

        btnjobstart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HashMap<String, String> input = new HashMap<String, String>();

                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                input.put("employee", etnum.getText().toString());
                input.put("datetime", CurDateFormat.format(date));


                cws = new CommunicationWithServer(getApplicationContext());
                HashMap<String,String> result = cws.register_output(input);
                String test = result.get("id_auto");
                if (result != null) {
                    etworknum.setText(result.get("id_auto"));
                    Toast.makeText(getApplicationContext(), "작업을 시작하십시오", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "에러", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnaccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();


            }
        });


        btncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();


            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {          //리스트 뷰에서 리스트 중 하나를 클릭 했을 때발생
                IconTextItem curItem = (IconTextItem) adapter.getItem(position);
                String[] curData = curItem.getData();
//                delete_position = position;
//                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(ReleaseActivity.this);
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


    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();

    }
}
