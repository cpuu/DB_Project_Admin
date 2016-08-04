package com.example.jang.db_project_admin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Jang on 2016-07-30.
 */
public class PurchaseActivity1 extends Activity {
    User user;
    Button btncancel,btnaccept;
    EditText etname, etday, etnum, etpurnum, etprice, etbank,etseller, etaccount, etphone, etdepositor;
            /**이름, 날자,  사번   구매번호   구매금액, 은행명, 판매인,  계좌번호,   전화번호,   예금주**/




            int i;


    Spinner [] spincategory;
    Spinner [] spingrade;
    EditText [] editcnt;
    TextView [] subsum;
    String [] str;
    Button btncal;
    ArrayAdapter<CharSequence> [] adspincategory;
    ArrayAdapter<CharSequence> [] adspingrade;

    HashMap<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_layout);


        init();


        TabHost tab_host = (TabHost) findViewById(R.id.tabhost);
        tab_host.setup();

        TabHost.TabSpec ts1 = tab_host.newTabSpec("tab1");
        ts1.setIndicator("구매");
        ts1.setContent(R.id.tab1);
        tab_host.addTab(ts1);

        TabHost.TabSpec ts2 = tab_host.newTabSpec("tab2");
        ts2.setIndicator("표준계산");
        ts2.setContent(R.id.tab2);
        tab_host.addTab(ts2);


//        for(i=0; i < 10; i++)
        {
//모두다 추가해야될듯??
            spincategory[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(PurchaseActivity1.this,
//                            adspincategory[i].getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
                    Log.d(String.valueOf(adspincategory[0].getItem(position)),"logddd");

                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            spingrade[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(PurchaseActivity1.this,
//                            adspingrade[i].getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
                    str[0] = String.valueOf(adspingrade[0].getItem(position));
                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }

        /**계산 버튼**/
        btncal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subsum[0].setText(String.valueOf( calculate(str[0].toString()) * Integer.parseInt(editcnt[0].getText().toString())) );
//                subsum[0].setText(str[0]);
            }
        });

        /**취소 버튼**/
        btncancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });

        /**확인 버튼**/
        btnaccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String employee, datetime, temp, provider, phone, account_number, account_bank, account_owner;
                int price = 0;
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                etday.setText(CurDateFormat.format(date));

                employee = etnum.getText().toString();                      //사번
                datetime = CurDateFormat.format(date);                       //구매날짜
                price = Integer.parseInt((etprice.getText().toString()));   //가격
                provider = etseller.getText().toString();                   //판매인
                phone = etphone.getText().toString();                       //전화번호
                account_number = etaccount.getText().toString();            //계좌번호
                account_bank = etbank.getText().toString();                 //은행명
                account_owner = etdepositor.getText().toString();            //예금주

                /**
                 * etname, etday, etnum, etpurnum, etprice, etbank,etseller, etaccount, etphone, etdepositor;
                   이름,   날짜  사번   구매번호   구매금액, 은행명, 판매인,  계좌번호,   전화번호,   예금주*


                 */


                if(price == 0)
                    Toast.makeText(getApplicationContext(), "가격이 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                else if(provider.equals(""))
                    Toast.makeText(getApplicationContext(), "판매자가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                else if(phone.equals(""))
                    Toast.makeText(getApplicationContext(), "전화번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                else if(account_number.equals(""))
                    Toast.makeText(getApplicationContext(), "계좌번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                else if(account_bank.equals(""))
                    Toast.makeText(getApplicationContext(), "은행명이 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                else if(account_owner.equals(""))
                    Toast.makeText(getApplicationContext(), "예금주가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();

                map.put("employee",employee);
                map.put("datetime",datetime);
                map.put("price",etprice.getText().toString());
                map.put("provider",provider);
                map.put("phone",phone);
                map.put("account_number",account_number);
                map.put("account_bank", account_bank);
                map.put("account_owner", account_owner);

                CommunicationWithServer cws = new CommunicationWithServer(getApplicationContext());
                String result = cws.purchaseTask(map);
//                etpurnum.setText(result);
                String tmp="";
                try
                {
//            result = result.replace("}{","},{");            //JSON 형식 맞추기
//            result = "{\"grade\":[" + result + "]}";        //JSON 형식 맞추기
//            result = result.replace("},]}","}]}");


                    JSONObject json = new JSONObject(result);
                    //ksk_list의 값은 배열로 구성 되어있으므로 JSON 배열생성
                    JSONArray jArr = json.getJSONArray("rows");
                    String a = "";
                    for (int i=0; i<jArr.length(); i++){

                        //i번째 배열 할당
                        json = jArr.getJSONObject(i);
                        tmp = json.getString("id_auto");

                    }

                }catch (JSONException e)
                {
                    String error = e.getMessage();
                }

                etpurnum.setText(String.valueOf(tmp));


            }
        });


        tab_host.setCurrentTab(0);

    }
    /**
     * etname, etday, etnum, etpurnum, etprice, etbank,etseller, etaccount, etphone, etdepositor;
        이름,   날짜  사번   구매번호   구매금액, 은행명, 판매인,  계좌번호,   전화번호,   예금주*


     */

    public int calculate(String str)
    {
        if(str.toString().equals("A"))
            return 100;
        else
            return 200;
    }

    public void init()
    {



        int i;

        user = getIntent().getParcelableExtra("user");

        map = new HashMap<String, String>();

        btncal = (Button)findViewById(R.id.btncal_purchase);
        btncancel = (Button)findViewById(R.id.btncancel_purchase);
        btnaccept = (Button)findViewById(R.id.btnaccept_purchase);

        etname = (EditText)findViewById(R.id.etname_purchase);
        etday = (EditText)findViewById(R.id.etday_purchase);
        etnum = (EditText)findViewById(R.id.etnum_purchase);
        etpurnum = (EditText)findViewById(R.id.etpurnum_purchase);
        etprice = (EditText)findViewById(R.id.etprice_purchase);
        etbank = (EditText)findViewById(R.id.etbank_purchase);
        etseller = (EditText)findViewById(R.id.etseller_purchase);
        etaccount = (EditText)findViewById(R.id.etaccount_purchase);
        etphone = (EditText)findViewById(R.id.etphone_purchase);
        etdepositor= (EditText)findViewById(R.id.etdepositor_purchase);


        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        etday.setText(CurDateFormat.format(date));


        /**초기 이름, 사번 입력**/
        etname.setText(user.getName());
        etnum.setText(user.getEmployee_number());

        spincategory = new Spinner[10];
        spingrade = new Spinner[10];
        editcnt = new EditText[10];
        subsum = new TextView[10];
        adspincategory = new ArrayAdapter[10];
        adspingrade = new ArrayAdapter[10];
        str = new String[10];
/**
 * http://gonacon.blogspot.kr/2016/05/android-rid.html
 * **/
        for(i=0; i < 10; i++)
        {
//            str[i] = new String();

            String resName = "spincategory" + String.valueOf(i) + "_purchase";
            int resID = getResources().getIdentifier(resName,"id",this.getPackageName());
            spincategory[i] = (Spinner)findViewById(resID);

            resName = "spingrade" + String.valueOf(i) + "_purchase";
            resID = getResources().getIdentifier(resName,"id",this.getPackageName());
            spingrade[i] = (Spinner)findViewById(resID);

            resName = "editcnt" + String.valueOf(i) + "_purchase";
            resID = getResources().getIdentifier(resName,"id",this.getPackageName());
            editcnt[i] = (EditText) findViewById(resID);

            resName = "subsum" + String.valueOf(i) + "_purchase";
            resID = getResources().getIdentifier(resName,"id",this.getPackageName());
            subsum[i] = (TextView) findViewById(resID);


            Log.d("res2ID",String.valueOf(resID));
            Log.d("res2ID original",String.valueOf(R.id.subsum0_purchase));

            adspincategory[i] = ArrayAdapter.createFromResource(this, R.array.category,    android.R.layout.simple_spinner_item);
            adspincategory[i].setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spincategory[i].setAdapter(adspincategory[i]);

            adspingrade[i] = ArrayAdapter.createFromResource(this, R.array.grade,    android.R.layout.simple_spinner_item);
            adspingrade[i].setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spingrade[i].setAdapter(adspingrade[i]);
        }





//        spincategory = (Spinner)findViewById(R.id.spincategory1_purchase);
//        spingrade = (Spinner)findViewById(R.id.spingrade1_purchase);
//
//        spincategory.setPrompt("선택");
//        spingrade.setPrompt("선택");
//
//        adspincategory = ArrayAdapter.createFromResource(this, R.array.category,    android.R.layout.simple_spinner_item);
//        adspincategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spincategory.setAdapter(adspincategory);
//
//        adspingrade = ArrayAdapter.createFromResource(this, R.array.grade,    android.R.layout.simple_spinner_item);
//        adspingrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spingrade.setAdapter(adspingrade);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();

    }
}
