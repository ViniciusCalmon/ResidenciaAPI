package org.serratec.backend.ecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.documentation.CategoriaDoc;
import org.serratec.backend.ecommerce.domain.Categoria;
import org.serratec.backend.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController implements CategoriaDoc {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<Page<Categoria>> listar(Pageable pageable) {
		return ResponseEntity.ok(categoriaService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		return categoriaService.findById(id);
	}

	@PostMapping
	public Categoria cadastrar(@Valid @RequestBody Categoria categoriaConsulta) {
		return categoriaService.save(categoriaConsulta);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoriaConsulta) {
		return categoriaService.update(id, categoriaConsulta);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return categoriaService.deleteById(id);
	}

}
