package br.com.brito.operadoracartaocredito.adapters.out.repositories;

import br.com.brito.operadoracartaocredito.adapters.out.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long> {

    Boolean existsByEmail(String email);

    Optional<ClienteEntity> findByCpf(String cpf);
}
