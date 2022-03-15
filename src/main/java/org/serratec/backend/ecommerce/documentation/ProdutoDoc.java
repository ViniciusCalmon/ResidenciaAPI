package org.serratec.backend.ecommerce.documentation;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.domain.Produto;
import org.serratec.backend.ecommerce.dto.ProdutoComIdCategoriaDTO;
import org.serratec.backend.ecommerce.dto.ProdutoEstoqueDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Documentação da Entidade 'PodutoController'.")
public interface ProdutoDoc {

	@ApiOperation(value = "Lista todos os produtos", notes = "Listagem de produtos.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os produtos."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Page<Produto>> listar(Pageable pageable);

	@ApiOperation(value = "Busca um produto pelo id", notes = "Produto.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um produto."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Produto> buscarPorId(@PathVariable Long id);

	@ApiOperation(value = "Insere dados de um produto", notes = "Inserir produto.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Funcionário cadastrado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Não foi possível encontrar a categoria associada a este id"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Produto> cadastrar(@Valid @RequestBody ProdutoComIdCategoriaDTO produtoComIdCategoriaDTO);

	@ApiOperation(value = "Altera dados de um produto", notes = "Alterar produto.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto alterado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Produto> atualizar(@PathVariable Long id,
			@Valid @RequestBody ProdutoComIdCategoriaDTO produtoComIdCategoriaDTO);

	@ApiOperation(value = "Deleta dados de um produto", notes = "Deletar produto.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Produto deletado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre um exceção") })
	ResponseEntity<Void> deletar(@PathVariable Long id);

	@ApiOperation(value = "Atualiza parcialmente dados de um produto(quantidade em estoque)", notes = "Atualizar estoque.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Estoque atualizado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Não foi possível encontrar a categoria associada a este id"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Produto> atualizarEstoque(@Valid @RequestBody ProdutoEstoqueDTO produtoEstoqueDTO,
			@PathVariable Long id);
}
