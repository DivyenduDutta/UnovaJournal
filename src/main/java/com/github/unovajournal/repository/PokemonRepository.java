package com.github.unovajournal.repository;

import com.github.unovajournal.model.Pokemon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

  @Query(
      value = "SELECT * FROM pokemon WHERE type_1 = :type1 and type_2 = :type2",
      nativeQuery = true)
  List<Pokemon> findByDualTyping(@Param("type1") String type1, @Param("type2") String type2);

  List<Pokemon> findByNameContaining(String pokemonName);

  List<Pokemon> findByLevelBetween(int minLevel, int maxLevel);
}
