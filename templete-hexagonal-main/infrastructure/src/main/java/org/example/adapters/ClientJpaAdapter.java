package org.example.adapters;

import lombok.RequiredArgsConstructor;
import org.example.entity.Client;
import org.example.mappers.ClientMapper;
import org.example.repository.IClientRepository;
import org.exemple.data.ClientDto;
import org.exemple.ports.spi.ClientPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientJpaAdapter implements ClientPersistencePort {
    @Autowired
    private  IClientRepository iClientRepository;
    //private final ClientMapper clientMapper;
    @Override
    public ClientDto getClientDtoById(int id) {
        Client client = iClientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.INSTANCE.clientDtoToClient(client);

    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return ClientMapper.INSTANCE.clientDtoToClient(iClientRepository.save(ClientMapper.INSTANCE.clientToClientDto(clientDto)));
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        return ClientMapper.INSTANCE.clientDtoToClient(iClientRepository.save(ClientMapper.INSTANCE.clientToClientDto(clientDto)));
    }

    @Override
    public void delete(int id) {
        iClientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return  ClientMapper.INSTANCE.clientsToClientDtos(iClientRepository.findAll());
    }
}
