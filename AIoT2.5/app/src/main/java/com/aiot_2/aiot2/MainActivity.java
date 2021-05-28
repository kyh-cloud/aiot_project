package com.aiot_2.aiot2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 시간 설정 (settings)
        Button settingsButton = (Button)findViewById(R.id.button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "설정", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onSearchButton(View view){
        Toast.makeText(getApplicationContext(), "검색", Toast.LENGTH_SHORT).show();
    }

    public void onSystemButton(View view){
        Toast.makeText(getApplicationContext(), "시스템관리", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), SystemActivity.class);
        startActivity(intent);
    }

    public void onSecurityButton(View view){
        Toast.makeText(getApplicationContext(), "보안관리", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), SecurityActivity.class);
        startActivity(intent);
    }

    public void onAlarmButton(View view){
        Toast.makeText(getApplicationContext(), " 알람", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
        startActivity(intent);
    }

    public void onFireButton(View view){
        Toast.makeText(getApplicationContext(), "화재관리", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), FireActivity.class);
        startActivity(intent);
    }
}
