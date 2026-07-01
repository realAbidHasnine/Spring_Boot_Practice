package com.DenedencyInjection.Class;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.DenedencyInjection.App.Interface.coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Primary
@Component
public class spinnerCoach implements coach {

    public spinnerCoach(){
        //System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @PostConstruct
    public void startUpStuff(){
        System.out.println("In doStartUpStuff : "+getClass().getSimpleName());
    }

    @PreDestroy
    public void breakUpStuff(){
        System.out.println("In doBreakUpStuff : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice Spin Bowling and Flight";
    }
}
