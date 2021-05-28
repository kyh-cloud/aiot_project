package com.aiot_2.aiot2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    /*관리자 이름*/
    String kangyunmo = "강윤모";
    String sinjaesung = "신재성";
    String seunghyeong = "유승형";
    String kangyunho = "강윤호";

    /*관리자 아이디 및 비밀번호*/
    String id_yoo = "seunghy1468", id_yunmo = "yunmo", id_jaesung = "jaesung", id_yunho = "yunho";
    String password_yoo = "1468", password_yunmo = "1234", password_jaesung = "1234", password_yunho = "1234";

    /*로그인 화면에 입력하는 아이디 및 비밀번호*/
    EditText id;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButton(View view){
        id = findViewById(R.id.editTextTextPersonName);         // 아이디 입력한 것을 찾음
        password = findViewById(R.id.editTextTextPassword);     // 비밀번호 입력한 것을 찾음

        /*관리자 아이디 및 비밀번호와 같은지 비교한다*/
        // 관리자 : 유승형
        if(id.getText().toString().equals(id_yoo) && password.getText().toString().equals((password_yoo))){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"관리자 : " + seunghyeong +" 로그인 되었습니다.",Toast.LENGTH_SHORT).show();
        }
        // 관리자 : 강윤모
        else if(id.getText().toString().equals(id_yunmo) && password.getText().toString().equals((password_yunmo))){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"관리자 : " + kangyunmo +" 로그인 되었습니다.",Toast.LENGTH_SHORT).show();
        }
        // 관리자 : 신재성
        else if(id.getText().toString().equals(id_jaesung) && password.getText().toString().equals((password_jaesung))){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"관리자 : " + sinjaesung +" 로그인 되었습니다.",Toast.LENGTH_SHORT).show();
        }
        // 관리자 : 고기은
        else if(id.getText().toString().equals(id_yunho) && password.getText().toString().equals((password_yunho))){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"관리자 : " + kangyunho +" 로그인 되었습니다.",Toast.LENGTH_SHORT).show();
        }
        // 관리자 아닐 시.
        else{
            Toast.makeText(getApplicationContext(),"아이디 혹은 비밀번호가 틀렸습나다.",Toast.LENGTH_SHORT).show();
        }
    }
}