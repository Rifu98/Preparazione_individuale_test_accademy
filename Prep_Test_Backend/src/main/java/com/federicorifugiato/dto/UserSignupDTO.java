package com.federicorifugiato.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UserSignupDTO {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cognome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    private String codiceInvito;

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

	public String getCodiceInvito() {
		return codiceInvito;
	}

	public void setCodiceInvito(String codiceInvito) {
		this.codiceInvito = codiceInvito;
	}

    // Getters and setters
}
