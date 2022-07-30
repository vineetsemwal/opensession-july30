package com.trainingapps.empms;

public class CalcyMain {
    public static void main(String args[]){
        ICalculator calcy=new SamsungCalculator();
        int result=calcy.add(1,2);
        System.out.println(result);
    }
}
