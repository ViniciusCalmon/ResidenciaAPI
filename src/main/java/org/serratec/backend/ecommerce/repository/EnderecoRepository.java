package org.serratec.backend.ecommerce.repository;

import org.serratec.backend.ecommerce.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findByCepAndNumero(String cep, Integer numero);
}
