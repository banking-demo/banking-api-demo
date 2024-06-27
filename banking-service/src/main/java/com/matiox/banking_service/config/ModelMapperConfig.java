package com.matiox.banking_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean//Generar Objeto
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
