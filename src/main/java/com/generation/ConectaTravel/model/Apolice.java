package com.generation.ConectaTravel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_apolice")
public class Apolice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O atributo numero é obrigatório")
	@Size(min = 1, max = 255, message = "O atributo deve ter entre 1 e 255 caracteres.")
	@Column(length = 255)
    private String numeroApolice;
    
    @NotBlank(message = "O atributo destino é obrigatório")
	@Size(min = 1, max = 255, message = "O atributo deve ter entre 3 e 255 caracteres.")
	@Column(length = 255)
    private String destino;
    
    private LocalDate dataInicio;
    private LocalDate dataFim;
    
	@Column(precision = 10, scale = 2)
    private BigDecimal valorPremio;

    @NotBlank(message = "O atributo status é obrigatório")
	@Size(min = 1, max = 255, message = "O atributo deve ter entre 3 e 255 caracteres.")
	@Column(length = 255)
    private String status;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "tb_coberturas_apolice",
        joinColumns = @JoinColumn(name = "apolice_id")
    )
    @Column(name = "cobertura")
    private List<String> coberturas = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(BigDecimal valorPremio) {
        this.valorPremio = valorPremio;
    }

    public List<String> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<String> coberturas) {
        this.coberturas = coberturas;
    }

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
    

}