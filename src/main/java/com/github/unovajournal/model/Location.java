package com.github.unovajournal.model;

import com.github.unovajournal.enums.LocationType;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @Enumerated(EnumType.STRING)
  private LocationType type;

  @OneToMany(mappedBy = "location")
  private List<CapturedPokemons> capturedPokemons = new ArrayList<>();

  public Location() {}

  public Location(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Location{" + "id=" + id + ", name='" + name + '\'' + ", type=" + type + '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocationType getType() {
    return type;
  }

  public void setType(LocationType type) {
    this.type = type;
  }

  public List<CapturedPokemons> getCapturedPokemons() {
    return capturedPokemons == null ? null : List.copyOf(capturedPokemons);
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP2",
      justification = "The CapturedPokemons List is mutable but this is acceptable in this context")
  public void setCapturedPokemons(List<CapturedPokemons> capturedPokemons) {
    this.capturedPokemons = capturedPokemons;
  }
}
