package org.serratec.backend.ecommerce.service;

import java.util.Optional;

import org.serratec.backend.ecommerce.domain.Categoria;
import org.serratec.backend.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Page<Categoria> findAll(Pageable pageable) {
		return categoriaRepository.findAll(pageable);
	}

	public ResponseEntity<Categoria> findById(Long id) {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

		if (categoriaOptional.isPresent()) {
			return ResponseEntity.ok(categoriaOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	public Categoria save(Categoria categoriaConsulta) {
		return categoriaRepository.save(categoriaConsulta);
	}

	public ResponseEntity<Categoria> update(Long id, Categoria categoria) {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

		if (categoriaOptional.isPresent()) {

			if (null != categoria.getNome()) {
				categoriaOptional.get().setNome(categoria.getNome());
			}
			if (null != categoria.getDescricao()) {
				categoriaOptional.get().setDescricao(categoria.getDescricao());
			}
			return ResponseEntity.ok(categoriaRepository.save(categoriaOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Void> deleteById(Long id) {
		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categoriaRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
