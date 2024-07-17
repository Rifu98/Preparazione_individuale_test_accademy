package com.federicorifugiato.dto;

import com.federicorifugiato.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    private Integer id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cognome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotNull
    private Role ruolo;

    private Double saldo = 0.0;

    private String codiceInvito;
    private String codiceInvitoUsato;
    private Boolean primoAcquisto = false;
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
	public void setPassword(String password) {
		this.password = password;
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

    // Getters and setters
}
