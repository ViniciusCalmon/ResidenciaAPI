package org.serratec.backend.ecommerce.documentation;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.domain.Endereco;
import org.serratec.backend.ecommerce.dto.EnderecoCepNumeroDTO;
import org.serratec.backend.ecommerce.dto.EnderecoNumeroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Documentação da Entidade 'EnderecoController'.")
public interface EnderecoDoc {

	@ApiOperation(value = "Lista todos os endereços", notes = "Listagem de endereços.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os endereços."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Page<Endereco>> listar(Pageable pageable);

	@ApiOperation(value = "Busca um endereço pelo id", notes = "Endereço.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um endereço."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Endereco> buscarPorId(@PathVariable Long id);

	@ApiOperation(value = "Insere dados de um endereço", notes = "Inserir endereço.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um endereço."),
			@ApiResponse(code = 201, message = "Endereço cadastrado."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Endereco> buscarPeloCep(@Valid @RequestBody EnderecoCepNumeroDTO enderecoCepNumeroDTO);

	@ApiOperation(value = "Altera dados de um endereço", notes = "Alterar endereço.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Endereço alterado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Endereco> atualizar(@PathVariable Long id,
			@Valid @RequestBody EnderecoNumeroDTO enderecoNumeroComplementoDTO);

	@ApiOperation(value = "Deleta dados de um endereço", notes = "Deletar endereço.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Endereço deletado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Void> deletar(@PathVariable Long id);
}
