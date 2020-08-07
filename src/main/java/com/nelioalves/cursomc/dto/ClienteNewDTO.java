package com.nelioalves.cursomc.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.services.validation.ClienteInsert;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@ClienteInsert
@NoArgsConstructor
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cpfOuCnpj;

	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;

	private String complemento;

	private String bairro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;

	private String telefone2;
	
	private String telefone3;

	private Integer cidadeId;

	public Cliente toCliente() {
		return Cliente.builder().nome(nome).email(email).cpfOuCnpj(cpfOuCnpj).tipo(TipoCliente.toEnum(tipo).getCod()).senha(senha).build();
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