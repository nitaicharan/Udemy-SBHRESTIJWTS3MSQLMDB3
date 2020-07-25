package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

	private ProdutoRepository repository;
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Pageable pageable) {
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageable);
	}
}