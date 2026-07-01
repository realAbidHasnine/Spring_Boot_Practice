package com.DenedencyInjection.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DenedencyInjection.App.Interface.coach;

@RestController
public class workOutController {

    private coach myCoach;
    private coach bowlerCoach;
    private coach keeperCoach;

    public workOutController(
        @Qualifier("spinnerCoach") coach theCoach,
        @Qualifier("bowlerCoach") coach theBowlerCoach,
        @Qualifier("keeperCoach") coach theKeeperCoach
    ){
        myCoach = theCoach;
        bowlerCoach = theBowlerCoach;
        keeperCoach = theKeeperCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/bowler-workout")
    public String getBowlerWorkOut(){
        return bowlerCoach.getDailyWorkOut();
    }

    @GetMapping("/keeper-workout")
    public String getKeeperWorkOut(){
        return keeperCoach.getDailyWorkOut();
    }

}
