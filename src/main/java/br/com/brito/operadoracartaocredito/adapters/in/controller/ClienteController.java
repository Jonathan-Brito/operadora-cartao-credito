package br.com.brito.operadoracartaocredito.adapters.in.controller;

import br.com.brito.operadoracartaocredito.adapters.in.ClienteService;
import br.com.brito.operadoracartaocredito.adapters.in.dto.request.ClienteRequestDTO;
import br.com.brito.operadoracartaocredito.adapters.in.dto.response.ClienteResponseDTO;
import br.com.brito.operadoracartaocredito.adapters.mapper.ClienteMapper;
import br.com.brito.operadoracartaocredito.adapters.out.entities.ClienteEntity;
import br.com.brito.operadoracartaocredito.application.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(clienteService.solicitarCartao(mapper.toDomain(clienteRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscaClientePorCpf(@RequestParam String cpf) {
        ClienteDomain cliente = clienteService.buscarPorCpf(cpf);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }
}
