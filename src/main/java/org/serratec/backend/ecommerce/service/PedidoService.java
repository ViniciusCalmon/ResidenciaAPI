package org.serratec.backend.ecommerce.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.serratec.backend.ecommerce.domain.Pedido;
import org.serratec.backend.ecommerce.domain.Produto;
import org.serratec.backend.ecommerce.dto.PedidoComIdProdutoDTO;
import org.serratec.backend.ecommerce.repository.PedidoRepository;
import org.serratec.backend.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<Pedido> findAll(Pageable pageable) {
		return pedidoRepository.findAll(pageable);
	}

	public ResponseEntity<Pedido> findById(Long id) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

		if (pedidoOptional.isPresent()) {
			return ResponseEntity.ok(pedidoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Pedido> save(PedidoComIdProdutoDTO pedidoComIdProdutoDTO) {

		Pedido pedido = modelMapper.map(pedidoComIdProdutoDTO, Pedido.class);

		if (null != pedidoComIdProdutoDTO.getIdProdutos()) {
			if (!pedidoComIdProdutoDTO.getIdProdutos().isEmpty()) {

				while (pedidoComIdProdutoDTO.getIdProdutos().remove(null))
					;

				Set<Produto> produtosSet = new HashSet<>();

				for (Long idProduto : pedidoComIdProdutoDTO.getIdProdutos()) {

					Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);

					if (produtoOptional.isPresent()) {
						produtosSet.add(produtoOptional.get());
					}
				}
				List<Produto> produtos = produtosSet.stream().collect(Collectors.toList());

				pedido.setProdutos(produtos);
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
	}

	public ResponseEntity<Pedido> update(Long id, PedidoComIdProdutoDTO pedidoComIdProdutoDTO) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

		if (pedidoOptional.isPresent()) {
			if (null != pedidoComIdProdutoDTO.getDataPedido())
				pedidoOptional.get().setDataPedido(pedidoComIdProdutoDTO.getDataPedido());
			if (null != pedidoComIdProdutoDTO.getDataEntrega())
				pedidoOptional.get().setDataEntrega(pedidoComIdProdutoDTO.getDataEntrega());
			if (null != pedidoComIdProdutoDTO.getDataEnvio())
				pedidoOptional.get().setDataEnvio(pedidoComIdProdutoDTO.getDataEnvio());
			if (null != pedidoComIdProdutoDTO.getStatusNome())
				pedidoOptional.get().setStatusNome(pedidoComIdProdutoDTO.getStatusNome());
			if (null != pedidoComIdProdutoDTO.getIdProdutos()) {
				if (!pedidoComIdProdutoDTO.getIdProdutos().isEmpty()) {

					while (pedidoComIdProdutoDTO.getIdProdutos().remove(null))
						;

					Set<Produto> produtosSet = new HashSet<>();

					for (Long idProduto : pedidoComIdProdutoDTO.getIdProdutos()) {

						Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);

						if (produtoOptional.isPresent()) {
							produtosSet.add(produtoOptional.get());
						}
					}
					List<Produto> produtos = produtosSet.stream().collect(Collectors.toList());

					pedidoOptional.get().setProdutos(produtos);
				}
			}
			// return ResponseEntity.ok(pedidoRepository.save(pedidoOptional.get()));
			return ResponseEntity.ok(pedidoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Void> deleteById(Long id) {
		if (!pedidoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		pedidoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
