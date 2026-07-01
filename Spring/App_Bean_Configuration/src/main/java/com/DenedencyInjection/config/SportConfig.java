package com.DenedencyInjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.DenedencyInjection.Class.coach;
import com.DenedencyInjection.Class.SwimCoach;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public coach swimCoach(){
        return new SwimCoach();
    }
}
