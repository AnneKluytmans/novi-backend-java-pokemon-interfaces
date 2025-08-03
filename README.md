# Pokémon Battle Simulator – NOVI Backend Java Assignment

## About the Project

This repository contains my implementation of the **Pokémon Battle Simulator** assignment for the Backend Java module at [Novi University](https://www.novi.nl).  
The goal of this assignment is to collaboratively complete a partially built game engine by implementing all missing classes, interfaces, and logic based on a predefined set of rules and requirements.

This assignment focuses on using **abstraction**, **inheritance**, **interfaces**, and **decision structures** to create a turn-based Pokémon battle system with type-based attack behavior and health logic.

---

![Pokemon!](./assets/pokemon.JPG)

## Table of Contents

- [Tech Stack](#tech-stack)
- [Key features](#key-features)
- [How to Run](#how-to-run)
- [Bonus Features](#bonus-features)
- [Credits](#credits)
- [License](#license)

---

## Tech Stack

- **Java 17+**
- **IntelliJ IDEA**

---


## Key Features

- 🔥 `FirePokemon`, 🌊 `WaterPokemon`, 🌿 `GrassPokemon`, ⚡ `ElectricPokemon`
- Type effectiveness system (fire > grass, grass > electric, etc.)
- Abstract base `Pokemon` class with shared properties, HP handling, and standard behavior
- Interface with 11 attack methods (e.g., `leafStorm`, `rainDance`, `thunder`, `leechSeed`)
- `PokemonGymImpl` class as game engine — left untouched except for imports
- Attacks print battle logs and update HP based on type matchups
- HP boost or transfer mechanics in certain attacks (e.g., `leechSeed`)
- Guard clauses to prevent Pokémon with 0 HP from acting
- A food variable and feeding mechanics to boost HP
- Game loop checks Pokémon health before executing actions → Pokémon with 0 HP are deactivated and cannot attack

---

## How to Run

1. Open the project in your IDE (IntelliJ IDEA)
2. Navigate to the `Main` class
3. Locate the `main` method and click the green play button to **Run 'Main'** or use the terminal:
    ```bash
   mvn clean compile exec:java
   ```

## Credits
> "This assignment was developed as part of the Backend Java module in the NOVI Software Development program. All instructions, logic, and structure are part of the official coursework."

## License
> "This repository is intended for educational purposes only. You are welcome to use the code for learning, but not for commercial use."