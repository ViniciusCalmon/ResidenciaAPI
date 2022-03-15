package org.serratec.backend.ecommerce.service;

import java.net.URI;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.serratec.backend.ecommerce.domain.Endereco;
import org.serratec.backend.ecommerce.dto.EnderecoCepNumeroDTO;
import org.serratec.backend.ecommerce.dto.EnderecoNumeroDTO;
import org.serratec.backend.ecommerce.repository.EnderecoRepository;
import org.serratec.backend.ecommerce.util.EnderecoViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<Endereco> findAll(Pageable pageable) {
		return enderecoRepository.findAll(pageable);
	}

	public ResponseEntity<Endereco> findById(Long id) {
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);

		if (enderecoOptional.isPresent()) {
			return ResponseEntity.ok(enderecoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Endereco> save(EnderecoCepNumeroDTO enderecoCepNumeroDTO) {
		Optional<Endereco> enderecoCepNumeroDTOOptional = Optional.ofNullable(
				enderecoRepository.findByCepAndNumero(enderecoCepNumeroDTO.getCep(), enderecoCepNumeroDTO.getNumero()));

		if (enderecoCepNumeroDTOOptional.isPresent()) {
			return ResponseEntity.ok(enderecoCepNumeroDTOOptional.get());
		}

		try {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + enderecoCepNumeroDTO.getCep() + "/json/";

			Optional<EnderecoViaCep> enderecoViaCepDTOOptional = Optional
					.ofNullable(restTemplate.getForObject(uri, EnderecoViaCep.class));

			if (enderecoViaCepDTOOptional.isPresent()) {
				if (enderecoViaCepDTOOptional.get().getCep() != null) {

					Endereco endereco = modelMapper.map(enderecoViaCepDTOOptional.get(), Endereco.class);

					endereco.setNumero(enderecoCepNumeroDTO.getNumero());
					endereco.setComplemento(enderecoCepNumeroDTO.getComplemento());

					URI uriEndereco = ServletUriComponentsBuilder.fromCurrentRequestUri()
							.buildAndExpand(endereco.getCep()).toUri();

					return ResponseEntity.created(uriEndereco).body(enderecoRepository.save(endereco));
				}
			}
			return ResponseEntity.notFound().build();

		} catch (HttpClientErrorException exception) {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Endereco> update(Long id, EnderecoNumeroDTO enderecoNumeroComplementoDTO) {
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);

		if (enderecoOptional.isPresent()) {
			Endereco endereco = enderecoOptional.get();

			if (null != enderecoNumeroComplementoDTO.getComplemento()) {
				endereco.setNumero(enderecoNumeroComplementoDTO.getNumero());
			}
			if (null != enderecoNumeroComplementoDTO.getComplemento()) {
				endereco.setComplemento(enderecoNumeroComplementoDTO.getComplemento());
			}

			return ResponseEntity.ok(enderecoRepository.save(endereco));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Void> deleteById(Long id) {
		if (!enderecoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		enderecoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
