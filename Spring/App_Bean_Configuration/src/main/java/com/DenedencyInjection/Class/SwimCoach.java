package com.DenedencyInjection.Class;

public class SwimCoach implements coach {

    public SwimCoach(){
        System.out.println("In constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut(){
        return "Swim like a fish";
    }
}
