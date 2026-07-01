package com.DenedencyInjection.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DenedencyInjection.App.Interface.coach;


@RestController
public class DemoController {
    
    private final coach myCoach;
    private final coach anotherCoach;


    @Autowired
    public DemoController(
        @Qualifier("spinnerCoach") coach theCoach,
        @Qualifier("spinnerCoach") coach theAnotherCoach
    ) {
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/check-singleton")
    public String checkSingleton() {
        return "Coach same instance? " + (myCoach == anotherCoach);
    }
}
