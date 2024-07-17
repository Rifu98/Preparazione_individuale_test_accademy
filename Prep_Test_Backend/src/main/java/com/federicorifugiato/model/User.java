package com.federicorifugiato.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String nome;

    @NotEmpty
    @Column(nullable = false)
    private String cognome;

    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role ruolo;

    @Column(nullable = false)
    private Double saldo = 0.0;

    private String codiceInvito;
    private String codiceInvitoUsato;
    private Boolean primoAcquisto = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "User_Materia",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materie;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public Role getRuolo() {
		return ruolo;
	}

	public void setRuolo(Role ruolo) {
		this.ruolo = ruolo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getCodiceInvito() {
		return codiceInvito;
	}

	public void setCodiceInvito(String codiceInvito) {
		this.codiceInvito = codiceInvito;
	}

	public String getCodiceInvitoUsato() {
		return codiceInvitoUsato;
	}

	public void setCodiceInvitoUsato(String codiceInvitoUsato) {
		this.codiceInvitoUsato = codiceInvitoUsato;
	}

	public Boolean getPrimoAcquisto() {
		return primoAcquisto;
	}

	public void setPrimoAcquisto(Boolean primoAcquisto) {
		this.primoAcquisto = primoAcquisto;
	}

	public Set<Materia> getMaterie() {
		return materie;
	}

	public void setMaterie(Set<Materia> materie) {
		this.materie = materie;
	}

	public void setPassword(String encode) {
		this.password = encode;
		
	}

    // Getters and setters
}
