package org.serratec.backend.ecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.documentation.ClienteDoc;
import org.serratec.backend.ecommerce.domain.Cliente;
import org.serratec.backend.ecommerce.dto.ClienteComIdEnderecoDTO;
import org.serratec.backend.ecommerce.dto.ClienteSemSenhaDTO;
import org.serratec.backend.ecommerce.service.ClienteService;
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
@RequestMapping("/api/v1/clientes")
public class ClienteController implements ClienteDoc {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Page<ClienteSemSenhaDTO>> listar(Pageable pageable) {
		return ResponseEntity.ok(clienteService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteSemSenhaDTO> buscarPorId(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody ClienteComIdEnderecoDTO clienteComIdEnderecoDTO) {
		return clienteService.save(clienteComIdEnderecoDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id,
			@Valid @RequestBody ClienteComIdEnderecoDTO clienteComIdEnderecoDTO) {
		return clienteService.update(id, clienteComIdEnderecoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return clienteService.deleteById(id);
	}
}
