package com.example.jang.db_project_admin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by 경모 on 2016-05-25.
 */
public class CommunicationWithServer {
    public static final int CONNECTION_TIMEOUT = 15 * 1000;
    private Context context;

    public CommunicationWithServer(Context context) {
        this.context = context;
    }




    public String loginTask(String id, String password){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("login");
        arrayList.add(id);
        arrayList.add(password);
        String[] list = arrayList.toArray(new String[arrayList.size()]); // 아이디 비밀번호 받아옴
        String result = null;

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//aa/d
 return result;
    }

    public String purchaseTask(HashMap<String,String> map)
    {


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("purchase");
        arrayList.add(map.get("employee"));
        arrayList.add(map.get("datetime"));
        arrayList.add(map.get("price"));
        arrayList.add(map.get("provider"));
        arrayList.add(map.get("phone"));
        arrayList.add(map.get("account_number"));
        arrayList.add(map.get("account_bank"));
        arrayList.add(map.get("account_owner"));


        String[] list = arrayList.toArray(new String[arrayList.size()]); // 아이디 비밀번호 받아옴
        String result = null;

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;

    }

    public String add_employee(HashMap<String,String> map)
    {
        // 직원정보관리에서 등록을 누를 때 사용( 새로운 직원의 직원정보를 추가할 때 사용 )
        // 추가된 직원의 정보를 employee 테이블에 insert함
        // ok 또는 fail을 리턴

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("add_employee");
        arrayList.add(map.get("name"));
        arrayList.add(map.get("phone"));
        arrayList.add(map.get("employee_number"));
        arrayList.add(map.get("department"));
        arrayList.add(map.get("position"));
        arrayList.add(map.get("salary"));
        arrayList.add(map.get("entry_date"));
        arrayList.add(map.get("retire_date"));
        arrayList.add(map.get("id"));
        arrayList.add(map.get("password"));
        arrayList.add(map.get("retire_date"));

        String[] list = arrayList.toArray(new String[arrayList.size()]); // 아이디 비밀번호 받아옴
        String result = null;

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;

    }

    public HashMap<String,String>  ISBNSearchTask(String ISBN)
    {
        HashMap<String,String> map  = new HashMap<String, String>();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ISBNSearchTask");
        arrayList.add(ISBN );

        String[] list = arrayList.toArray(new String[arrayList.size()]); // 아이디 비밀번호 받아옴
        String result = null;

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
                map.put("title",json.getString("title"));
                map.put("author",json.getString("author"));
                map.put("publisher",json.getString("publisher"));
                map.put("category",json.getString("category"));
                map.put("price",json.getString("price"));

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

        return map;

    }

    public String checkBuyingId(String purchasenum)
    {
        String result = "";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("checkbuyingid");
        arrayList.add(purchasenum );

        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String DBtest(String grade)
    {
        String tmp="";
//        String result = "";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DBtest");
        arrayList.add(grade);

        String[] list = arrayList.toArray(new String[arrayList.size()]);
        String result = null;

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            return null;
        } catch (ExecutionException e) {
            return null;
        }
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
                String name = json.getString(grade);
                tmp += name + " / ";
            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }
        return tmp;
    }

    public HashMap<String,String> registerClassifying(HashMap<String,String> map)
    {

        String result="";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("register_classifying");
        arrayList.add(map.get("buying"));
        arrayList.add(map.get("employee"));
        arrayList.add(map.get("datetime"));

        HashMap<String,String> temp = new HashMap<>();



        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
                temp.put("id_auto",json.getString("id_auto"));
                temp.put("buying",json.getString("buying"));
                temp.put("employee",json.getString("employee"));
                temp.put("datetime",json.getString("datetime"));

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

        return temp;

    }

    public String classifying(HashMap<String,String> map)
    {
        String result="";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("classifying");
        arrayList.add(map.get("classifying"));
        arrayList.add(map.get("ISBN"));
        arrayList.add(map.get("barcode"));
        arrayList.add(map.get("grade"));

        HashMap<String,String> temp = new HashMap<>();



        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return result;


    }

    public String packing(HashMap<String,String> map)
    {
        String result="";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("packing");
        arrayList.add(map.get("packing"));
        arrayList.add(map.get("order"));
        arrayList.add(map.get("delivery_number"));

        HashMap<String,String> temp = new HashMap<>();



        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return result;

    }

    public String check_shelf_id(String shelfnumber)
    {
        String result="";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("check_shelf_id");
        arrayList.add(shelfnumber);


        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;
    }



    public String register_input(HashMap<String,String > input)
    {
        String result = "";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("register_input");
        arrayList.add(input.get("shelf"));
        arrayList.add(input.get("employee"));
        arrayList.add(input.get("datetime"));


        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
                result = json.getString("id_auto");

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }


        return result;
    }


    public HashMap<String, String> input(HashMap<String,String> input)
    {
        String result = "";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("input");

        arrayList.add(input.get("input"));
        arrayList.add(input.get("shelf"));
        arrayList.add(input.get("usedbook"));

        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        HashMap<String,String> temp = new HashMap<>();

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
                temp.put("title",json.getString("title"));
                temp.put("author",json.getString("author"));
                temp.put("grade",json.getString("grade"));

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

        return temp;

    }

    public HashMap<String, String> get_outwaitbook(HashMap<String,String> input)
    {
        String result = "";
        HashMap<String,String> temp = new HashMap<>();

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
                temp.put("title",json.getString("title"));
                temp.put("barcode",json.getString("barcode"));
                temp.put("shelf",json.getString("shelf"));

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

        return temp;

    }

    public HashMap<String,String> register_output(HashMap<String,String> map)
    {

        String result="";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("register_output");
        arrayList.add(map.get("employee"));
        arrayList.add(map.get("datetime"));

        HashMap<String,String> temp = new HashMap<>();



        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
                temp.put("id_auto",json.getString("id_auto"));

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

        return temp;

    }

    public HashMap<String,String> register_packing(HashMap<String,String> map)
    {

        String result="";

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("register_packing");
        arrayList.add(map.get("employee"));
        arrayList.add(map.get("datetime"));

        HashMap<String,String> temp = new HashMap<>();



        String[] list = arrayList.toArray(new String[arrayList.size()]);

        CommunicationAsyncTask communicationAsyncTask = new CommunicationAsyncTask();
        try {
            result = communicationAsyncTask.execute(list).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
                temp.put("id_auto",json.getString("id_auto"));

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

        return temp;

    }

    private class CommunicationAsyncTask extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog = new ProgressDialog(context);
        @Override
        protected void onPreExecute() {
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.setMessage("Loading...");
//            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String communicationType = null;
            String sql = null;
            String mode = null;
            String serverUrl = null;
            StringBuilder output = new StringBuilder(); // thread에서 나온 output

            communicationType = params[0];
            if(communicationType.equals("sql")) {
                mode = params[1];
                sql = params[2];

                if (mode.equals("select"))
                    serverUrl = "http://gyeongmo.synology.me/dochal/php/select.php";
                else
                    serverUrl = "http://gyeongmo.synology.me/dochal/php/nonselect.php";
            }
            else if(communicationType.equals("register")){
                serverUrl = "http://gyeongmo.synology.me/dochal/php/register.php";
            }
            else if(communicationType.equals("login")){
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/login.php";
            }
            else if(communicationType.equals("push")){
                serverUrl = "http://gyeongmo.synology.me/dochal/php/gcm.php";
            }
            else if(communicationType.equals("DBtest"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/login_test.php";
            }
            else if(communicationType.equals("purchase"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/buying.php";
            }
            else if(communicationType.equals("ISBNSearchTask"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/get_bookinfo.php";
            }
            else if(communicationType.equals("checkbuyingid"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/check_buying_id.php";
            }
            else if(communicationType.equals("register_classifying"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/register_classifying.php";
            }
            else if(communicationType.equals("classifying"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/classifying.php";
            }
            else if(communicationType.equals("check_shelf_id"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/check_shelf_id.php";
            }
            else if(communicationType.equals("register_input"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/register_input.php";
            }
            else if(communicationType.equals("register_output"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/register_output.php";
            }
            else if(communicationType.equals("register_packing"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/register_packing.php";
            }
            else if(communicationType.equals("input"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/input.php";
            }
            else if(communicationType.equals("packing"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/packing.php";
            }
            else if(communicationType.equals("add_employee"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/add_employee.php";
            }
            else if(communicationType.equals("get_outwaitbook"))
            {
                serverUrl = "http://gyeongmo.synology.me/amazo/admin/get_outwaitbook.php";
            }
            try {
                // 연결 url 설정
                URL url = new URL(serverUrl);
                // 커넥션 객체 생성
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                // 연결되었스면,
                if(conn != null){
                    conn.setReadTimeout(CONNECTION_TIMEOUT);
                    conn.setConnectTimeout(CONNECTION_TIMEOUT);
                    conn.setUseCaches(false);
                    conn.setDoInput(true);
                    // 헤더값을 설정한다.
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    // 전달 방식을 설정한다. POST or GET, 기본값은 GET 이다.
                    conn.setRequestMethod("POST");
                    // 서버로 데이터를 전송할 수 있도록 한다. GET방식이면 사용될 일이 없으나, true로 설정하면 자동으로 POST로 설정된다. 기본값은 false이다.
                    conn.setDoOutput(true);
                    conn.setDefaultUseCaches(false);

                    // Append parameters to URL
                    Uri.Builder builder = new Uri.Builder();
                    if(communicationType.equals("sql")) {
                        builder.appendQueryParameter("sql", sql);
                    }
                    else if(communicationType.equals("register")){
                        builder.appendQueryParameter("id", params[1]);
                        builder.appendQueryParameter("password", params[2]);
                        builder.appendQueryParameter("name", params[3]);
                        builder.appendQueryParameter("phone", params[4]);
                        builder.appendQueryParameter("type", params[5]);
                        builder.appendQueryParameter("gcm_id", params[6]);
                    }
                    else if(communicationType.equals("login")){
                        builder.appendQueryParameter("id", params[1]);
                        builder.appendQueryParameter("password", params[2]);
                    }
                    else if(communicationType.equals("push")){
                        builder.appendQueryParameter("post_id", params[1]);
                        builder.appendQueryParameter("demander_id", params[2]);
                        builder.appendQueryParameter("poster_id", params[3]);
                        builder.appendQueryParameter("title", params[4]);
                        builder.appendQueryParameter("demander_name", params[5]);
                    }
                    else if(communicationType.equals("DBtest"))             //파라미터 추가.
                    {
                        builder.appendQueryParameter("grade",params[1]);
                    }
                    else if(communicationType.equals("purchase"))
                    {
                        builder.appendQueryParameter("employee",params[1]);
                        builder.appendQueryParameter("datetime",params[2]);
                        builder.appendQueryParameter("price",params[3]);
                        builder.appendQueryParameter("provider",params[4]);
                        builder.appendQueryParameter("phone",params[5]);
                        builder.appendQueryParameter("account_number",params[6]);
                        builder.appendQueryParameter("account_bank",params[7]);
                        builder.appendQueryParameter("account_owner",params[8]);

                    }
                    else if(communicationType.equals("ISBNSearchTask"))
                    {
                        builder.appendQueryParameter("ISBN",params[1]);
                    }
                    else if(communicationType.equals("checkbuyingid"))
                    {
                        builder.appendQueryParameter("id_auto",params[1]);
                    }
                    else if(communicationType.equals("register_classifying"))
                    {
                        builder.appendQueryParameter("buying",params[1]);
                        builder.appendQueryParameter("employee",params[2]);
                        builder.appendQueryParameter("datetime",params[3]);
                    }
                    else if(communicationType.equals("classifying"))
                    {
                        builder.appendQueryParameter("classifying",params[1]);
                        builder.appendQueryParameter("ISBN",params[2]);
                        builder.appendQueryParameter("barcode",params[3]);
                        builder.appendQueryParameter("grade",params[4]);
                    }
                    else if(communicationType.equals("check_shelf_id"))
                    {
                        builder.appendQueryParameter("barcode",params[1]);
                    }
                    else if(communicationType.equals("register_input"))
                    {
                        builder.appendQueryParameter("shelf",params[1]);
                        builder.appendQueryParameter("employee",params[2]);
                        builder.appendQueryParameter("datetime",params[3]);

                    }else if(communicationType.equals("input"))
                    {
                        builder.appendQueryParameter("input",params[1]);
                        builder.appendQueryParameter("shelf",params[2]);
                        builder.appendQueryParameter("usedbook",params[3]);
                    }else if(communicationType.equals("output"))
                    {
                        builder.appendQueryParameter("output",params[1]);
                        builder.appendQueryParameter("usedbook",params[2]);
                    }else if(communicationType.equals("packing"))
                    {
                        builder.appendQueryParameter("packing",params[1]);
                        builder.appendQueryParameter("order",params[2]);
                        builder.appendQueryParameter("delivery_number",params[3]);
                    }
                    else if(communicationType.equals("register_output"))
                    {
                        builder.appendQueryParameter("employee",params[1]);
                        builder.appendQueryParameter("datetime",params[2]);
                    }
                    else if(communicationType.equals("register_packing"))
                    {
                        builder.appendQueryParameter("employee",params[1]);
                        builder.appendQueryParameter("datetime",params[2]);
                    }
                    else if(communicationType.equals("get_outwaitbook"))
                    {
                        builder.appendQueryParameter("title",params[1]);
                        builder.appendQueryParameter("barcode",params[2]);
                        builder.appendQueryParameter("shelf",params[3]);
                    }


                    String query = builder.build().getEncodedQuery();

                    // server에 파라미터 보내줌
                    OutputStream opstrm = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(opstrm, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    //opstrm.write(param.getBytes());
                    opstrm.flush();
                    opstrm.close();

                    //연결되었음 코드가 리턴되면,
                    if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        while(true){
                            // 웹상에 보여지는 텍스트를 라인 단위로 읽어 저장.
                            String line = br.readLine();
                            if(line == null) break;
                            // 저장된 텍스트 라인을 jsonString에 붙여 넣음
                            output.append(line);
                        }
                        br.close();
                    }
                    conn.disconnect();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return output.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            super.onPostExecute(s);
        }
    }

}
