package com.nelioalves.cursomc.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.enums.TipoCliente;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	private String senha;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private Integer cidadeId;

	public Cliente toCliente() {
		return Cliente.builder().nome(nome).email(email).cpfOuCnpj(cpfOuCnpj).tipo(TipoCliente.toEnum(tipo)).build();
	}

	public Set<String> toTelefones() {
		return Arrays.asList(telefone1, telefone2, telefone3).stream()
				.filter(telefone -> telefone != null ? true : false).collect(Collectors.toSet());
	}

	public Endereco toEndereco() {
		return Endereco.builder().logradouro(logradouro).numero(numero).complemento(complemento).bairro(bairro).cep(cep)
				.build();
	}

	public Cidade toClidade() {
		return Cidade.builder().id(cidadeId).build();
	}

	public Cliente toEntity() {
		Cidade cidade = toClidade();
		Cliente cliente = toCliente();
		Endereco endereco = toEndereco();
		Set<String> telefones = toTelefones();

		endereco.setCidade(cidade);
		endereco.setCliente(cliente);

		cliente.setTelefones(telefones);
		cliente.setEnderecos(Arrays.asList(endereco));

		return cliente;
	}
}