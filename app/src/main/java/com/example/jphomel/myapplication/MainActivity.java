package com.example.jphomel.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jphomel.myapplication.member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_calc, bt_contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //View 설정 of MVC

        bt_calc = (Button) findViewById(R.id.bt_calc);
        bt_contents = (Button) findViewById(R.id.bt_contents);

        bt_calc.setOnClickListener(this);
        bt_contents.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_calc :
                //Intent는 메시지 객체이다.
                //Intent intent = new Intent(this.getApplicationContext(), CalcActivity.class);
                //this.startActivity(intent);
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));  //MainActivity 에서 MemberActivity 로 이동.

                //Toast message --> script의 alert과 유사
                Toast.makeText(this.getApplicationContext(), "MainActivity 에서 LoginActivity 로 이동~~", Toast.LENGTH_SHORT).show();

                break;
            case R.id.bt_contents :

                break;
        }

    }
}
