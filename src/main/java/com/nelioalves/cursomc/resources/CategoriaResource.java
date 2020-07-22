package com.nelioalves.cursomc.resources;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/categorias")
public class CategoriaResource {
  private CategoriaService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Categoria> find(@PathVariable Integer id) {
    return ResponseEntity.ok().body(service.find(id));
  }
}