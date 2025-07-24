package br.com.brito.operadoracartaocredito.adapters.out;

import br.com.brito.operadoracartaocredito.adapters.mapper.ClienteMapper;
import br.com.brito.operadoracartaocredito.adapters.out.repositories.ClienteJpaRepository;
import br.com.brito.operadoracartaocredito.application.domain.ClienteDomain;
import br.com.brito.operadoracartaocredito.porters.out.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDomain salvar(ClienteDomain clienteDomain) {
        return clienteMapper.paraDomain(clienteJpaRepository.save(clienteMapper.paraEntity(clienteDomain)));
    }

    @Override
    public Boolean buscarUsuarioPorEmail(String email) {
        return clienteJpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<ClienteDomain> buscarUsuarioPorCPF(String cpf) {
        return clienteJpaRepository.findByCpf(cpf).map(clienteMapper::paraDomain);
    }
}
