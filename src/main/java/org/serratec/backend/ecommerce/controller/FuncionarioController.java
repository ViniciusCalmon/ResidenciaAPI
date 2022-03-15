package org.serratec.backend.ecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.documentation.FuncionarioDoc;
import org.serratec.backend.ecommerce.domain.Funcionario;
import org.serratec.backend.ecommerce.dto.FuncionarioComIdProdutoDTO;
import org.serratec.backend.ecommerce.service.FuncionarioService;
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
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController implements FuncionarioDoc {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<Page<Funcionario>> listar(Pageable pageable) {
		return ResponseEntity.ok(funcionarioService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
		return funcionarioService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Funcionario> cadastrar(
			@Valid @RequestBody FuncionarioComIdProdutoDTO funcionarioComIdProdutoDTO) {
		return funcionarioService.save(funcionarioComIdProdutoDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,
			@Valid @RequestBody FuncionarioComIdProdutoDTO funcionarioComIdProdutoDTO) {
		return funcionarioService.update(id, funcionarioComIdProdutoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return funcionarioService.deleteById(id);
	}

}
