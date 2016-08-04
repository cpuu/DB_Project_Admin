package com.example.jang.db_project_admin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Jang on 2016-07-30.
 */
public class WarehousingActivity extends Activity {

    CommunicationWithServer cws;
    User user;
    IconTextListAdapter adapter;
    //    ArrayAdapter<CharSequence> adspin;
    ListView listView;
    Resources res;
    Button btnsearch, btncheck, btnstart;
    EditText etname, etday, etnum, etbookcase, etbarcode;
    View view;
    String jobnumber;

    @Override
    protected void onResume() {
        super.onResume();
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warehousing_layout);


        view = new View(getApplicationContext());
        etname = (EditText) findViewById(R.id.etname_warehousing);
        etday = (EditText) findViewById(R.id.etday_warehousing);
        etnum = (EditText) findViewById(R.id.etnum_warehousing);
        etbookcase = (EditText) findViewById(R.id.etbookcase_warehousing);
        etbarcode = (EditText) findViewById(R.id.etbarcode_warehousing);

        btnsearch = (Button) findViewById(R.id.btnsearch_warehousing);
        btncheck = (Button) findViewById(R.id.btncheck_warehousing);
        btnstart = (Button) findViewById(R.id.btnstart_warehousing);

        listView = (ListView) findViewById(R.id.listview1);

        user = getIntent().getParcelableExtra("user");
        etname.setText(user.getName());
        etnum.setText(user.getEmployee_number());

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));


        res = getResources();
        adapter = new IconTextListAdapter(this);


        listView.setAdapter(adapter);

        btnstart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                HashMap<String, String> input = new HashMap<String, String>();

                input.put("shelf", etbookcase.getText().toString());
                input.put("employee", etnum.getText().toString());
                input.put("datetime", etday.getText().toString());

                String barcode = etbookcase.getText().toString();


                if (barcode.equals(""))
                    Toast.makeText(getApplicationContext(), "책꽃이번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();

                cws = new CommunicationWithServer(getApplicationContext());
                String result = cws.register_input(input);

                if (result.equals("null") || result.equals("fail")) {
                    Toast.makeText(getApplicationContext(), "작업을 시작할 수 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    jobnumber = result;
                    Toast.makeText(getApplicationContext(), "작업을 시작하세요.", Toast.LENGTH_SHORT).show();
                    btnsearch.setClickable(true);

                }

            }
        });

        btncheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String barcode = etbookcase.getText().toString();


                if (barcode.equals(""))
                    Toast.makeText(getApplicationContext(), "책꽃이번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();

                cws = new CommunicationWithServer(getApplicationContext());
                String result = cws.check_shelf_id(barcode);

                if (result.equals("ok")) {
                    Toast.makeText(getApplicationContext(), "책꽃이번호가 존재합니다..", Toast.LENGTH_SHORT).show();
                    btnstart.setClickable(true);
                } else {
                    Toast.makeText(getApplicationContext(), "책꽃이번호가 존재하지 않습니다. ", Toast.LENGTH_SHORT).show();
                }


            }
        });


        /**책 바코드 찾기**/
        btnsearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                HashMap<String, String> input = new HashMap<String, String>();

                input.put("input", jobnumber);
                input.put("shelf", etbookcase.getText().toString());
                input.put("usedbook", etbarcode.getText().toString());

                String barcode = etbarcode.getText().toString();

                if (barcode.equals(""))
                    Toast.makeText(getApplicationContext(), "책바코드가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();

                cws = new CommunicationWithServer(getApplicationContext());
                HashMap<String, String> result = cws.input(input);




                if (result != null) {
                    Toast.makeText(getApplicationContext(), "입력되었습니다.", Toast.LENGTH_SHORT).show();

                    String title = result.get("title");
                    String author = result.get("author");
                    String grade = result.get("grade");

                    adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                            title,author,grade
                    ));
                    listView.setAdapter(adapter);

                } else {
                    Toast.makeText(getApplicationContext(), "바코드 에러", Toast.LENGTH_SHORT).show();
                }



//                adapter.notifyDataSetChanged();
//                onResume();
            }
        });


/**
 * //                adapter.notifyDataSetInvalidated();
 //                adapter.clear();
 if(etbarcode.getText().toString().equals("1"))
 {
 adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),              //lisview 추가 하는 곳
 "JAVA의 정석\t", "남궁성\t", "A\t "
 ));
 //                    listView.setAdapter(adapter);
 }
 else if(etbarcode.getText().toString().equals("2"))
 {
 adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
 "개미\t", "KAIST\t", "B\t "
 ));
 //                    listView.setAdapter(adapter);
 }else
 {


 }
 //                adapter.notifyAll();

 *
 *
 * **/


    }

    public boolean onTouchEvent(MotionEvent event) {

        // 터치 up이 되었을 때 화면을 갱신한다.
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                // invalidate()을 호출하면 화면을 갱신한다.
                view.invalidate();
                break;
        }

        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();

    }
}
