package com.example.jphomel.myapplication.member;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService {
    MemberDAO dao = new MemberDAO();

    @Override
    public MemberDTO login(MemberDTO params) {
        MemberDTO memberVO = dao.select(params);
        if (null == memberVO) {
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
    public MemberDTO join(MemberDTO params) {
        MemberDTO memberVO = new MemberDTO();
        return memberVO;
    }
}
