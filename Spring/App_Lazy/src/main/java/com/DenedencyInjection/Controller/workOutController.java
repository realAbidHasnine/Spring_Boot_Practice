package com.DenedencyInjection.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DenedencyInjection.App.Interface.coach;

@RestController
public class workOutController {

    private coach myCoach;
    private coach keeperCoach;
    private coach bowlerCoach;
    private coach cricketCoach;

    public workOutController(@Qualifier("spinnerCoach") coach theCoach,
                             @Lazy @Qualifier("keeperCoach") coach theKeeperCoach,
                             @Qualifier("bowlerCoach") coach theBowlerCoach,
                             @Qualifier("cricketCoach") coach theCricketCoach){
        System.out.println("Constructor : "+getClass().getSimpleName());
        myCoach = theCoach;
        keeperCoach = theKeeperCoach;
        bowlerCoach = theBowlerCoach;
        cricketCoach = theCricketCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/keeper")
    public String getKeeper(){
        return keeperCoach.getDailyWorkOut();
    }

    @GetMapping("/bowler")
    public String getBowler(){
        return bowlerCoach.getDailyWorkOut();
    }

    @GetMapping("/cricket")
    public String getCricket(){
        return cricketCoach.getDailyWorkOut();
    }

    

}
