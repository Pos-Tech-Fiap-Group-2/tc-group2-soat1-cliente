package com.techchallenge.cliente.drivers.notificacao;

public abstract class NotificacaoBaseService<T, E> implements NotificacaoService<T> {

	protected abstract void enviarNotificacao(E value);
	
	protected abstract E template(T value);
	
	@Override
	public void enviar(T value) {
		E template = template(value);
		enviarNotificacao(template);
	}
}
