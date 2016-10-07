package com.example.jphomel.myapplication.member;

import android.content.Context;

import com.example.jphomel.myapplication.util.Retval;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService {
    //MemberDAO dao = new MemberDAO();  <-- 맴버변수(필드)에는 초기화를 해선 안된다.
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public MemberDTO login(MemberDTO params) {
        MemberDTO memberVO = dao.select(params);
        if (null == memberVO || !params.getId().equals(memberVO.getId())) {
            memberVO.setMsg("NONE_ID");
        }
        else if (!params.getPw().equals(memberVO.getPw())) {
            memberVO.setMsg("NO_MATCH_PW");
        }
        else {
            memberVO.setMsg("SUCCESS");
        }

        return memberVO;
    }

    @Override
    public Retval join(MemberDTO params) {
        Retval retval = dao.insert(params);
        return retval;
    }
}
