package org.serratec.backend.ecommerce.documentation;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.domain.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Documentação da Entidade 'CategoriaController'.")
public interface CategoriaDoc {

	@ApiOperation(value = "Lista todas as categorias", notes = "Listagem de categorias.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas as categorias."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Page<Categoria>> listar(Pageable pageable);

	@ApiOperation(value = "Busca uma categoria pelo id", notes = "Categoria.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma categoria."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Categoria> buscarPorId(@PathVariable Long id);

	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere dados de uma categoria", notes = "Inserir categoria.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Categoria cadastrada."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	Categoria cadastrar(@Valid @RequestBody Categoria categoriaConsulta);

	@ApiOperation(value = "Altera dados de uma categoria", notes = "Alterar categoria.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Categoria alterada."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoriaConsulta);

	@ApiOperation(value = "Deleta dados de uma categoria", notes = "Deletar categoria.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Categoria deletada."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Void> deletar(@PathVariable Long id);
}
