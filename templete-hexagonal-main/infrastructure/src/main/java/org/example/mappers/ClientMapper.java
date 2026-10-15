package org.example.mappers;

import org.example.entity.Client;
import org.exemple.data.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    ClientDto clientDtoToClient(Client clien);
    Client clientToClientDto(ClientDto clientDto);

    List<Client> clientDtosToClients(List<ClientDto> clientDtos);
    List<ClientDto> clientsToClientDtos(List<Client> clients);

}
