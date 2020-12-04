package com.nelioalves.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.dto.CategoriaDTO;
import com.nelioalves.cursomc.services.CategoriaService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/categorias")
public class CategoriaResource {
  private CategoriaService service;

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Busca por id")
  public ResponseEntity<Categoria> find(@PathVariable Integer id) {
    Categoria obj = service.find(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  @PreAuthorize("hasAnyRole('ADMIN')")
  @ApiOperation(value = "Insere categoria")
  public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO dto) {
    var obj = service.insert(dto.toEntity());
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  @ApiOperation(value = "Atualiza categoria")
  public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO dto, @PathVariable Integer id) {
    dto.setId(id);
    service.update(dto.toEntity());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  @ApiOperation(value = "Remove categoria")
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
      @ApiResponse(code = 404, message = "Código inexistente") })
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  @ApiOperation(value = "Retorna todas categorias")
  public ResponseEntity<List<CategoriaDTO>> findAll() {
    List<Categoria> list = service.findAll();
    List<CategoriaDTO> listDto = list.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping("/page")
  @ApiOperation(value = "Retorna todas categorias com paginação")
  public ResponseEntity<Page<CategoriaDTO>> findPage(@SortDefault(sort = "nome") Pageable pageable) {
    Page<Categoria> list = service.findPage(pageable);
    Page<CategoriaDTO> listDto = list.map(CategoriaDTO::new);
    return ResponseEntity.ok().body(listDto);
  }
}