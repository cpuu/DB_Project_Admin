package com.example.jang.db_project_admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jang on 2016-07-31.
 */
public class PriceAdjustmentActivity extends Activity {
    User user;
    IconTextListAdapter adapter;
    ListView listView;
    Resources res;
    ArrayAdapter<CharSequence>  adspingrade;
    Spinner spinnergrade;
    EditText etname, etday, etnum, ettitle, etISBN,etprice;
    Button btnsave, btncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.priceadjustment_layout);


        init();

        btnsave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), EmployeeManagementActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
                startActivity(intent);
                finish();
            }
        });



        spinnergrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SearchActivity.this,
//                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {          //리스트 뷰에서 리스트 중 하나를 클릭 했을 때발생
//                IconTextItem curItem = (IconTextItem) adapter.getItem(position);
//                String[] curData = curItem.getData();
////                delete_position = position;
////                Toast.makeText(getApplicationContext(), "Selected : " + curData[0], Toast.LENGTH_LONG).show();
//                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(PriceAdjustmentActivity.this);
//                alert_confirm.setMessage("배송하시겠습니까?").setCancelable(false).setPositiveButton("확인",     //팝업 작동
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // 'YES'
////                                Cursor c = db.query("schedule", null, null, null, null, null, null);
////
////                                delete(delete_position + (c.moveToNext() ? c.getInt(c.getColumnIndex("_id")) : 0));
//                                onResume();
//                            }
//                        }).setNegativeButton("취소",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // 'No'
//                                return;
//                            }
//                        });
//                AlertDialog alert = alert_confirm.create();
//                alert.show();
//
//
//            }
//
//        });

    }

    public void init()
    {

        user = getIntent().getParcelableExtra("user");

        adapter = new IconTextListAdapter(this);
        listView = (ListView) findViewById(R.id.listview_priceadjustment);
        res = getResources();

        etname = (EditText)findViewById(R.id.etname_priceadjustment);
        etday = (EditText)findViewById(R.id.etday_priceadjustment);
        etnum = (EditText)findViewById(R.id.etnum_priceadjustment);
        ettitle = (EditText)findViewById(R.id.ettitle_priceadjustment);
        etISBN = (EditText)findViewById(R.id.etISBN_priceadjustment);
        etprice = (EditText)findViewById(R.id.etprice_priceadjustment);


        btnsave = (Button)findViewById(R.id.btnsave_priceadjustment);
        btncancel = (Button)findViewById(R.id.btncancel_priceadjustment);

        spinnergrade = (Spinner) findViewById(R.id.spingrade_priceadjustment);

        adspingrade = ArrayAdapter.createFromResource(this, R.array.grade,    android.R.layout.simple_spinner_item);
        adspingrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnergrade.setAdapter(adspingrade);


        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));


        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "JAVA의 정석", "A ", "1200  "
        ));

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "JAVA의 정석", "B ", "800  "
        ));

        adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.book),
                "JAVA의 정석", "C ", "500  "
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
