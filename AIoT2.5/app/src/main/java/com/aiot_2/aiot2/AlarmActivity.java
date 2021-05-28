package com.aiot_2.aiot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aiot_2.aiot2.data.JsonInfo;
import com.aiot_2.aiot2.data.JsonList;
import com.aiot_2.aiot2.data.ResponseInfo;
import com.aiot_2.aiot2.data.SystemJsonInfo;
import com.aiot_2.aiot2.data.SystemJsonList;
import com.aiot_2.aiot2.data.SystemResponseInfo;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class AlarmActivity extends AppCompatActivity {

    TextView textView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button systemButton = (Button) findViewById(R.id.systemButton_alarm);
        Button alarmButton = (Button) findViewById(R.id.alarmButton_alarm);
        Button securityButton = (Button) findViewById(R.id.securityButton_alarm);
        Button settingButton = (Button) findViewById(R.id.settingsButton_alarm);

        // 아래바 알람버튼
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // 아래바 시스템관리버튼
        systemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SystemActivity.class);
                startActivity(intent);
            }
        });

        // 아래바 보안관리버튼
        securityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecurityActivity.class);
                startActivity(intent);
            }
        });

        // 아래바 설정버튼
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FireActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 주요알림 보여줌
         **/

        textView = (TextView)findViewById(R.id.alarmTextView);
        /*equestDataList();
        Toast.makeText(getApplicationContext(),"read data",Toast.LENGTH_SHORT).show();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(true){
                    handler.postDelayed(this,1000);
                }
                requestDataList();
            }
        },1000);

        // volley로 request 객체를 만듦
        if(AppHelper.requestQueue == null){
            AppHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }*/
    }

    /**
     * onCreate 밖
     **/
    // request 객체를 만들어서 요청을 하도록함 (data 목록을 이렇게 요청함! AppHelper라는 리퀘스트큐를 만들어서!)

    /*public void requestDataList(){
        String url = "http://" + AppHelper.host +":" +AppHelper.port +"/view2.php";
        // 요청파라미터
        url += "?" + "type=1";

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        //println("응답 받음 -->" +"\n"+ response + "\n");

                        // Gson을 이용해서 응답을 자바 객체로 바꿀수 있도록 함
                        processResponse(response);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if(true){
                                    handler.postDelayed(this,1007);
                                }
                                processResponse(response);
                            }
                        },1007);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("에러 발생 -->" +"\n"+ error.getMessage() + "\n");
                    }
                }
        );

        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);
        textView.setText("data 요청 보냈습니다." + "\n");
    }

    // data란 package를 만들어서 우리가 응답 처리를 할 때 정의할 자바 객체, 만들 클래스를 정의하도록 함
    public void processResponse(String response){
        Gson gson = new Gson();

        SystemResponseInfo info = gson.fromJson(response, SystemResponseInfo.class);

        if(info.code==100){
            SystemJsonList jsonList = gson.fromJson(response,SystemJsonList.class);
            //Toast.makeText(getApplicationContext(),info.message,Toast.LENGTH_SHORT).show();
            //println("data 개수 :" + jsonList.result.size());

            // data의 순서, 이름, 키, 몸무게만 보여주고 싶다!
            for (int i = 0; i < jsonList.result.size(); i++){
                SystemJsonInfo jsonInfo = jsonList.result.get(i);
                //println("순서 #" + i + " -> " + jsonInfo.name + ", " + jsonInfo.height + ", " + jsonInfo.weight);
                try{ println("온도 : "+jsonInfo.temp +"°C " +"\n"+ "CO 농도측정1 : "+jsonInfo.COgas_1 + "ppm " + "\n"+"CO 농도측정2 : "+jsonInfo.COgas_2 + "ppm ");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void println(String data){

        textView.append(data + "\n");
        /*if(data != null) {
            textView.append(data + "\n");
        }else if(data == null){
            textView.append("" + "\n");
        }*/
    //}
}