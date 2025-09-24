package com.github.unovajournal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CapturedPokemons {

  @EmbeddedId private CapturedPokemonsId capturedPokemonsId;

  private LocalDateTime capturedOn;

  @ManyToOne
  @MapsId("pokemonId") // maps the pokemonId attribute of embedded id
  @JoinColumn(name = "pokemon_id")
  private Pokemon pokemon;

  @ManyToOne
  @MapsId("locationId") // maps the locationId attribute of embedded id
  @JoinColumn(name = "location_id")
  private Location location;

  public CapturedPokemons() {}

  public CapturedPokemons(CapturedPokemonsId capturedPokemonsId) {
    this.capturedPokemonsId = capturedPokemonsId;
  }

  @Override
  public String toString() {
    return "CapturedPokemons{"
        + "capturedPokemonsId="
        + capturedPokemonsId
        + ", capturedOn="
        + capturedOn
        + ", pokemon="
        + pokemon
        + ", location="
        + location
        + '}';
  }

  public CapturedPokemonsId getCapturedPokemonsId() {
    return capturedPokemonsId;
  }

  public void setCapturedPokemonsId(CapturedPokemonsId capturedPokemonsId) {
    this.capturedPokemonsId = capturedPokemonsId;
  }

  public LocalDateTime getCapturedOn() {
    return capturedOn;
  }

  public void setCapturedOn(LocalDateTime capturedOn) {
    this.capturedOn = capturedOn;
  }

  public Pokemon getPokemon() {
    return pokemon;
  }

  public Location getLocation() {
    return location;
  }
}
