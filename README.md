# RPG Duel Game

A turn-based 1v1 RPG duel game where players can create characters from a selection of classes and engage in tactical combat.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Setup and Installation](#setup-and-installation)
4. [How to Play](#how-to-play)
5. [Project Structure](#project-structure)
6. [Dependencies](#dependencies)
7. [Known Issues](#known-issues)
8. [Future Improvements](#future-improvements)
9. [Author](#author)

## Introduction

The RPG Duel game allows players to choose from a selection of classes such as Mage, Priest, or Warrior. Each class has unique abilities and characteristics. Players can engage in strategic combat, utilizing their special abilities, which consume resources like energy or mana.

https://github.com/alinikan/RPG-Duel-Game/assets/67564972/bddffee7-eba6-473f-8dc2-0f6d48209c54

## Features

- Multiple character classes with unique abilities.
- Turn-based combat system.
- Character movement on the field.
- Engaging combat with varied attack types including spells, melee, and special abilities.
- Character creation with customizable names and class selection.

## Setup and Installation

1. Ensure you have the Java Development Kit (JDK) installed.
2. Clone the repository: `git clone git@github.com:alinikan/RPG-Duel-Game.git`
3. Navigate to the project directory: `cd rpg-duel-game`
4. Compile the source code: `javac Game/Game.java`
5. Run the game: `java Game.Game`

## How to Play

1. Start the `Game` class.
2. Each player is prompted to name their character and choose a class.
3. Players will alternate turns, either moving or attacking their opponent.
4. The game concludes once a character's HP drops to zero, crowning the other player the victor.

## Project Structure

### Characters Folder

- **RPGCharacter**: Fundamental class for all RPG characters, incorporating essential attributes and functionalities.
- **Caster**: A type of RPG character skilled in casting spells.
- **Mage, Priest**: Specific implementations of the Caster class.
- **Melee**: Represents characters that specialize in physical combat.
- **Warrior**: A concrete implementation of the Melee class.

### Attacks Folder

- **Attack**: Foundation class for specialized attacks.
- **Spell**: Represents spell-based attacks consuming mana.
- **DamageSpell, HealingSpell**: Concrete implementations of spells with varying effects.
- **MeleeAttack**: Represents physical combat attacks.
- **Resurrection**: A unique healing spell capable of reviving characters.

### Game Folder

- **CharacterFactory**: Provides character objects based on player class selections.
- **Duel**: Main game mechanics, handling player interactions and game progression.
- **Game**: Initiates and runs the duel.

## Dependencies

- Java Development Kit (JDK)

## Known Issues

- No known issues as of the latest release.

## Future Improvements

- Introduction of more character classes.
- Multiplayer support for online duels.
- Enhanced graphical user interface.

## Author

Ali Nikan
