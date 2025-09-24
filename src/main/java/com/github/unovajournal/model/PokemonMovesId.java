package com.github.unovajournal.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PokemonMovesId implements Serializable {

  private int pokemonId;
  private int moveId;

  public PokemonMovesId() {}

  public PokemonMovesId(int pokemonId, int moveId) {
    this.pokemonId = pokemonId;
    this.moveId = moveId;
  }

  @Override
  public String toString() {
    return "PokemonMovesId{" + "pokemonId=" + pokemonId + ", moveId=" + moveId + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    PokemonMovesId that = (PokemonMovesId) o;
    return pokemonId == that.pokemonId && moveId == that.moveId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonId, moveId);
  }

  public int getPokemonId() {
    return pokemonId;
  }

  public void setPokemonId(int pokemonId) {
    this.pokemonId = pokemonId;
  }

  public int getMoveId() {
    return moveId;
  }

  public void setMoveId(int moveId) {
    this.moveId = moveId;
  }
}
