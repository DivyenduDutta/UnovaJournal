package com.github.unovajournal.model;

import jakarta.persistence.*;

@Entity
public class PokemonMoves {

  @EmbeddedId private PokemonMovesId id;
  private int levelLearnedAt;

  @ManyToOne
  @MapsId("pokemonId") // maps the pokemonId attribute of embedded id
  @JoinColumn(name = "pokemon_id")
  private Pokemon pokemon;

  @ManyToOne
  @MapsId("moveId") // maps the moveId attribute of embedded id
  @JoinColumn(name = "move_id")
  private Move move;

  public PokemonMoves() {}

  public PokemonMoves(PokemonMovesId id) {
    this.id = id;
  }

  public PokemonMovesId getId() {
    return id;
  }

  public void setId(PokemonMovesId id) {
    this.id = id;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public Move getMove() {
    return move;
  }

  public int getLevelLearnedAt() {
    return levelLearnedAt;
  }

  public void setLevelLearnedAt(int levelLearnedAt) {
    this.levelLearnedAt = levelLearnedAt;
  }
}
