package com.example.jphomel.myapplication.member;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public interface MemberService {
    public MemberDTO login(MemberDTO memberVO);
    public MemberDTO join(MemberDTO memberVO);
}
