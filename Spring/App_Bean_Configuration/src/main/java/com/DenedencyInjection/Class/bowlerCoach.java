package com.DenedencyInjection.Class;

import org.springframework.stereotype.Component;

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
