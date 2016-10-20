package com.example.jphomel.myapplication.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jphomel.myapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id, et_pw;
    Button bt_login, bt_join;

    //java 은닉화
    //MemberService service = new MemberServiceImpl();
    MemberService service;
    MemberDTO memberDTO = new MemberDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        bt_login = (Button) findViewById(R.id.bt_login );
        bt_join = (Button) findViewById(R.id.bt_join );
        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String s_et_id = String.valueOf(et_id.getText());
        String s_et_pw = String.valueOf(et_pw.getText());

        //if (null == s_et_id || "".equals(s_et_id.trim())) s_et_id = "";
        //if (null == s_et_pw || "".equals(s_et_pw.trim())) s_et_pw = "";

        switch (v.getId()) {
            case R.id.bt_login :
                String msg = "ID : "+s_et_id+", PW : "+s_et_pw;
                //Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

                memberDTO.setId(s_et_id);
                memberDTO.setPw(s_et_pw);
                MemberDTO rtnVO = service.login(memberDTO);
                if ("NONE_ID".equals(rtnVO.getMsg())) {
                    msg = "존재하지 않는 ID 입니다.";
                    Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }
                else if ("NO_MATCH_PW".equals(rtnVO.getMsg())) {
                    msg = "PW가 일치하지 않습니다.";
                    Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }
                else {
                    this.startActivity(new Intent(LoginActivity.this, com.example.jphomel.myapplication.member.ListActivity.class)); //리스트뷰 화면으로 이동

                    msg = "Welcome! "+rtnVO.getName()+"님";
                    Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.bt_join :
                this.startActivity(new Intent(LoginActivity.this, JoinActivity.class)); //회원가입 화면으로 이동
                Toast.makeText(this.getApplicationContext(), "회원가입 화면으로 이동~", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
