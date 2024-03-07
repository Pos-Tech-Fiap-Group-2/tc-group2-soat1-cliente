package com.techchallenge.cliente.core.template.impl.log;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.techchallenge.cliente.core.domain.entities.mensagens.Mensagem;
import com.techchallenge.cliente.core.template.TemplateBase;


@Component
public class TemplateLog extends TemplateBase<Mensagem> {

	@Override
	protected String getBasePath() {
		return "/templates/log";
	}

	@Override
	protected Map<String, Object> getVariaveis(Mensagem mensagem) {
		Map<String, Object> map = new HashMap<>();
		map.put("mensagem", mensagem);
				
		return map;
	}

	@Override
	protected String getFileName(Mensagem mensagem) {
		return mensagem.getTemplate() + ".txt";
	}
}
