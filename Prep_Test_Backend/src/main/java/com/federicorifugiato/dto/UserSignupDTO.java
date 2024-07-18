package com.federicorifugiato.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserSignupDTO {

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il nome è obbligatorio")
    private String cognome;

    @NotBlank(message = "Il nome è obbligatorio")
    @Email(message = "formato mail non valido")
    private String email;

    @NotBlank(message = "Il nome è obbligatorio")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    		message = "password debole")
    private String password;

    private String codiceInvitoUsato;

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

	public String getCodiceInvitoUsato() {
		return codiceInvitoUsato;
	}

	public void setCodiceInvitoUsato(String codiceInvitoUsato) {
		this.codiceInvitoUsato = codiceInvitoUsato;
	}
}
