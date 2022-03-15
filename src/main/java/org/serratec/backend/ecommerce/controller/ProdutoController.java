package org.serratec.backend.ecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.documentation.ProdutoDoc;
import org.serratec.backend.ecommerce.domain.Produto;
import org.serratec.backend.ecommerce.dto.ProdutoComIdCategoriaDTO;
import org.serratec.backend.ecommerce.dto.ProdutoEstoqueDTO;
import org.serratec.backend.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController implements ProdutoDoc {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<Page<Produto>> listar(Pageable pageable) {
		return ResponseEntity.ok(produtoService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		return produtoService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Produto> cadastrar(@Valid @RequestBody ProdutoComIdCategoriaDTO produtoComIdCategoriaDTO) {
		return produtoService.save(produtoComIdCategoriaDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id,
			@Valid @RequestBody ProdutoComIdCategoriaDTO produtoComIdCategoriaDTO) {
		return produtoService.update(id, produtoComIdCategoriaDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return produtoService.deleteById(id);
	}

	@PatchMapping("/atualiza-estoque/{id}")
	public ResponseEntity<Produto> atualizarEstoque(@Valid @RequestBody ProdutoEstoqueDTO produtoEstoqueDTO,
			@PathVariable Long id) {

		return produtoService.upEstoque(id, produtoEstoqueDTO);
	}

	@PatchMapping("/decrementa-estoque/{id}")
	public ResponseEntity<Produto> decrementarEstoque(@Valid @RequestBody ProdutoEstoqueDTO produtoEstoqueDTO,
			@PathVariable Long id) {

		return produtoService.downEstoque(id, produtoEstoqueDTO);
	}
}
