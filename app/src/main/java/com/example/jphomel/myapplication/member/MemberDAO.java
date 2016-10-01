package com.example.jphomel.myapplication.member;

import android.util.Log;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public class MemberDAO {
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

    public MemberDTO insert(MemberDTO params) {
        MemberDTO memberVO = new MemberDTO();
        return memberVO;
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
