package com.lashan.mycrud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}