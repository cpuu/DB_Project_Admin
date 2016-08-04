package com.example.jang.db_project_admin;

/**
 * Created by Jang on 2016-07-28.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jang on 2016-07-27.
 */
public class LoginActivity extends Activity {
    User user;
    Button btnLogin;
    EditText etId, etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        btnLogin = (Button) findViewById(R.id.btnLogin_loginlayout);


        etId = (EditText) findViewById(R.id.etId_loginlayout);
        etpassword = (EditText) findViewById(R.id.etpassword_loginlayout);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               /**구매팀**/
//                Intent intent = new Intent(getApplicationContext(), PurchaseActivity1.class);
//                startActivity(intent);
//                finish();

                /**입고팀**/
                String id, password;

                id = etId.getText().toString();
                password = etpassword.getText().toString();

                if(id.equals("") || password.equals(""))
                    Toast.makeText(getApplicationContext(), "ID 혹은 Password를 입력하지 않았습니다.", Toast.LENGTH_SHORT).show();
                else
                {
                    CommunicationWithServer cws = new CommunicationWithServer(getApplicationContext());
                    String result = cws.loginTask(id,password);

                    if(result.equals("fail"))
                    {
                        Toast.makeText(getApplicationContext(), "ID 혹은 Password가 정확하지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        user = new User(result);
                        Intent intent = new Intent(getApplicationContext(), SelectWorkActivity.class);
                        intent.putExtra("user", user);
                        startActivity(intent);
                        finish();

                    }


                }


            }
        });

        /***로그인에 따라 뷰를 다르게 보여줄 수 있도록 DB에서 확인**/

//        btnLogin.setOnClickListener(new View.OnClickListener() {               //취소할 때 다시 전 activity로 돌아감
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//
//        btnRegister.setOnClickListener(new View.OnClickListener() {               //취소할 때 다시 전 activity로 돌아감
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });


    }

    public void onBackPressed() {


        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();

//        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(LoginActivity.this);
//        alert_confirm.setMessage("종료하시겠습니까?").setCancelable(false).setPositiveButton("확인",     //팝업 작동
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        moveTaskToBack(true);
//                        finish();
//                        android.os.Process.killProcess(android.os.Process.myPid());
//
//
//                    }
//                }).setNegativeButton("취소",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 'No'
//                        return;
//                    }
//                });
//
//        moveTaskToBack(true);
//        finish();
//        android.os.Process.killProcess(android.os.Process.myPid());
    }
}