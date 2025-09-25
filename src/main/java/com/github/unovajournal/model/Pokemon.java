package com.github.unovajournal.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pokemon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToMany(mappedBy = "pokemon")
  private List<PokemonMoves> moves = new ArrayList<>();

  @OneToMany(mappedBy = "pokemon")
  private List<CapturedPokemons> capturedPokemonLocations = new ArrayList<>();

  private String name;
  private String type_1;
  private String type_2;
  private int level;
  private int hp;
  private int attack;
  private int defense;
  private int speed;
  private int sp_attack;
  private int sp_defense;

  public Pokemon() {}

  public Pokemon(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Pokemon{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", type_1='"
        + type_1
        + '\''
        + ", type_2='"
        + type_2
        + '\''
        + ", level="
        + level
        + ", hp="
        + hp
        + ", attack="
        + attack
        + ", defense="
        + defense
        + ", speed="
        + speed
        + ", sp_attack="
        + sp_attack
        + ", sp_defense="
        + sp_defense
        + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<PokemonMoves> getMoves() {
    return moves == null ? null : List.copyOf(moves);
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP2",
      justification = "The PokemonMoves List is mutable but this is acceptable in this context")
  public void setMoves(List<PokemonMoves> moves) {
    this.moves = moves;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType_1() {
    return type_1;
  }

  public void setType_1(String type_1) {
    this.type_1 = type_1;
  }

  public String getType_2() {
    return type_2;
  }

  public void setType_2(String type_2) {
    this.type_2 = type_2;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSp_attack() {
    return sp_attack;
  }

  public void setSp_attack(int sp_attack) {
    this.sp_attack = sp_attack;
  }

  public int getSp_defense() {
    return sp_defense;
  }

  public void setSp_defense(int sp_defense) {
    this.sp_defense = sp_defense;
  }

  public List<CapturedPokemons> getCapturedPokemonLocations() {
    return capturedPokemonLocations == null ? null : List.copyOf(capturedPokemonLocations);
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP2",
      justification = "The CapturedPokemons List is mutable but this is acceptable in this context")
  public void setCapturedPokemonLocations(List<CapturedPokemons> capturedPokemonLocations) {
    this.capturedPokemonLocations = capturedPokemonLocations;
  }
}
