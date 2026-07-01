package com.DenedencyInjection.Class;


import org.springframework.stereotype.Component;
import com.DenedencyInjection.App.Interface.coach;


@Component
public class spinnerCoach implements coach {


    public spinnerCoach(){
        System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice Spin Bowling and Flight";
    }

}
