package com.example.jphomel.myapplication.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jphomel.myapplication.util.Retval;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {

    //
    public MemberDAO(Context context) {         //Context 는 실제 물리 메모리칩 상에 산재되어 있는 어플리케이션의 실제 주소(위치, 인덱스) 값이다.
        super(context, "hanbitdb", null, 1);    //위치값, 만들려는 db 명, 팩토리, 버전
        this.getWritableDatabase();             //입력 가능한 db 로 만든다.
        Log.i("db 생성되면 로그가 보인다.", "");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public MemberDTO select(MemberDTO params) {
        Log.i("params.getId", params.getId());
        Log.i("params.getPw", params.getPw());

        //FIXME
        MemberDTO memberVO = new MemberDTO();
        memberVO.setId("hong");
        memberVO.setPw("1");
        memberVO.setName("홍길동");
        return memberVO;
    }

    public Retval insert(MemberDTO params) {
        //FIXME
        Retval retval = new Retval();
        if (true) {
            retval.setMessage("SUCCESS");
        }
        else {
            retval.setMessage("FAIL");
        }

        return retval;
    }

    public MemberDTO update(MemberDTO params) {
        MemberDTO memberVO = new MemberDTO();
        return memberVO;
    }

    public MemberDTO delete(MemberDTO params) {
        MemberDTO memberVO = new MemberDTO();
        return memberVO;
    }
}
