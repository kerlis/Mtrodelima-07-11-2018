package com.example.erlisaquinoguerrero.mtrodelima.model;
import java.util.HashMap;
import java.util.Map;

public class usuarios {

    private  String idusuario;
    private String username;
    private String password;
    private String email;

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public usuarios(String idusuario, String username, String password, String email) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public usuarios() {
    }

}









