package org.serratec.backend.ecommerce.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.serratec.backend.ecommerce.domain.Categoria;
import org.serratec.backend.ecommerce.domain.Produto;
import org.serratec.backend.ecommerce.dto.ProdutoComIdCategoriaDTO;
import org.serratec.backend.ecommerce.dto.ProdutoEstoqueDTO;
import org.serratec.backend.ecommerce.repository.CategoriaRepository;
import org.serratec.backend.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<Produto> findAll(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}

	public ResponseEntity<Produto> findById(Long id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);

		if (produtoOptional.isPresent()) {
			return ResponseEntity.ok(produtoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Produto> save(ProdutoComIdCategoriaDTO produtoComIdCategoriaDTO) {
		if (null != produtoComIdCategoriaDTO.getIdCategoria()) {

			Optional<Categoria> categoriaOptional = categoriaRepository
					.findById(produtoComIdCategoriaDTO.getIdCategoria());

			if (categoriaOptional.isPresent()) {
				Produto produto = modelMapper.map(produtoComIdCategoriaDTO, Produto.class);
				produto.setCategoria(categoriaOptional.get());

				return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
			}
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Produto> update(Long id, ProdutoComIdCategoriaDTO produtoComIdCategoriaDTO) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);

		if (produtoOptional.isPresent()) {
			if (null != produtoComIdCategoriaDTO.getNome())
				produtoOptional.get().setNome(produtoComIdCategoriaDTO.getNome());
			if (null != produtoComIdCategoriaDTO.getDescricao())
				produtoOptional.get().setDescricao(produtoComIdCategoriaDTO.getDescricao());
			if (null != produtoComIdCategoriaDTO.getQtdEstoque())
				produtoOptional.get().setQtdEstoque(produtoComIdCategoriaDTO.getQtdEstoque());
			if (null != produtoComIdCategoriaDTO.getDataDadastro())
				produtoOptional.get().setDataDadastro(produtoComIdCategoriaDTO.getDataDadastro());
			if (null != produtoComIdCategoriaDTO.getValorUnitario())
				produtoOptional.get().setValorUnitario(produtoComIdCategoriaDTO.getValorUnitario());
			if (null != produtoComIdCategoriaDTO.getIdCategoria()) {

				Optional<Categoria> categoria = categoriaRepository.findById(produtoComIdCategoriaDTO.getIdCategoria());

				if (categoria.isPresent()) {
					produtoOptional.get().setCategoria(categoria.get());
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.ok(produtoRepository.save(produtoOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Void> deleteById(Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Produto> upEstoque(Long id, ProdutoEstoqueDTO produtoEstoqueDTO) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if (produtoOptional.isPresent()) {

			Integer qtd1 = produtoOptional.get().getQtdEstoque();
			Integer qtd2 = produtoEstoqueDTO.getQtdComprada();
			produtoOptional.get().setQtdEstoque(qtd1 + qtd2);

			return ResponseEntity.ok(produtoRepository.save(produtoOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Produto> downEstoque(Long id, ProdutoEstoqueDTO produtoEstoqueDTO) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if (produtoOptional.isPresent()) {

			Integer qtd1 = produtoOptional.get().getQtdEstoque();
			Integer qtd2 = produtoEstoqueDTO.getQtdComprada();
			produtoOptional.get().setQtdEstoque(qtd1 - qtd2);

			return ResponseEntity.ok(produtoRepository.save(produtoOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
