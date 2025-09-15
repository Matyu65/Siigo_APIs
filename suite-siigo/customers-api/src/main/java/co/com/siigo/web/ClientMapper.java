package co.com.siigo.web;

import co.com.siigo.domain.*;
import co.com.siigo.web.dto.*;

public class ClientMapper {
    public static Client toEntity(ClientRequest r) {
        Client c = new Client();
        c.setType(r.type());
        c.setIdentification(r.identification());
        c.setDv(r.dv());
        c.setEmail(r.email());
        c.setFirstName(r.firstName());
        c.setLastName(r.lastName());
        c.setBusinessName(r.businessName());
        c.setPhone(r.phone());
        return c;
    }
    public static void update(Client c, ClientRequest r) {
        c.setType(r.type());
        c.setIdentification(r.identification());
        c.setDv(r.dv());
        c.setEmail(r.email());
        c.setFirstName(r.firstName());
        c.setLastName(r.lastName());
        c.setBusinessName(r.businessName());
        c.setPhone(r.phone());
    }
    public static ClientResponse toResponse(Client c) {
        return new ClientResponse(
            c.getId(), c.getType(), c.getStatus(), c.getIdentification(), c.getDv(),
            c.getEmail(), c.getFirstName(), c.getLastName(), c.getBusinessName(), c.getPhone()
        );
    }
}
