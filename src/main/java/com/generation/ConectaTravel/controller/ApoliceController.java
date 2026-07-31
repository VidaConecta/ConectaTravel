package com.generation.ConectaTravel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ConectaTravel.model.Apolice;
import com.generation.ConectaTravel.repository.ApoliceRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apolices")
@CrossOrigin(origins = " * " , allowedHeaders = "*")
public class ApoliceController {
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@GetMapping
	public ResponseEntity<List<Apolice>>getAll(){
		return ResponseEntity.ok(apoliceRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Apolice> getEntity(@PathVariable Long id){
		
		return apoliceRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
    public ResponseEntity<Apolice> post(@Valid @RequestBody Apolice apolice) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apoliceRepository.save(apolice));
    }
	
	@PutMapping
    public ResponseEntity<Apolice> put(@Valid @RequestBody Apolice apolice) {
        if (apolice.getId() == null || !apoliceRepository.existsById(apolice.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(apoliceRepository.save(apolice));
    }
	
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!apoliceRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apólice não encontrada!");
        }
        apoliceRepository.deleteById(id);
    }
	
	
}
