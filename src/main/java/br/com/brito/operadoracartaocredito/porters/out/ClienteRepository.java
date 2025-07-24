package br.com.brito.operadoracartaocredito.porters.out;

import br.com.brito.operadoracartaocredito.application.domain.ClienteDomain;

import java.util.Optional;

public interface ClienteRepository {

    ClienteDomain salvar(ClienteDomain clienteDomain);

    Boolean buscarUsuarioPorEmail(String email);

    Optional<ClienteDomain> buscarUsuarioPorCPF(String cpf);
}
