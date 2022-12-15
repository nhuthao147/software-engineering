package com.example.demo.dto;

public class LoginResult {
    private boolean status;
    private String token;

    public LoginResult(boolean status, String token) {
        this.status = status;
        this.token = token;
    }

    public LoginResult() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
