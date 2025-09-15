package co.com.siigo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.siigo.domain.*;
import co.com.siigo.repo.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) { this.repo = repo; }

    @Transactional
    public Client create(Client c) {
        // Reglas por tipo
        if (c.getType() == ClientType.NATURAL) {
            if (c.getFirstName() == null || c.getLastName() == null)
                throw new IllegalArgumentException("firstName and lastName required for NATURAL");
            c.setDv(null);
        } else {
            if (c.getBusinessName() == null || c.getDv() == null)
                throw new IllegalArgumentException("businessName and dv required for JURIDICAL");
        }
        // duplicados
        repo.findByIdentification(c.getIdentification()).ifPresent(x -> {
            throw new IllegalStateException("identification already exists");
        });
        c.setStatus(ClientStatus.ACTIVE);
        return repo.save(c);
    }

    public Client get(Long id) { return repo.findById(id).orElseThrow(); }

    @Transactional
    public Client update(Long id, Client r) {
        Client c = get(id);
        if (c.getStatus() == ClientStatus.INACTIVE)
            throw new IllegalStateException("INACTIVE clients cannot be edited");
        // simple update
        c.setEmail(r.getEmail());
        c.setPhone(r.getPhone());
        c.setFirstName(r.getFirstName());
        c.setLastName(r.getLastName());
        c.setBusinessName(r.getBusinessName());
        return c;
    }

    @Transactional
    public Client changeStatus(Long id, ClientStatus status) {
        Client c = get(id);
        c.setStatus(status);
        return c;
    }

    public List<Client> list() { return repo.findAll(); }
}
