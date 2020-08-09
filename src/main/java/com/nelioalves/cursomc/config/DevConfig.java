
package com.nelioalves.cursomc.config;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import com.nelioalves.cursomc.services.DBService;
import com.nelioalves.cursomc.services.EmailService;
import com.nelioalves.cursomc.services.SmtpEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;
    @Autowired
    private DBService dbService;

    @PostConstruct
    public void instantiateDatabase() throws ParseException {
        if (!"create".equals(strategy)) {
            dbService.instantiateTestDatabase();
        }
    }

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}