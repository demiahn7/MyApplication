package com.example.jphomel.myapplication.calc;

/**
 * Created by jpHomeL on 2016-09-24.
 */

public class CalcServiceImpl implements CalcService {

    @Override
    public CalcDTO plus(CalcDTO vo) {
        vo.setResult(vo.getNum1() + vo.getNum2());
        return vo;
    }

    @Override
    public CalcDTO minus(CalcDTO vo) {
        vo.setResult(vo.getNum1() - vo.getNum2());
        return vo;
    }

    @Override
    public CalcDTO multi(CalcDTO vo) {
        vo.setResult(vo.getNum1() * vo.getNum2());
        return vo;
    }

    @Override
    public CalcDTO divide(CalcDTO vo) {
        vo.setResult(vo.getNum1() / vo.getNum2());
        return vo;
    }

    @Override
    public CalcDTO remainder(CalcDTO vo) {
        vo.setResult(vo.getNum1() % vo.getNum2());
        return vo;
    }
}
