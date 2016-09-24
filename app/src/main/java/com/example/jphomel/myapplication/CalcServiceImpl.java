package com.example.jphomel.myapplication;

/**
 * Created by jpHomeL on 2016-09-24.
 */

public class CalcServiceImpl implements CalcService {

    @Override
    public CalcDTO plus(CalcDTO vo) {
        int num1 = vo.getNum1();    //java에서 연산은 int, char 등 원시 선언자로 가능하다. 객체끼리 연산은 불가능하다.
        int num2 = vo.getNum2();
        int result = num1 + num2;
        vo.setResult(result);
        return vo;
    }

    @Override
    public CalcDTO minus(CalcDTO vo) {
        return null;
    }

    @Override
    public CalcDTO multi(CalcDTO vo) {
        return null;
    }

    @Override
    public CalcDTO divide(CalcDTO vo) {
        return null;
    }

    @Override
    public CalcDTO remainder(CalcDTO vo) {
        return null;
    }
}
