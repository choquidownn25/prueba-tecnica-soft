package org.example.controller;

import org.exemple.data.ClientDto;
import org.exemple.data.TicketDTO;
import org.exemple.data.request.ClientRequest;
import org.exemple.data.request.TicketDTORequest;
import org.exemple.data.response.ClientDtoResponse;
import org.exemple.data.response.TicketDTOResponse;
import org.exemple.ports.api.ClientServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/client")

public class ClientController {
  
    private  ClientServicePort clientServicePort; 
    @Autowired
    public ClientController(ClientServicePort clientServicePort) {
        this.clientServicePort = clientServicePort;
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDtoResponse> addClient(@RequestBody ClientRequest ClientDTO){
        ClientDtoResponse ClientDTOResponse = new ClientDtoResponse();
        ClientDTOResponse = clientServicePort.save(ClientDTO);
        if(ClientDTOResponse != null) {
            return new ResponseEntity<ClientDtoResponse>(ClientDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<ClientDtoResponse>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ClientDtoResponse> updateClient(@RequestBody ClientRequest ClientDTO){
        ClientDtoResponse ClientDtoResponse = new ClientDtoResponse();
        ClientDtoResponse = clientServicePort.update(ClientDTO);
        if(ClientDtoResponse != null) {
            return new ResponseEntity<ClientDtoResponse>(ClientDtoResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ClientDtoResponse>(ClientDtoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<ClientDto>> getClient( ){
        List<ClientDto> listClientDtoResponse = new ArrayList<>();
        listClientDtoResponse = clientServicePort.findAll();
        if(listClientDtoResponse != null) {
            return new ResponseEntity<List<ClientDto>>(listClientDtoResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<ClientDto>>(listClientDtoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ClientDtoResponse> getByIdClient(@PathVariable Integer id){
        ClientDtoResponse ClientDtoResponse = new ClientDtoResponse();
        ClientDtoResponse = clientServicePort.getClientDtoById(id);
        if(ClientDtoResponse != null) {
            return new ResponseEntity<ClientDtoResponse>(ClientDtoResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<ClientDtoResponse>(ClientDtoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/clientes/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientServicePort.delete(id);
    }
}
