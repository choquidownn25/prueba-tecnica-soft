package org.exemple.ports.api;

import org.exemple.data.ClientDto;
import org.exemple.data.request.ClientRequest;
import org.exemple.data.response.ClientDtoResponse;

import java.util.List;

public interface ClientServicePort {
    ClientDtoResponse getClientDtoById(int id);
    ClientDtoResponse save(ClientRequest clientDtoResponse);
    ClientDtoResponse update(ClientRequest clientDtoResponse);
    void delete(int id);
    List<ClientDto> findAll();

}
