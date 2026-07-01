package com.DenedencyInjection.Class;

import org.springframework.stereotype.Component;
import com.DenedencyInjection.App.Interface.coach;

@Component
public class bowlerCoach implements coach {

    public bowlerCoach(){
        System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice Fast Bowling and Line Length";
    }

}
