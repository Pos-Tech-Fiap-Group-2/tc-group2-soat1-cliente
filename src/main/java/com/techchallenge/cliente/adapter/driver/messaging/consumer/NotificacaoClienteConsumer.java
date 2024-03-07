package com.techchallenge.cliente.adapter.driver.messaging.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.techchallenge.cliente.adapter.mapper.MensagemLogMapper;
import com.techchallenge.cliente.core.domain.entities.mensagens.Mensagem;
import com.techchallenge.cliente.drivers.notificacao.impl.log.NotificacaoLogService;

@Component
public class NotificacaoClienteConsumer {

	@Autowired
	private NotificacaoLogService notificacaoService;
	
	@Autowired
	private MensagemLogMapper mapper;
	
    @JmsListener(destination = "${cloud.aws.queue.name}")
    public void notificar(String message) {
    	Mensagem mensagem = mapper.toModel(message);
    	
    	notificacaoService.enviar(mensagem);
    }
}
