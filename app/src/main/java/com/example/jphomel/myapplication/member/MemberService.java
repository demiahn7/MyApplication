package com.example.jphomel.myapplication.member;

import com.example.jphomel.myapplication.util.Retval;

import java.util.ArrayList;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public interface MemberService {
    //CREATE
    public Retval regist(MemberDTO params);

    //READ
    public MemberDTO login(MemberDTO params);
    public ArrayList<MemberDTO> selectList();
    public ArrayList<MemberDTO> selectList(MemberDTO params);   //메서드 명은 같지만 파라미터가 다르므로 사용가능 --> 오버로드
    public int count();

    //UPDATE
    public void update(MemberDTO params);

    //DELETE
    public void unregist(MemberDTO params);
}
