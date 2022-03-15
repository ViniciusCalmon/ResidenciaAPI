package org.serratec.backend.ecommerce.documentation;

import javax.validation.Valid;

import org.serratec.backend.ecommerce.domain.Pedido;
import org.serratec.backend.ecommerce.dto.PedidoComIdProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Documentação da Entidade 'PedidoController'.")
public interface PedidoDoc {

	@ApiOperation(value = "Lista todos os pedidos", notes = "Listagem de pedidos.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os pedidos."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Page<Pedido>> listar(Pageable pageable);

	@ApiOperation(value = "Busca um pedido pelo id", notes = "Pedido.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Pedido> buscarPorId(@PathVariable Long id);

	@ApiOperation(value = "Insere dados de um pedido", notes = "Inserir pedido.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Pedido cadastrado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Pedido> cadastrar(@Valid @RequestBody PedidoComIdProdutoDTO pedidoComIdProdutoDTO);

	@ApiOperation(value = "Altera dados de um pedido", notes = "Alterar pedido.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido alterado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 500, message = "Quando ocorre uma exceção") })
	ResponseEntity<Pedido> atualizar(@PathVariable Long id,
			@Valid @RequestBody PedidoComIdProdutoDTO pedidoComIdProdutoDTO);

	@ApiOperation(value = "Deleta dados de um pedido", notes = "Deletar pedido.")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Pedido deletado."),
			@ApiResponse(code = 400, message = "Dados inválidos."),
			@ApiResponse(code = 401, message = "Erro de autenticação."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso."),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Quando ocorre um exceção") })
	ResponseEntity<Void> deletar(@PathVariable Long id);
}
