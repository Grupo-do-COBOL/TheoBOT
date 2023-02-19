package br.mackenzie.theobot.config;

public class TokenConfig {

    private String token = System.getenv("TOKEN_BOT");
    public TokenConfig() {

        this.token = token;
    }
    public String getToken() {

        return token;
    }

}