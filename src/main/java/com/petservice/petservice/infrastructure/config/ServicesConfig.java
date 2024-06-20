package com.petservice.petservice.infrastructure.config;

import com.petservice.petservice.application.adapter.in.PetService;
import com.petservice.petservice.application.port.in.AddPetUseCase;
import com.petservice.petservice.application.port.in.FindPetUseCase;
import com.petservice.petservice.application.port.out.PetRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    @Qualifier("findPetUseCase")
    public FindPetUseCase findPetUseCase(PetRepository petRepository){
        return new PetService(petRepository);
    }

    @Bean
    @Qualifier("addPetUseCase")
    public AddPetUseCase addPetUseCase(PetRepository petRepository){
        return new PetService(petRepository);
    }
}
