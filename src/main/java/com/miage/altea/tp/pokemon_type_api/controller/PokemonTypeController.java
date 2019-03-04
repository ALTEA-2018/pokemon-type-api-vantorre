package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/pokemon-types")
class PokemonTypeController {

    PokemonTypeService pokemonTypeService;


    public PokemonTypeController(@Autowired PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id) {
        return pokemonTypeService.getPokemonType(id);
    }


    @GetMapping(value = "/")
    public List<PokemonType> getAllPokemonTypes(@RequestParam(value = "locale", required = false) Locale locale) {
        return pokemonTypeService.getAllPokemonTypes(locale);
    }


    @GetMapping(path = "", params = "name")
    public PokemonType getPokemonByName(@RequestParam(value = "name") String name) {
        return pokemonTypeService.getPokemonTypeByName(name);
    }
}