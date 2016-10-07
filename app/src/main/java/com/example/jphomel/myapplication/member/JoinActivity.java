package com.example.jphomel.myapplication.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jphomel.myapplication.R;
import com.example.jphomel.myapplication.calc.CalcActivity;
import com.example.jphomel.myapplication.util.Retval;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id, et_pw, et_name, et_addr, et_phone, et_email, et_profileImg;
    Button bt_reg, bt_cancel;

    //java 은닉화
    //MemberService service = new MemberServiceImpl();
    MemberService service;
    MemberDTO memberDTO = new MemberDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        /**
         * TODO - 개념 재확인 필요
         * Context 는 실제 물리 메모리칩 상에 산재되어 있는 각 어플리케이션(ex. Activity, Service, DAO 등)의 실제 주소(위치, 인덱스) 값을 포함하고 있다. 물론 VO 처럼 데이터 값도 갖고 있다.
         * Context 개념이 필요한 이유는 SQLite 가 휴대폰 메모리로 로드되는데,
         * 각 어플리케이션(ex. Activity, Service, DAO 등)의 위치값을 알 수 없으면 DB 데이터를 각 어플리케이션(ex. Activity, Service, DAO 등)으로 넘겨줄 수 없기 때문에
         * 웹에서 각 어플리케이션(ex. Activity, Service, DAO 등)로 VO 등의 dataset를 넘기듯 Android 에서는 Context 를 넘겨주어야 일반 데이터 정보 뿐 아니라, DB 데이터 정보도 주고 받을 수 있다.
         */
        service = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_profileImg = (EditText) findViewById(R.id.et_profileImg);

        bt_reg = (Button) findViewById(R.id.bt_reg);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_reg.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s_et_id = String.valueOf(et_id.getText());
        String s_et_pw = String.valueOf(et_pw.getText());
        String s_et_name = String.valueOf(et_name.getText());
        String s_et_addr = String.valueOf(et_addr.getText());
        String s_et_phone = String.valueOf(et_phone.getText());
        String s_et_email = String.valueOf(et_email.getText());
        String s_et_profileImg = String.valueOf(et_profileImg.getText());
        memberDTO.setId(s_et_id);
        memberDTO.setPw(s_et_pw);
        memberDTO.setName(s_et_name);
        memberDTO.setAddr(s_et_addr);
        memberDTO.setPhone(s_et_phone);
        memberDTO.setEmail(s_et_email);
        memberDTO.setProfileImg(s_et_profileImg);

        switch (v.getId()) {
            case R.id.bt_reg :
                String msg = "";
                Retval retval = service.join(memberDTO);
                if ("SUCCESS".equals(retval.getMessage())) {
                    msg = "회원가입완료..로그인 하십시오.";

                    //this --> context, class --> 실제 물리 메모리 램
                    this.startActivity(new Intent(JoinActivity.this, LoginActivity.class)); //로그인 화면으로 이동
                }
                else {
                    msg = "회원가입실패..재시도 하십시오.";
                }

                Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();   //this.getApplicationContext() 는 메서드 안에서만 실행가능
                break;
            case R.id.bt_cancel :
                this.startActivity(new Intent(JoinActivity.this, CalcActivity.class));  //계산기 화면으로 이동
                break;
        }
    }
}
