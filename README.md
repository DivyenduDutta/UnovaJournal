# UnovaJournal
A Pokémon White 2 Companion Tracker

<a href="https://github.com/DivyenduDutta/UnovaJournal/actions"><img src="https://github.com/DivyenduDutta/UnovaJournal/workflows/Lint_Static_Analysis/badge.svg" alt="ci_info"></a>

CI uses
- SpotLess for code formatting
- SpotBugs for static analysis
- PMD for style/complexity analysis

#### For Developers

Run the below commands in local before pushing code to remote.

##### Code formatting
```bash
mvnw spotless:check
```

If there are formatting issues, run the below command to fix them.
```bash
mvnw spotless:apply
```

##### Static analysis
```bash
mvnw spotbugs:check
```

##### Style/complexity analysis
```bash
mvnw pmd:check
```

### Documentation

#### UML Diagram

```mermaid
classDiagram
    class Pokemon {
      -int Id
      -string Name 
      -string Type1
      -string Type2
      -int Level
      -int HP
      -int Attack
      -int Defense
      -int Speed
      -int SpecialAttack
      -int SpecialDefense
    }

    class Move {
      -int Id
      -string Name
      -string Type
      -string Category
      -int Power
      -int Accuracy
      -int PP
    }

    class PokemonMoves {
      -int PokemonId
      -int MoveId
      -int LevelLearned
    }
    
    class Location {
      -int Id
      -string Name
      -string Type
    }
    
    class CapturedPokemons {
      -int Id
      -int PokemonId
      -int LocationId
      -DateTime CapturedOn
    }

    Pokemon "*" --> "*" PokemonMoves
    Pokemon "*" --> "*" Locations
```

#### System Architecture

```mermaid
flowchart TD
    subgraph API[SpringWeb APIs]
        A[REST Endpoints]
    end

    subgraph DD[SpringData]
        B[Repositories]
    end

    subgraph DB[MySQL Database]
        D[(Pokemon Table)]
        E[(Move Table)]
        F[(PokemonMoves Table)]
        G[(Location Table)]
        H[(CapturedPokemons Table)]
    end

    A --> B
    B --> D
    B --> E
    B --> F
    B --> G
    B --> H
```