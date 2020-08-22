package com.nelioalves.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.nelioalves.cursomc.dto.CidadeDTO;
import com.nelioalves.cursomc.dto.EstadoDTO;
import com.nelioalves.cursomc.services.CidadeService;
import com.nelioalves.cursomc.services.EstadoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/estados")
public class EstadoResource {

    private EstadoService service;
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll() {
        var estados = service.findAll();
        var estadoDTOs = estados.stream().map(EstadoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(estadoDTOs);
    }

    @GetMapping(value = "/{estadoId}/cidades")
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
        var cidades = cidadeService.findByEstado(estadoId);
        var cidadeDTOs = cidades.stream().map(CidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(cidadeDTOs);
    }
}