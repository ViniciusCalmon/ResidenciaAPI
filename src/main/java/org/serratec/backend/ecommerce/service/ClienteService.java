package org.serratec.backend.ecommerce.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.serratec.backend.ecommerce.configuration.MailConfig;
import org.serratec.backend.ecommerce.domain.Cliente;
import org.serratec.backend.ecommerce.domain.Endereco;
import org.serratec.backend.ecommerce.dto.ClienteComIdEnderecoDTO;
import org.serratec.backend.ecommerce.dto.ClienteSemSenhaDTO;
import org.serratec.backend.ecommerce.repository.ClienteRepository;
import org.serratec.backend.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private MailConfig mailConfig;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EnderecoRepository enderecoRespository;

	public Page<ClienteSemSenhaDTO> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable).map(cliente -> new ClienteSemSenhaDTO(cliente));
	}

	public ResponseEntity<ClienteSemSenhaDTO> findById(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isPresent()) {
			return ResponseEntity.ok(new ClienteSemSenhaDTO(clienteOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Cliente> save(ClienteComIdEnderecoDTO clienteComIdEnderecoDTO) {
		if (null != clienteComIdEnderecoDTO.getIdEndereco()) {

			Optional<Endereco> enderecoOptional = enderecoRespository.findById(clienteComIdEnderecoDTO.getIdEndereco());

			if (enderecoOptional.isPresent()) {
				Cliente cliente = modelMapper.map(clienteComIdEnderecoDTO, Cliente.class);

				cliente.setEndereco(enderecoOptional.get());

				mailConfig.sendEmail(cliente.getEmail(),
						"Olá! Seu cadasro foi efetuado com sucesso! \nConfira seus dados: ", cliente.toString());

				if (null != clienteComIdEnderecoDTO.getSenha()) {
					PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

					cliente.setSenha(passwordEncoder.encode(clienteComIdEnderecoDTO.getSenha()));
				}
				return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
			}
		}
		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<Cliente> update(Long id, ClienteComIdEnderecoDTO clienteComIdEnderecoDTO) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isPresent()) {
			if (null != clienteComIdEnderecoDTO.getEmail())
				clienteOptional.get().setEmail(clienteComIdEnderecoDTO.getEmail());
			if (null != clienteComIdEnderecoDTO.getNomeUsuario())
				clienteOptional.get().setNomeUsuario(clienteComIdEnderecoDTO.getNomeUsuario());
			if (null != clienteComIdEnderecoDTO.getNomeCompleto())
				clienteOptional.get().setNomeCompleto(clienteComIdEnderecoDTO.getNomeCompleto());
			if (null != clienteComIdEnderecoDTO.getSenha()) {
				PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

				clienteOptional.get().setSenha(passwordEncoder.encode(clienteComIdEnderecoDTO.getSenha()));
			}
			if (null != clienteComIdEnderecoDTO.getCpf())
				clienteOptional.get().setCpf(clienteComIdEnderecoDTO.getCpf());
			if (null != clienteComIdEnderecoDTO.getTelefone())
				clienteOptional.get().setTelefone(clienteComIdEnderecoDTO.getTelefone());
			if (null != clienteComIdEnderecoDTO.getDataNasc())
				clienteOptional.get().setDataNasc(clienteComIdEnderecoDTO.getDataNasc());
			if (null != clienteComIdEnderecoDTO.getIdEndereco()) {

				Optional<Endereco> enderecoOptional = enderecoRespository
						.findById(clienteComIdEnderecoDTO.getIdEndereco());

				if (enderecoOptional.isPresent()) {
					clienteOptional.get().setEndereco(enderecoOptional.get());
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.ok(clienteRepository.save(clienteOptional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<Void> deleteById(Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
