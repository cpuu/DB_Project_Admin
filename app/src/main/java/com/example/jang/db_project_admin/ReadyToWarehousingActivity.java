package com.example.jang.db_project_admin;

import android.app.Activity;
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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Jang on 2016-07-30.
 */
public class ReadyToWarehousingActivity extends Activity {

    CommunicationWithServer cws;
    User user;
    ArrayAdapter<CharSequence> adspin;
    Spinner spinner;
    Button btnaccept, btncancel, btnISBNsearch, btnpurchasenumsearch, btnstart;
    EditText etname, etday, etnum, etpurchasenum, etISBN, ettitle, etpublic, etauthor, etprice, etbarcode;
    String auto_id, grade;
    /**
     * 이름, 날짜, 사번, 구매번호, ISBN, 제목, 출판사, 저자, 가격, 바코드
     **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readytowarehousing_layout);

        init();

        btnaccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HashMap<String,String> input = new HashMap<String, String>();

                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                if(etbarcode.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "바코드가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                else
                {
                    input.put("classifying",auto_id);
                    input.put("ISBN",etISBN.getText().toString());
                    input.put("barcode",etbarcode.getText().toString());
                    input.put("grade",grade);


                    cws = new CommunicationWithServer(getApplicationContext());
                    String result = cws.classifying(input);

                    if(result.equals("ok"))
                    {
                        Toast.makeText(getApplicationContext(), "책이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "에러", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


            }
        });

        btnISBNsearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String ISBN = etISBN.getText().toString();


                if (ISBN.equals(""))
                    Toast.makeText(getApplicationContext(), "ISBN 번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();

                cws = new CommunicationWithServer(getApplicationContext());
                HashMap<String,String> map = cws.ISBNSearchTask(ISBN);

                ettitle.setText(map.get("title"));
                etauthor.setText(map.get("author"));
                etprice.setText(map.get("price"));
                etpublic.setText(map.get("publisher"));



            }
        });

        btnpurchasenumsearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //check_buying_id

                String purchasenum = etpurchasenum.getText().toString();
                if (purchasenum.equals(""))
                    Toast.makeText(getApplicationContext(), "구매번호 번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();

                cws = new CommunicationWithServer(getApplicationContext());
               String result = cws.checkBuyingId(purchasenum);

                if(result.equals("ok"))
                {
                    Toast.makeText(getApplicationContext(), "구매번호가 존재합니다. 작업을 시작하세요.", Toast.LENGTH_SHORT).show();
                    btnstart.setClickable(true);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "구매번호가 존재하지 않습니다. 옳바른 구매번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //register_classifying
                HashMap<String,String> input = new HashMap<String, String>();

                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                input.put("buying",etpurchasenum.getText().toString());
                input.put("employee",etnum.getText().toString());
                input.put("datetime",CurDateFormat.format(date));


                cws = new CommunicationWithServer(getApplicationContext());
                HashMap<String,String> result = cws.registerClassifying(input);

                auto_id = result.get("id_auto");
                result.get("buying");
                result.get("employee");
                result.get("datetime");

            }
        });


        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        etday.setText(CurDateFormat.format(date));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SearchActivity.this,
//                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
                grade = adspin.getItem(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
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

    public void init() {



        btnISBNsearch = (Button) findViewById(R.id.btnISBNsearch_readytoware);
        btnpurchasenumsearch = (Button) findViewById(R.id.btnpurchasenumsearch_readtoware);
        btnaccept = (Button) findViewById(R.id.btnaccept_readytoware);
        btncancel = (Button) findViewById(R.id.btncancel_readytoware);
        btnstart = (Button) findViewById(R.id.btnstart_readtoware);


        etname = (EditText) findViewById(R.id.etname_readytoware);
        etday = (EditText) findViewById(R.id.etday_readytoware);
        etnum = (EditText) findViewById(R.id.etnum_readytoware);
        etpurchasenum = (EditText) findViewById(R.id.etpurchasenum_readytoware);
        etISBN = (EditText) findViewById(R.id.etISBN_readytoware);
        ettitle = (EditText) findViewById(R.id.ettitle_readytoware);
        etpublic = (EditText) findViewById(R.id.etpublic_readytoware);
        etauthor = (EditText) findViewById(R.id.etauthor_readtoware);
        etprice = (EditText) findViewById(R.id.etprice_readytoware);
        etbarcode = (EditText) findViewById(R.id.etbarcode_readtoware);

        spinner = (Spinner) findViewById(R.id.spingrade_readytoware);

//        spinner.setPrompt("검색 조건을 선택하세요");
        adspin = ArrayAdapter.createFromResource(this, R.array.grade, android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);


        user = getIntent().getParcelableExtra("user");
        etname.setText(user.getName());
        etnum.setText(user.getEmployee_number());
    }
}
