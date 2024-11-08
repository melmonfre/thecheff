package com.theCheff.The.Cheff.domain.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
@Builder
public class ResponseDTO<T> {

    private String mensagem;
    private T data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Builder.Default
    private LocalDateTime dataHora = LocalDateTime.now();

    public ResponseDTO(String mensagem, T data) {
        this.mensagem = mensagem;
        this.data = data;
        this.dataHora = LocalDateTime.now();
    }

	public ResponseDTO(String mensagem, T data, LocalDateTime dataHora) {
		super();
		this.mensagem = mensagem;
		this.data = data;
		this.dataHora = dataHora;
	}
	
	
	public ResponseDTO() {
		super();
		this.mensagem = mensagem;
		this.data = data;
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
    
    

}
