package co.com.siigo.web.dto;

import co.com.siigo.domain.ClientType;
import co.com.siigo.validation.Nit;
import jakarta.validation.constraints.*;

public record ClientRequest(
        @NotNull ClientType type,
        @Nit String identification,
        Integer dv,
        @Email @NotBlank String email,
        String firstName,
        String lastName,
        String businessName,
        @Size(min=7, max=15) String phone
) {}
