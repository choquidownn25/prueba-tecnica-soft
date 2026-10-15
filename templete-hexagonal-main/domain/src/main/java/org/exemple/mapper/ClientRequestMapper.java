package org.exemple.mapper;

import org.exemple.data.ClientDto;
import org.exemple.data.request.ClientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientRequestMapper {
    ClientRequestMapper INSTANCE = Mappers.getMapper(ClientRequestMapper.class);
    ClientRequest clientRequestToClientRequest(ClientDto clientDto);
    ClientDto clientRequestToClientDto(ClientRequest clientRequest);
}
