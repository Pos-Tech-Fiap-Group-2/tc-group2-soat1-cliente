package com.techchallenge.cliente.adapter.driver.messaging.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.techchallenge.cliente.adapter.mapper.MensagemLogMapper;
import com.techchallenge.cliente.core.domain.entities.mensagens.Mensagem;
import com.techchallenge.cliente.drivers.notificacao.impl.log.NotificacaoLogService;

@Component
public class NotificacaoClienteConsumer {

	@Autowired
	private NotificacaoLogService notificacaoService;
	
	private Logger logger = LoggerFactory.getLogger(NotificacaoClienteConsumer.class);
	
	@Autowired
	private MensagemLogMapper mapper;
	
    @RabbitListener(queues = {"${queue.name.notificacao-cliente}"})
    public void receive(@Payload String message) {
    	logger.info(String.format("Mensagem recebida da fila: %s", new Object[] {message}));
    	
    	Mensagem mensagem = mapper.toModel(message);
    	notificacaoService.enviar(mensagem);
    }
}
