package org.example.configuration;

import org.example.adapters.ClientJpaAdapter;
import org.exemple.ports.api.ClientServicePort;
import org.exemple.ports.spi.ClientPersistencePort;
import org.exemple.service.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean
    public ClientPersistencePort clientPersistencePort() {
        return new ClientJpaAdapter();
    }
    @Bean
    public ClientServicePort clientServicePort() {
        return new ClientServiceImpl(clientPersistencePort());
    }
}
