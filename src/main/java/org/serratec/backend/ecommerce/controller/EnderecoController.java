package org.serratec.backend.ecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.documentation.EnderecoDoc;
import org.serratec.backend.ecommerce.domain.Endereco;
import org.serratec.backend.ecommerce.dto.EnderecoCepNumeroDTO;
import org.serratec.backend.ecommerce.dto.EnderecoNumeroDTO;
import org.serratec.backend.ecommerce.service.EnderecoService;
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
@RequestMapping("/api/v1/enderecos")
public class EnderecoController implements EnderecoDoc {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<Page<Endereco>> listar(Pageable pageable) {
		return ResponseEntity.ok(enderecoService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
		return enderecoService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Endereco> buscarPeloCep(@Valid @RequestBody EnderecoCepNumeroDTO enderecoCepNumeroDTO) {
		return enderecoService.save(enderecoCepNumeroDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id,
			@Valid @RequestBody EnderecoNumeroDTO enderecoNumeroComplementoDTO) {
		return enderecoService.update(id, enderecoNumeroComplementoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return enderecoService.deleteById(id);
	}

}
