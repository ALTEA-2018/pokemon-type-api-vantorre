package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    @Override
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public PokemonTypeServiceImpl(@Autowired PokemonTypeRepository pokemonTypeRepository, @Autowired TranslationRepository translationRepository){
        this.pokemonTypeRepository = pokemonTypeRepository;
        this.translationRepository = translationRepository;
    }

    public PokemonTypeServiceImpl(){
    }

    @Override
    public PokemonType getPokemonType(int id) {
        PokemonType pokemon = pokemonTypeRepository.findPokemonTypeById(id);
        pokemon.setName(this.translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()));
        return pokemon;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(Locale locale){
        if(locale == null){
            locale = LocaleContextHolder.getLocale();
        }
        final Locale finalLocale = locale;
        return pokemonTypeRepository.findAllPokemonType().stream().map(pokemonType -> {pokemonType.setName(this.translationRepository.getPokemonName(pokemonType.getId(), finalLocale)); return pokemonType;}).collect(Collectors.toList());
    }

    @Override
    public PokemonType getPokemonTypeByName(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }

}