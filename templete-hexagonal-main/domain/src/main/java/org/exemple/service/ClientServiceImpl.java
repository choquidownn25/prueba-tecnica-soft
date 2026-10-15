package org.exemple.service;

import lombok.RequiredArgsConstructor;
import org.exemple.data.ClientDto;
import org.exemple.data.request.ClientRequest;
import org.exemple.data.response.ClientDtoResponse;
import org.exemple.mapper.ClientRequestMapper;
import org.exemple.ports.api.ClientServicePort;
import org.exemple.ports.spi.ClientPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ClientServiceImpl implements ClientServicePort {

    private  ClientPersistencePort clientPersistencePort;
    //private  ClientRequestMapper clientRequestMapper;
    @Autowired
    public ClientServiceImpl(ClientPersistencePort clientPersistencePort) {
        this.clientPersistencePort = clientPersistencePort;

    }
    @Override
    public ClientDtoResponse getClientDtoById(int id) {
        ClientDtoResponse clientDtoResponse = new ClientDtoResponse();
        List<ClientDto> clientDtos = new ArrayList<>();
        ClientDto clientDto = clientPersistencePort.getClientDtoById(id);
        if (clientDto == null) {
            throw new RuntimeException("Client with id " + id + " not found");
        }
        clientDtos.add(clientDto);
        clientDtoResponse.setMessage("Success " );
        clientDtoResponse.setSuccess(true );
        return clientDtoResponse;
    }

    @Override
    public ClientDtoResponse save(ClientRequest clientRequest) {
        ClientDtoResponse clientDtoResponse = new ClientDtoResponse();
        List<ClientDto> clientDtos = new ArrayList<>();
        ClientDto clientDto = ClientRequestMapper.INSTANCE.clientRequestToClientDto(clientRequest);
        ClientDto savedClientDto = clientPersistencePort.save(clientDto);

        if (savedClientDto == null) {
            throw new RuntimeException("Client not saved");
        }
        clientDtos.add(savedClientDto);
        clientDtoResponse.setMessage("Success " );
        clientDtoResponse.setSuccess(true );
        return clientDtoResponse;
    }

    @Override
    public ClientDtoResponse update(ClientRequest clientRequest) {
        ClientDtoResponse clientDtoResponse = new ClientDtoResponse();
        List<ClientDto> clientDtos = new ArrayList<>();
        ClientDto clientDto = ClientRequestMapper.INSTANCE.clientRequestToClientDto(clientRequest);
        ClientDto savedClientDto = clientPersistencePort.save(clientDto);

        if (savedClientDto == null) {
            throw new RuntimeException("Client not saved");
        }
        clientDtos.add(savedClientDto);
        clientDtoResponse.setMessage("Success " );
        clientDtoResponse.setSuccess(true );
        return clientDtoResponse;
    }

    @Override
    public void delete(int id) {
        clientPersistencePort.delete(id);
    }

    @Override
    public List<ClientDto>  findAll() {
        return clientPersistencePort.findAll();
    }
}
