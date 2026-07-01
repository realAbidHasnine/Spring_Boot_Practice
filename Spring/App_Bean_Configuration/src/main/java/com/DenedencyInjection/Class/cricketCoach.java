package com.DenedencyInjection.Class;

import org.springframework.stereotype.Component;

@Component
public class cricketCoach implements coach {

    public cricketCoach(){
        System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Work on Upper Body";
    }
}
