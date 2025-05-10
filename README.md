
# Uno Game Engine 🎮

Welcome to the **Uno Game Engine**, a flexible and extensible engine built using Java and object-oriented principles. This engine is designed for **developers**, not players — allowing you to create your own variations of the Uno game with minimal effort.

## 🔧 Features

- Supports classic Uno rules and customizable variants.
- Built-in support for:
  - Numbered cards (0–9)
  - Action cards (Reverse, Skip, Draw Two)
  - Wild cards (Wild, Wild Draw Four)
- Easily extendable to support new:
  - Cards
  - Behaviors
  - Game rules
- Implements key OOP principles and modern design patterns:
  - Strategy
  - Singleton
  - Observer

## 🏗️ Architecture Overview

### Core Packages

- **`game`**: Contains the abstract `Game` class to be extended by developers. Includes the core game loop and flow.
- **`player`**: Manages player state and cards.
- **`deck`**: Handles deck creation, shuffling, drawing, and discarding.
- **`card`**: Models Uno cards with enums for color and value.
- **`behavior`**: Defines card behaviors via the `CardBehavior` interface and implementations for each card type.
- **`developer`**: Demonstrates an example variation (`MyGame`) with custom rules and cards.

## 🧠 Design Patterns Used

- **Strategy Pattern** – encapsulates card behaviors to allow new actions without modifying existing code.
- **Observer Pattern** – notifies players when the top card changes.
- **Singleton Pattern** – ensures there is only one `Deck` instance shared across the game.

## ✅ SOLID & Clean Code Principles

This engine was built following:
- **SOLID principles** (Single Responsibility, Open/Closed, etc.)
- **Clean Code practices** (KISS, DRY, YAGNI, etc.)
- **Effective Java** recommendations

See the `report.pdf` for a detailed breakdown and justifications.

## 🚀 How to Use

1. **Extend the `Game` class** in your own class (e.g., `MyGame`) and override:
   - `play()`
   - `getTurnInformation()`
   - `handleBehavior(Card card)`
2. **Add custom behavior** by implementing the `CardBehavior` interface.
3. Run the engine with two lines of code in `GameDriver`:
```java
Game myGame = new MyGame();
myGame.play();
```

## 📦 Example Customization

The provided `MyGame` class demonstrates:
- Adding a new custom card (e.g., "Dance" card)
- Defining a new behavior
- Custom draw/deal logic
