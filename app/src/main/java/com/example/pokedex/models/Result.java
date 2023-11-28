package com.example.pokedex.models;

public class Result {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String value) {
        this.url = value;
    }

    public String getNumber() {
        String[] urlParts = url.split("/");
        return urlParts[urlParts.length - 1];
    }

    public String getImageUrl() {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + getNumber()+".png";
    }
}
