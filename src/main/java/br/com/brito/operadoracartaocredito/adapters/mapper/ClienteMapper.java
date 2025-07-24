package br.com.brito.operadoracartaocredito.adapters.mapper;

import br.com.brito.operadoracartaocredito.adapters.in.dto.request.ClienteRequestDTO;
import br.com.brito.operadoracartaocredito.adapters.in.dto.response.ClienteResponseDTO;
import br.com.brito.operadoracartaocredito.adapters.out.entities.CartaoEntity;
import br.com.brito.operadoracartaocredito.adapters.out.entities.ClienteEntity;
import br.com.brito.operadoracartaocredito.application.domain.CartaoDomain;
import br.com.brito.operadoracartaocredito.application.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteEntity paraEntity(ClienteDomain clienteDomain);

    ClienteDomain paraDomain(ClienteEntity clienteEntity);

    @Mapping(target = "cartao", expression = "java(toCartaoDomain(cliente))")
    ClienteDomain toDomain(ClienteRequestDTO cliente);

    ClienteResponseDTO toResponse(ClienteDomain cliente);

    @Mapping(source = "dataVenciomentoFatura", target = "dataVencimentoFatura")
    CartaoDomain toCartaoDomain(ClienteRequestDTO clienteRequestDTO);
}
