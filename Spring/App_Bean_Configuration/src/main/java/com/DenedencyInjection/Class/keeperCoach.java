package com.DenedencyInjection.Class;

import org.springframework.stereotype.Component;

@Component
public class keeperCoach implements coach {

    public keeperCoach(){
        System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice Catching and Stumping Drills";
    }
}
