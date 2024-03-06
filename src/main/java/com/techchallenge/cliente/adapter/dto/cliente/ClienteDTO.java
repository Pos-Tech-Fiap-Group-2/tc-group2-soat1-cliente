package com.techchallenge.cliente.adapter.dto.cliente;

public class ClienteDTO {

    private String nome;

    private String email;

    private ClienteDocumentoDTO documento;

    public void PayerDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteDocumentoDTO getDocumento() {
        return documento;
    }

    public void setDocumento(ClienteDocumentoDTO documento) {
        this.documento = documento;
    }
}