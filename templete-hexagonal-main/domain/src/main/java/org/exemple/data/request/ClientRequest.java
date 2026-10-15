package org.exemple.data.request;

public record ClientRequest(
        int id,
        String firstName,
        String lastName,
        String surname,
        String phone,
        String email
) {
}
