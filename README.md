# Parcial-corte-2
## Estudiantes

Allan Caicedo
Juan Gaviria

## Diagrama de Clases

```mermaid
classDiagram
    %% Clase abstracta base
    class Criatura {
        <<abstract>>
        -nombre: String
        -salud: int
        -fuerza: int
        +Criatura(nombre, salud, fuerza)
        +atacar(Criatura)*
        +defender(int)*
        +estaViva(): boolean
        +getNombre(): String
        +getSalud(): int
        +getFuerza(): int
    }

    %% Interfaces
    class Magico {
        <<interface>>
        +lanzarHechizo()*
        +aprenderHechizo()*
    }

    class Volador {
        <<interface>>
        +volar()*
        +aterrizar()*
    }

    %% Clases concretas
    class Guerrero {
        -armaNombre: String
        -arma: Arma
        +Guerrero(nombre, salud, fuerza, armaNombre)
        +atacar(Criatura)
        +defender(int)
        +equiparArma(Arma)
        +desequiparArma()
        +getArmaNombre(): String
        +getArma(): Arma
    }

    class Mago {
        -hechizos: String
        -arma: Arma
        +Mago(nombre, salud, fuerza, hechizos)
        +atacar(Criatura)
        +defender(int)
        +lanzarHechizo()
        +aprenderHechizo()
        +equiparArma(Arma)
        +desequiparArma()
        +getHechizos(): String
        +getArma(): Arma
    }

    class Dragon {
        -escamas: String
        -arma: Arma
        +Dragon(nombre, salud, fuerza, escamas)
        +atacar(Criatura)
        +defender(int)
        +volar()
        +aterrizar()
        +equiparArma(Arma)
        +desequiparArma()
        +getArma(): Arma
        +getEscamas(): String
    }

    class Arma {
        -nombre: String
        -dañoAdicional: int
        +Arma(nombre, dañoAdicional)
        +atacarConArma(Criatura)
        +getDañoAdicional(): int
        +getNombre(): String
    }

    %% Relaciones de herencia
    Criatura <|-- Guerrero
    Criatura <|-- Mago
    Criatura <|-- Dragon

    %% Relaciones de interfaz
    Mago --|> Magico
    Dragon --|> Volador

    %% Composición (has-a)
    Guerrero o-- Arma
    Mago o-- Arma
    Dragon o-- Arma
```

## Descripción de la Estructura

**Clase Base:**
- `Criatura` (abstracta) - Define los atributos comunes: nombre, salud, fuerza

**Clases Concretas (heredan de Criatura):**
- `Guerrero` - Combatiente cuerpo a cuerpo, reduce daño 15% con armadura
- `Mago` - Lanza hechizos, reduce daño 10% con escudo mágico
- `Dragon` - Ataca con el doble de fuerza, reduce daño 20% con escamas, puede volar

**Interfaces:**
- `Magico` - Permite lanzar y aprender hechizos (implementada por `Mago`)
- `Volador` - Permite volar y aterrizar (implementada por `Dragon`)

**Clase de Composición:**
- `Arma` - Cada criatura "tiene un arma" (relación has-a, no herencia)

