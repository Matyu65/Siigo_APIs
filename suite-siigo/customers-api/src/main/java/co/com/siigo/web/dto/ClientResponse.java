package co.com.siigo.web.dto;

import co.com.siigo.domain.*;

public record ClientResponse(
        Long id,
        ClientType type,
        ClientStatus status,
        String identification,
        Integer dv,
        String email,
        String firstName,
        String lastName,
        String businessName,
        String phone
) {}
