package com.aiot_2.aiot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aiot_2.dataAiot.Data201111Activity_fire;

public class FireActivity extends AppCompatActivity {

    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        Button systemButton = (Button) findViewById(R.id.systemButton_setting);
        Button alarmButton = (Button) findViewById(R.id.alarmButton_setting);
        Button securityButton = (Button) findViewById(R.id.securityButton_setting);
        Button settingButton = (Button) findViewById(R.id.settingsButton_setting);

        searchText = (EditText) findViewById(R.id.editText);
        Button searchButton = (Button) findViewById(R.id.searchButton_fire);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = searchText.getText().toString();

                if(date.length() != 0){
                    if (date.equals("1111")){
                        Intent intent = new Intent(getApplicationContext(), Data201111Activity_fire.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"검색완료", Toast.LENGTH_SHORT).show();
                    }
                } else if(date.length() == 0){
                    Toast.makeText(getApplicationContext(),"날짜를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 아래바 알람버튼
       alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(intent);
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
            }
        });

        /**
         *  button 누르면 해당 날짜의 영상데이터와 센서데이터 값들 튀어나온다
         **/

        Button button201111fire = (Button)findViewById(R.id.button201111_fire);

        button201111fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"2020.11.11 data",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Data201111Activity_fire.class);
                startActivity(intent);
            }
        });
    }
}