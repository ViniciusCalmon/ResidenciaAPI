package org.serratec.backend.ecommerce.documentation;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.domain.Funcionario;
import org.serratec.backend.ecommerce.dto.FuncionarioComIdProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Documentação da Entidade 'FuncionarioController'.")
public interface FuncionarioDoc {

	@ApiOperation(value = "Lista todos os funcionários", notes = "Listagem de funcionários.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os funcionários."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Page<Funcionario>> listar(Pageable pageable);

	@ApiOperation(value = "Busca um funcionário pelo id", notes = "Funcionário.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um funcionário."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id);

	@ApiOperation(value = "Insere dados de um funcionário", notes = "Inserir funcionário.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Funcionário cadastrado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Funcionario> cadastrar(@Valid @RequestBody FuncionarioComIdProdutoDTO funcionarioComIdProdutoDTO);

	@ApiOperation(value = "Altera dados de um funcionário", notes = "Alterar funcionário.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Funcionário alterado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Funcionario> atualizar(@PathVariable Long id,
			@Valid @RequestBody FuncionarioComIdProdutoDTO funcionarioComIdProdutoDTO);

	@ApiOperation(value = "Deleta dados de um funcionário", notes = "Deletar funcionário.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Funcionário deletado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre um exceção") })
	ResponseEntity<Void> deletar(@PathVariable Long id);
}
