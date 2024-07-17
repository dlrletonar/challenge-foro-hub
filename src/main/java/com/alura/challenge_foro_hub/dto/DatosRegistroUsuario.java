package com.alura.challenge_foro_hub.dto;

import jakarta.validation.constraints.NotBlank;

public class DatosRegistroUsuario {
    @NotBlank
    private String login;

    @NotBlank
    private String password;
// Getters and Setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
