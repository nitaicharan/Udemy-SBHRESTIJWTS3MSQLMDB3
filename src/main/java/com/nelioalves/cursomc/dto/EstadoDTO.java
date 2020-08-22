package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import com.nelioalves.cursomc.domain.Estado;

import lombok.Getter;

@Getter
public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public EstadoDTO(Estado estado) {
		id = estado.getId();
		nome = estado.getNome();
	}
}