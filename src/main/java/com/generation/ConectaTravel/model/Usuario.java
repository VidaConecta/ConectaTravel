package com.generation.ConectaTravel.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Indica a entidade do banco de dados
@Table(name = "tb_usuarios") // Indica o nome da tabela no banco de dados
public class Usuario {

	@Id // Indica a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor da chave primária será gerado
														// automaticamente
	private Long id; // Atributo id do tipo Long

	@NotBlank(message = "O nome é obrigatório") // Validação para não permitir valor nulo ou vazio
	private String nome;

	// Validações para o atributo usuario
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O Atributo Usuário é Obrigatório!")
	@Email(message = "O Atributo Usuário deve ser um email válido!")
	@Size(max = 255, message = "O usuario não pode ser maior do que 255 caracteres")
	@Column(length = 255)
	private String usuario;

	@NotBlank(message = "A senha é obrigatória") // Validação para não permitir valor nulo ou vazio
	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") // Validação para verificar se o valor tem no
																		// mínimo 6 caracteres
	private String senha;

	@NotBlank(message = "O cargo é obrigatório")
	@Size(min = 3, max = 20, message = "O cargo deve ter entre 3 e 20 caracteres")
	private String cargo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Apolice> apolices;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Apolice> getApolices() {
		return apolices;
	}

	public void setApolices(List<Apolice> apolices) {
		this.apolices = apolices;
	}

}
