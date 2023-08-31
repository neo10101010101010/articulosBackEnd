package com.app.articulos.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.articulos.models.Articulos;
import com.app.articulos.respositories.ArticulosRepository;
import com.app.articulos.services.ArticulosService;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/articulos")

public class ArticulosController {
	@Autowired
	private ArticulosService articulosService;
	private ArticulosRepository repositorio;
	
	@PostMapping
	private ResponseEntity<Articulos> guardar(@RequestBody Articulos articulos)
	{
		Articulos temporal = articulosService.create(articulos);
		
		try {
			return ResponseEntity.created(new URI("/api/articulos/"+ temporal.getId())).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@GetMapping
	private ResponseEntity<List<Articulos>> listarArticulos()
	{
		return ResponseEntity.ok(articulosService.getAllArticulos());
	}


	@DeleteMapping("/{id}")
	private ResponseEntity<Void> eliminarArticulo(@PathVariable Long id) {
		try {
			articulosService.eliminarPorId(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	@PutMapping("/{id}")
	private ResponseEntity<Articulos> editarArticulo(@PathVariable Long id, @RequestBody Articulos articulos) {
		try {
			Articulos articuloEditado = articulosService.editarArticulo(id, articulos);
			return ResponseEntity.ok(articuloEditado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Articulos>> listarArticulosPorId(@PathVariable ("id") Long id)
	{
		return ResponseEntity.ok(articulosService.findById(id));
	}
}
