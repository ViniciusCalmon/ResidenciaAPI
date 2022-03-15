package org.serratec.backend.ecommerce.documentation;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.domain.Cliente;
import org.serratec.backend.ecommerce.dto.ClienteComIdEnderecoDTO;
import org.serratec.backend.ecommerce.dto.ClienteSemSenhaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Documentação da Entidade 'ClienteController'.")
public interface ClienteDoc {

	@ApiOperation(value = "Lista todos os clientes", notes = "Listagem de clientes.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Page<ClienteSemSenhaDTO>> listar(Pageable pageable);

	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um cliente pelo id", notes = "Cliente.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um cliente."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<ClienteSemSenhaDTO> buscarPorId(@PathVariable Long id);

	@ApiOperation(value = "Insere dados de um cliente", notes = "Inserir cliente.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente cadastrado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Cliente> cadastrar(@Valid @RequestBody ClienteComIdEnderecoDTO clienteComIdEnderecoDTO);

	@ApiOperation(value = "Altera dados de um cliente", notes = "Alterar cliente.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente alterado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Cliente> atualizar(@PathVariable Long id,
			@Valid @RequestBody ClienteComIdEnderecoDTO clienteComIdEnderecoDTO);

	@ApiOperation(value = "Deleta dados de um cliente", notes = "Deletar cliente.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Cliente deletado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre um exceção") })
	ResponseEntity<Void> deletar(@PathVariable Long id);
}
