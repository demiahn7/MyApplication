package com.example.jphomel.myapplication.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jphomel.myapplication.R;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_num_1, et_num_2;
    Button bt_1, bt_2, bt_3, bt_4, bt_5, bt_6;
    TextView tv_1;
    int result = 0;

    //java 은닉화
    CalcService service = new CalcServiceImpl();
    CalcDTO vo = new CalcDTO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc); //View 설정 of MVC

        et_num_1 = (EditText) findViewById(R.id.et_num_1);  //R --> res 폴더를 뜻함.
        et_num_2 = (EditText) findViewById(R.id.et_num_2);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        tv_1 = (TextView) findViewById(R.id.tv_1);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s_et_num_1 = String.valueOf(et_num_1.getText());
        String s_et_num_2 = String.valueOf(et_num_2.getText());

        if (null == s_et_num_1 || "".equals(s_et_num_1.trim())) return;
        if (null == s_et_num_2 || "".equals(s_et_num_2.trim())) return;

        int num1 = Integer.parseInt(s_et_num_1);
        int num2 = Integer.parseInt(s_et_num_2);

        //은닉화
        vo.setNum1(num1);
        vo.setNum2(num2);

        //algorithm
        switch (v.getId()) {
            case R.id.bt_1:
                //result = num1 + num2;
                result = service.plus(vo).getResult();
                break;
            case R.id.bt_2:
                //result = num1 - num2;
                result = service.minus(vo).getResult();
                break;
            case R.id.bt_3:
                //result = num1 * num2;
                result = service.multi(vo).getResult();
                break;
            case R.id.bt_4:
                //result = num1 / num2;
                result = service.divide(vo).getResult();
                break;
            case R.id.bt_5:
                //result = num1 % num2;
                result = service.remainder(vo).getResult();
                break;
            case R.id.bt_6:
                tv_1.setText("결과확인 : " + result);
                break;
        }

        //Toast message --> script의 alert과 유사
        Toast.makeText(getApplicationContext(), "버튼 클릭~", Toast.LENGTH_SHORT).show();
    }
}
