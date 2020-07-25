package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
}