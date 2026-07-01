package com.DenedencyInjection.Class;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.DenedencyInjection.App.Interface.coach;

@Primary
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
