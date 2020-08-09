package com.nelioalves.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Server
public class MockEmailService extends AbstractEmailService {

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		log.info("Simulando envio de email...");
		log.info(msg.toString());
		log.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		log.info("Simulando envio de email HTML...");
		log.info(msg.toString());
		log.info("Email enviado");
	}
}