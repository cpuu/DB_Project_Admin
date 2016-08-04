package com.example.jang.db_project_admin;

import org.json.*;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

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
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;
/**
 * Created by Jang on 2016-08-03.
 */
public class User implements Parcelable {
    String name, phone, employee_number,department,position, id;
    int salary;

    public User(String userInfo)
    {
        try
        {
//            result = result.replace("}{","},{");            //JSON 형식 맞추기
//            result = "{\"grade\":[" + result + "]}";        //JSON 형식 맞추기
//            result = result.replace("},]}","}]}");


            JSONObject json = new JSONObject(userInfo);
            //ksk_list의 값은 배열로 구성 되어있으므로 JSON 배열생성
            JSONArray jArr = json.getJSONArray("rows");
            String a = "";


            /**
             * String name, phone, employee_number,department,position, id;
             * int salary;
             * **/
            for (int i=0; i<jArr.length(); i++){

                //i번째 배열 할당
                json = jArr.getJSONObject(i);
                name = json.getString("name");
                phone = json.getString("phone");
                employee_number = json.getString("employee_number");
                department = json.getString("department");
                position = json.getString("position");
                id = json.getString("id");
                salary = json.getInt("salary");

            }

        }catch (JSONException e)
        {
            String error = e.getMessage();
        }

    }

    protected User(Parcel in) {
        name = in.readString();
        phone = in.readString();
        employee_number = in.readString();
        department = in.readString();
        position = in.readString();
        id = in.readString();
        salary = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    /**
     * String name, phone, employee_number,department,position, id;
     * int salary;
     * **/

    public String getPhone() {return phone;}
    public String getName(){return name;}
    public String getEmployee_number(){return employee_number;}
    public String getDepartment(){return department;}
    public String getPosition(){return position;}
    public String getId(){return id;}
    public int getSalary(){return salary;}


    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(employee_number);
        dest.writeString(department);
        dest.writeString(position);
        dest.writeString(id);
        dest.writeInt(salary);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
