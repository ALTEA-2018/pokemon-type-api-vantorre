package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;

import java.util.List;
import java.util.Locale;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    List<PokemonType> getAllPokemonTypes(Locale locale);

    PokemonType getPokemonTypeByName(String name);

    void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository);

    void setTranslationRepository(TranslationRepository translationRepository);
}