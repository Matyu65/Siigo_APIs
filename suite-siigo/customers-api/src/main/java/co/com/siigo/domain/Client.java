package co.com.siigo.domain;

import co.com.siigo.validation.Nit;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "clients", uniqueConstraints = @UniqueConstraint(name="uk_identification", columnNames = "identification"))
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ClientType type;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ClientStatus status = ClientStatus.DRAFT;

    @Nit
    private String identification;

    private Integer dv; // solo para juridical

    @Email @NotBlank
    private String email;

    // NATURAL
    private String firstName;
    private String lastName;

    // JURIDICAL
    private String businessName;

    @Size(min = 7, max = 15)
    private String phone;

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ClientType getType() { return type; }
    public void setType(ClientType type) { this.type = type; }

    public ClientStatus getStatus() { return status; }
    public void setStatus(ClientStatus status) { this.status = status; }

    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }

    public Integer getDv() { return dv; }
    public void setDv(Integer dv) { this.dv = dv; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
