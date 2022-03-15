package org.serratec.backend.ecommerce.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.serratec.backend.ecommerce.domain.Funcionario;
import org.serratec.backend.ecommerce.domain.Produto;
import org.serratec.backend.ecommerce.dto.FuncionarioComIdProdutoDTO;
import org.serratec.backend.ecommerce.repository.FuncionarioRepository;
import org.serratec.backend.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Page<Funcionario> findAll(Pageable pageable) {
		return funcionarioRepository.findAll(pageable);
	}

	public ResponseEntity<Funcionario> findById(Long id) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);

		if (funcionarioOptional.isPresent()) {
			return ResponseEntity.ok(funcionarioOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Funcionario> save(FuncionarioComIdProdutoDTO funcionarioComIdProdutoDTO) {

		Funcionario funcionario = modelMapper.map(funcionarioComIdProdutoDTO, Funcionario.class);

		if (null != funcionarioComIdProdutoDTO.getIdProdutos()) {
			if (!funcionarioComIdProdutoDTO.getIdProdutos().isEmpty()) {

				while (funcionarioComIdProdutoDTO.getIdProdutos().remove(null))
					;

				Set<Produto> produtosSet = new HashSet<>();

				for (Long idProduto : funcionarioComIdProdutoDTO.getIdProdutos()) {

					Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);

					if (produtoOptional.isPresent()) {
						produtosSet.add(produtoOptional.get());
					}
				}
				List<Produto> produtos = produtosSet.stream().collect(Collectors.toList());

				funcionario.setProdutos(produtos);
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
	}

	public ResponseEntity<Funcionario> update(Long id, FuncionarioComIdProdutoDTO funcionarioComIdProdutoDTO) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);

		if (funcionarioOptional.isPresent()) {

			if (null != funcionarioComIdProdutoDTO.getNome())
				funcionarioOptional.get().setNome(funcionarioComIdProdutoDTO.getNome());
			if (null != funcionarioComIdProdutoDTO.getCpf())
				funcionarioOptional.get().setCpf(funcionarioComIdProdutoDTO.getCpf());
			if (null != funcionarioComIdProdutoDTO.getIdProdutos()) {
				if (!funcionarioComIdProdutoDTO.getIdProdutos().isEmpty()) {

					while (funcionarioComIdProdutoDTO.getIdProdutos().remove(null))
						;

					Set<Produto> produtosSet = new HashSet<>();

					for (Long idProduto : funcionarioComIdProdutoDTO.getIdProdutos()) {

						Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);

						if (produtoOptional.isPresent()) {
							produtosSet.add(produtoOptional.get());
						}
					}
					List<Produto> produtos = produtosSet.stream().collect(Collectors.toList());

					funcionarioOptional.get().setProdutos(produtos);
				}
			}
			return ResponseEntity.ok(funcionarioRepository.save(funcionarioOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Void> deleteById(Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
