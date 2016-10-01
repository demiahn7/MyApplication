package com.example.jphomel.myapplication.member;

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
    MemberService service = new MemberServiceImpl();
    MemberDTO memberDTO = new MemberDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                    msg = "Welcome! "+rtnVO.getName()+"님";
                    Toast.makeText(this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.bt_join :
                Toast.makeText(this.getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
