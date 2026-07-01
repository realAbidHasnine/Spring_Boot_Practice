package com.DenedencyInjection.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DenedencyInjection.App.Interface.coach;

@RestController
public class DemoController {

    private final coach myCoach;

    public DemoController(
            @Qualifier("spinnerCoach") coach theCoach
    ) {
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut() {
        return myCoach.getDailyWorkOut();
    }    
}
