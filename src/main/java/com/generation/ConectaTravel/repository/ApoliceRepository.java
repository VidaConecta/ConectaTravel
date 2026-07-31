package com.generation.ConectaTravel.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.ConectaTravel.model.Apolice;

public interface ApoliceRepository extends JpaRepository<Apolice, Long>{
		public List<Apolice> findAllByValorPremioContainingIgnoreCase(String valorPremio);
		public Apolice findById(long id); 
}
