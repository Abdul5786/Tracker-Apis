package com.assigment.tracker.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig
{

   // it will return modelmapper to convert entity to dto
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
