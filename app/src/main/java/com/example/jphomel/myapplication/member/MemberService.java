package com.example.jphomel.myapplication.member;

import com.example.jphomel.myapplication.util.Retval;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public interface MemberService {
    public MemberDTO login(MemberDTO memberVO);
    public Retval join(MemberDTO memberVO);
}
