package com.DenedencyInjection.Class;

import org.springframework.stereotype.Component;
import com.DenedencyInjection.App.Interface.coach;

@Component//this make a Spring Bean and makes it available for DI
public class cricketCoach implements coach {

    public cricketCoach(){
        System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Work on Upper Body";
    }

}
