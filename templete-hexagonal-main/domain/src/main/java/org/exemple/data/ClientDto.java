package org.exemple.data;

import lombok.*;

@Getter
@Setter
public class ClientDto {
    int id;
    String firstName;
    String lastName;
    String surname;
    String phone;
    String email;

    public ClientDto(int id, String firstName, String lastName, String surname, String phone, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }
}
