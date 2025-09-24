package com.github.unovajournal.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CapturedPokemonsId implements Serializable {

  private int pokemonId;
  private int locationId;

  public CapturedPokemonsId() {}

  public CapturedPokemonsId(int pokemonId, int locationId) {
    this.pokemonId = pokemonId;
    this.locationId = locationId;
  }

  @Override
  public String toString() {
    return "CapturedPokemonsId{" + "pokemonId=" + pokemonId + ", locationId=" + locationId + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    CapturedPokemonsId that = (CapturedPokemonsId) o;
    return pokemonId == that.pokemonId && locationId == that.locationId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokemonId, locationId);
  }

  public int getPokemonId() {
    return pokemonId;
  }

  public void setPokemonId(int pokemonId) {
    this.pokemonId = pokemonId;
  }

  public int getLocationId() {
    return locationId;
  }

  public void setLocationId(int locationId) {
    this.locationId = locationId;
  }
}
