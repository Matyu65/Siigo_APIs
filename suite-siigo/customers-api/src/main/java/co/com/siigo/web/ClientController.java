package co.com.siigo.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.com.siigo.domain.*;
import co.com.siigo.service.ClientService;
import co.com.siigo.web.dto.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clients")
@Validated
public class ClientController {
    private final ClientService service;
    public ClientController(ClientService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ClientRequest r) {
        try {
            Client saved = service.create(ClientMapper.toEntity(r));
            return ResponseEntity.created(URI.create("/api/v1/clients/" + saved.getId()))
                    .body(ClientMapper.toResponse(saved));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(org.springframework.http.HttpStatus.BAD_REQUEST, e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(new ErrorResponse(org.springframework.http.HttpStatus.CONFLICT, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ClientResponse get(@PathVariable Long id) {
        return ClientMapper.toResponse(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ClientRequest r) {
        try {
            Client updated = service.update(id, ClientMapper.toEntity(r));
            return ResponseEntity.ok(ClientMapper.toResponse(updated));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(new ErrorResponse(org.springframework.http.HttpStatus.CONFLICT, e.getMessage()));
        }
    }

    @PatchMapping("/{id}/status")
    public ClientResponse changeStatus(@PathVariable Long id, @RequestParam ClientStatus status) {
        return ClientMapper.toResponse(service.changeStatus(id, status));
    }
}
