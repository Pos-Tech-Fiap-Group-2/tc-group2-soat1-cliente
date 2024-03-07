package com.techchallenge.cliente.adapter.driver.messaging.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoClienteConsumer {


    @JmsListener(destination = "NOTIFICACAO_CLIENTE")
    public void orderValidator(String message) {
    	System.out.println("Message received: " + message);
    }
}
