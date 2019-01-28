package com.miage.altea.tp.pokemon_type_api.repository.bo;

import lombok.Data;

@Data
public class PokemonType {

    private int id;
    private int baseExperience;
    private int height;
    private String name;
    private Sprites sprites;
    private Stats stats;
    private int weight;



}