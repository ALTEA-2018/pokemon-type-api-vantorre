package com.miage.altea.tp.pokemon_type_api.repository.repository;

import com.miage.altea.tp.pokemon_type_api.repository.bo.PokemonType;

import java.util.List;

public interface PokemonTypeRepository {
    PokemonType findPokemonTypeById(int id);
    PokemonType findPokemonTypeByName(String name);
    List<PokemonType> findAllPokemonType();
}