package br.com.brito.operadoracartaocredito.adapters.in;

import br.com.brito.operadoracartaocredito.application.domain.ClienteDomain;

public interface ClienteService {

    ClienteDomain solicitarCartao(ClienteDomain cliente);

    ClienteDomain buscarPorCpf(String cpf);
}
