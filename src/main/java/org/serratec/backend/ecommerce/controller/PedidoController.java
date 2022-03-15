package org.serratec.backend.ecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.documentation.PedidoDoc;
import org.serratec.backend.ecommerce.domain.Pedido;
import org.serratec.backend.ecommerce.dto.PedidoComIdProdutoDTO;
import org.serratec.backend.ecommerce.service.PedidoService;
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
@RequestMapping("/api/v1/pedidos")
public class PedidoController implements PedidoDoc {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<Page<Pedido>> listar(Pageable pageable) {
		return ResponseEntity.ok(pedidoService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
		return pedidoService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Pedido> cadastrar(@Valid @RequestBody PedidoComIdProdutoDTO pedidoComIdProdutoDTO) {
		return pedidoService.save(pedidoComIdProdutoDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id,
			@Valid @RequestBody PedidoComIdProdutoDTO pedidoComIdProdutoDTO) {
		return pedidoService.update(id, pedidoComIdProdutoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return pedidoService.deleteById(id);
	}

}
