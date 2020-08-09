
package com.nelioalves.cursomc.config;

import com.nelioalves.cursomc.services.EmailService;
import com.nelioalves.cursomc.services.SmtpEmailService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("heroku")
public class HerokuConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}