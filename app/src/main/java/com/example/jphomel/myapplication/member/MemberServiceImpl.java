package com.example.jphomel.myapplication.member;

import android.content.Context;

import com.example.jphomel.myapplication.util.Retval;

import java.util.ArrayList;

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
    public Retval regist(MemberDTO params) {
        return dao.insert(params);
    }

    @Override
    public MemberDTO login(MemberDTO params) {
        MemberDTO memberVO = dao.selectOne(params);
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
    public ArrayList<MemberDTO> selectList() {
        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDTO> selectList(MemberDTO params) {
        return dao.selectList(params);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void update(MemberDTO params) {
        dao.update(params);
    }

    @Override
    public void unregist(MemberDTO params) {
        dao.delete(params);
    }

}
