package com.techchallenge.cliente.core.domain.entities.mensagens;

import java.time.OffsetDateTime;

import com.techchallenge.cliente.core.domain.entities.Cliente;

public class Mensagem {

	private Cliente cliente;
	private OffsetDateTime timestamp;
	private String template;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
