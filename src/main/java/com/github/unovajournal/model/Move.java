package com.github.unovajournal.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Move {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToMany(mappedBy = "move")
  private List<PokemonMoves> pokemons = new ArrayList<>();

  private String name;
  private String type;
  private String category;
  private int power;
  private int accuracy;
  private int pp;

  public Move() {}

  public Move(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Move{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", type='"
        + type
        + '\''
        + ", category='"
        + category
        + '\''
        + ", power="
        + power
        + ", accuracy="
        + accuracy
        + ", pp="
        + pp
        + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<PokemonMoves> getPokemons() {
    return pokemons == null ? null : List.copyOf(pokemons);
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP2",
      justification = "The PokemonMoves List is mutable but this is acceptable in this context")
  public void setPokemons(List<PokemonMoves> pokemons) {
    this.pokemons = pokemons;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public int getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(int accuracy) {
    this.accuracy = accuracy;
  }

  public int getPp() {
    return pp;
  }

  public void setPp(int pp) {
    this.pp = pp;
  }
}
