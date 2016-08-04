package com.example.jang.db_project_admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jang on 2016-07-30.
 */
public class SelectWorkActivity extends Activity {
    Button btnreadtowarehousing, btnwarehousing, btnpurchase, btndelilvery, btnemployeemangement, btnpricetable, btnpriceadjustment,btndb, btnrelease;
    TextView dbtv;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectwork_layout);

        btnreadtowarehousing = (Button)findViewById(R.id.btnreadytowarehousing_selectwork);
        btnwarehousing = (Button) findViewById(R.id.btnwarehousing_selectwork);
        btnpurchase = (Button)findViewById(R.id.btnpurchase_selectwork);
        btndelilvery = (Button)findViewById(R.id.btndelivery_selectwork);
        btnemployeemangement = (Button)findViewById(R.id.btnemployeemangement_selectwork);
        btnpricetable = (Button)findViewById(R.id.btnpricetable_selectwork);
        btnpriceadjustment = (Button)findViewById(R.id.btnpriceadjustment_selectwork);
        btndb = (Button)findViewById(R.id.btndb);
        btnrelease = (Button)findViewById(R.id.btnrelease_selectwork);

        dbtv = (TextView)findViewById(R.id.tvdb);


//        User user = intent.getExtras().getSerializable("user");
//        User user;
//        user = getIntent().getSerializableExtra("user");
        user = getIntent().getParcelableExtra("user");         //user 값을 가져오는 변수

//        String name = user.getName();

        btnpriceadjustment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),PriceAdjustmentActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });
        btndelilvery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DeliveryActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });

        btnemployeemangement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),EmployeeManagementActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });

        btnreadtowarehousing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ReadyToWarehousingActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });

        btnpurchase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /**구매팀**/
                Intent intent = new Intent(getApplicationContext(), PurchaseActivity1.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();


            }
        });

        btnpricetable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                /**구매팀**/
                Intent intent = new Intent(getApplicationContext(), PriceTableActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();


            }
        });


        btnwarehousing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), WarehousingActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });

        btndb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                CommunicationWithServer cws = new CommunicationWithServer(getApplicationContext());
                String result = cws.DBtest("grade");
                dbtv.setText(result);
            }
        });

        btnrelease.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ReleaseActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            }
        });
    }
}
