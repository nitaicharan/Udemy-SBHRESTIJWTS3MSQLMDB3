
package com.nelioalves.cursomc.config;

import java.text.ParseException;

import javax.swing.Spring;

import com.nelioalves.cursomc.services.DBService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;

@Configuration
@Profile("dev")
@AllArgsConstructor
public class DevConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private Spring strategy;

    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        if(!strategy.equals("create")) return false;

        dbService.instantiateTestDatabase();
        return true;
    }
}