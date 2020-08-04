
package com.nelioalves.cursomc.config;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import com.nelioalves.cursomc.services.DBService;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TestConfig {

    private DBService dbService;

    @PostConstruct
    public void instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
    }
}