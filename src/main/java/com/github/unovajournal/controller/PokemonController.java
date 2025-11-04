package com.github.unovajournal.controller;

import com.github.unovajournal.model.Pokemon;
import com.github.unovajournal.repository.PokemonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PokemonController {

  @Autowired private PokemonRepository pokemonRepository;

  @GetMapping("/pokemons/dual-typing")
  public List<Pokemon> getPokemonsByDualTyping(String type1, String type2) {
    return pokemonRepository.findByDualTyping(type1, type2);
  }

  @GetMapping("/pokemons/search")
  public List<Pokemon> searchPokemonsByName(String name) {
    return pokemonRepository.findByNameContaining(name);
  }

  @GetMapping("/pokemons/level-range")
  public List<Pokemon> getPokemonsByLevelRange(int minLevel, int maxLevel) {
    return pokemonRepository.findByLevelBetween(minLevel, maxLevel);
  }

  @PostMapping("/pokemons")
  public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
    return pokemonRepository.save(pokemon);
  }

  @PutMapping("/pokemons/{id}")
  public ResponseEntity<Pokemon> updatePokemon(
      @PathVariable Integer id, @RequestBody Pokemon pokemonDetails) {
    return pokemonRepository
        .findById(id)
        .map(
            pokemon -> {
              pokemon.setName(pokemonDetails.getName());
              pokemon.setType_1(pokemonDetails.getType_1());
              pokemon.setType_2(pokemonDetails.getType_2());
              pokemon.setLevel(pokemonDetails.getLevel());
              pokemon.setHp(pokemonDetails.getHp());
              pokemon.setAttack(pokemonDetails.getAttack());
              pokemon.setDefense(pokemonDetails.getDefense());
              pokemon.setSp_attack(pokemonDetails.getSp_attack());
              pokemon.setSp_defense(pokemonDetails.getSp_defense());
              pokemon.setSpeed(pokemonDetails.getSpeed());
              Pokemon updatedPokemon = pokemonRepository.save(pokemon);
              return ResponseEntity.ok(updatedPokemon);
            })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/pokemons/{id}")
  public ResponseEntity<?> deletePokemonById(@PathVariable Integer id) {
    pokemonRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
