package br.com.brito.operadoracartaocredito.adapters.in.dto.request;

public record ClienteRequestDTO(String nome,
                                String email,
                                Integer idade,
                                String cpf,
                                EnderecoRequestDTO endereco,
                                double rendaMensal,
                                String dataVencimentoFatura){}
