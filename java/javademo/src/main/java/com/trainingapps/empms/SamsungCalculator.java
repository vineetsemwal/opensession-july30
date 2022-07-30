package com.trainingapps.empms;

public class SamsungCalculator implements ICalculator{

    @Override
    public int add(int num1, int num2){
        int result=sum(num1,num2);
        return result ;
    }

    public int sum(int num1, int num2){
        return num1+num2;
    }
}
