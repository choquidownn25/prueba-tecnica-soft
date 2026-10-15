package org.exemple.ports.spi;

import org.exemple.data.ClientDto;

import java.util.List;

public interface ClientPersistencePort {
    ClientDto getClientDtoById(int id);
    ClientDto save(ClientDto clientDto);
    ClientDto update(ClientDto clientDto);
    void delete(int id);
    List<ClientDto> findAll();
}
