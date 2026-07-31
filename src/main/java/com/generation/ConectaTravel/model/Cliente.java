package com.generation.ConectaTravel.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 03 e no máximo 100 caracteres")
    private String name;

    @NotNull(message = "A data de nascimento é obrigatória!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotBlank(message = "O atributo CPF/CNPJ é obrigatório!")
    @Size(min = 11, max = 18, message = "O CPF/CNPJ deve ter entre 11 e 18 caracteres")
    private String cpfCnpj;

    @NotBlank(message = "O atributo e-mail é obrigatório!")
    @Email(message = "O atributo e-mail deve ser um e-mail válido!")
    @Size(max = 255, message = "O e-mail deve conter no máximo 255 caracteres")
    private String email;

    @NotBlank(message = "O atributo empresaTech é obrigatório!")
    @Size(min = 2, max = 100, message = "O nome da Empresa Tech deve conter no mínimo 02 e no máximo 100 caracteres")
    private String empresaTech;

    // Construtor Padrão
    public Cliente() {}

    // Getters e Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresaTech() {
        return this.empresaTech;
    }

    public void setEmpresaTech(String empresaTech) {
        this.empresaTech = empresaTech;
    }
}