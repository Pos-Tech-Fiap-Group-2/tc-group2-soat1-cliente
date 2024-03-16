package com.techchallenge.cliente.drivers.notificacao.impl.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techchallenge.cliente.core.domain.entities.mensagens.Mensagem;
import com.techchallenge.cliente.core.template.impl.log.TemplateLog;
import com.techchallenge.cliente.drivers.notificacao.NotificacaoBaseService;

@Component
public class NotificacaoLogService extends NotificacaoBaseService<Mensagem, String> {

	@Autowired
	private TemplateLog processador;
	
	private Logger logger = LoggerFactory.getLogger(NotificacaoLogService.class);
	
	@Override
	protected void enviarNotificacao(String value) {
		logger.info(String.format("Notificação cliente: %s", new Object[] {value}));
	}

	@Override
	protected String template(Mensagem value) {
		return processador.processarTemplate(value);
	}
}
