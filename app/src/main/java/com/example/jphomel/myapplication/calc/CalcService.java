package com.example.jphomel.myapplication.calc;

/**
 * Created by jpHomeL on 2016-09-24.
 */

public interface CalcService {
    public CalcDTO plus(CalcDTO vo);
    public CalcDTO minus(CalcDTO vo);
    public CalcDTO multi(CalcDTO vo);
    public CalcDTO divide(CalcDTO vo);
    public CalcDTO remainder(CalcDTO vo);
}
