package com.techchallenge.cliente.adapter.mapper;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.techchallenge.cliente.core.domain.entities.mensagens.Mensagem;

@Component
public class MensagemLogMapper {

	public Mensagem toModel(String content) {
		Gson gson = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, 
				(JsonDeserializer<OffsetDateTime>) (json, type, context) -> OffsetDateTime.parse(json.getAsString()))
				.create();
		
		return gson.fromJson(content, Mensagem.class);
	}
}
