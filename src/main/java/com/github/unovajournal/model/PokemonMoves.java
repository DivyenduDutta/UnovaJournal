package com.github.unovajournal.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP2",
      justification = "The PokemonMovesId object is mutable but this is acceptable in this context")
  public PokemonMoves(PokemonMovesId id) {
    this.id = id;
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP",
      justification = "The PokemonMovesId object is mutable but this is acceptable in this context")
  public PokemonMovesId getId() {
    return id;
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP2",
      justification = "The PokemonMovesId object is mutable but this is acceptable in this context")
  public void setId(PokemonMovesId id) {
    this.id = id;
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP",
      justification = "The Pokemon object is mutable but this is acceptable in this context")
  public Pokemon getPokemon() {
    return pokemon;
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP",
      justification = "The Move object is mutable but this is acceptable in this context")
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
