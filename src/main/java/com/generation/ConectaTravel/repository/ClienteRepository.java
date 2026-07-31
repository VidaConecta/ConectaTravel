package com.generation.ConectaTravel.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.ConectaTravel.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    // Método para buscar clientes por parte do nome (Ignore Case)
    public List<Cliente> findAllByNameContainingIgnoreCase(String name);
}
