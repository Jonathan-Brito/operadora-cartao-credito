package br.com.brito.operadoracartaocredito.application.services;

import br.com.brito.operadoracartaocredito.adapters.in.ClienteService;
import br.com.brito.operadoracartaocredito.application.domain.CartaoDomain;
import br.com.brito.operadoracartaocredito.application.domain.ClienteDomain;
import br.com.brito.operadoracartaocredito.porters.out.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final GeraDadosCartaoService geraCartao;

    public ClienteServiceImpl(ClienteRepository clienteRepository, GeraDadosCartaoService geraCartao) {
        this.clienteRepository = clienteRepository;
        this.geraCartao = geraCartao;
    }

    @Override
    public ClienteDomain solicitarCartao(ClienteDomain cliente) {
        if (clienteRepository.buscarUsuarioPorEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Usuário já possui um cartão.");
        }

        CartaoDomain cartao = geraCartao.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
        return clienteRepository.salvar(cliente);

    }

    @Override
    public ClienteDomain buscarPorCpf(String cpf) {
        return clienteRepository.buscarUsuarioPorCPF(cpf).
                orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }
}
