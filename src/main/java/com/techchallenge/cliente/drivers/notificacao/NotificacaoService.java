package com.techchallenge.cliente.drivers.notificacao;

public interface NotificacaoService<T> {

	void enviar(T value);
}
