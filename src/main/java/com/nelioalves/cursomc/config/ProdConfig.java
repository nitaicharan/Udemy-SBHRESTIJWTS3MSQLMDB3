
package com.nelioalves.cursomc.config;

import com.nelioalves.cursomc.services.EmailService;
import com.nelioalves.cursomc.services.SmtpEmailService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}