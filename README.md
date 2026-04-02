# Vector Draw App

A Java application demonstrating **composition over inheritance**, **SOLID principles**, and interface-based design through geometric shapes drawn on a canvas.

## Class Structure

```mermaid
classDiagram
    class Drawable {
        <<interface>>
        +draw()
    }

    class ShapeProperties {
        -String color
        -boolean transparent
        +ShapeProperties(String, boolean)
        +getColor() String
        +setColor(String)
        +isTransparent() boolean
        +setTransparent(boolean)
    }

    class CanCalculateArea {
        <<interface>>
        +calculateArea() double
    }

    class Triangle {
        -ShapeProperties props
        -double base
        -double height
        +Triangle(double, double, String, boolean)
        +draw()
        +calculateArea() double
    }

    class Rectangle {
        -ShapeProperties props
        -double width
        -double height
        +Rectangle(double, double, String, boolean)
        +draw()
        +calculateArea() double
    }

    class Circle {
        -ShapeProperties props
        -double radius
        +Circle(double, String, boolean)
        +draw()
        +calculateArea() double
    }

    class CanCalculateLength {
        <<interface>>
        +calculateLength() double
    }

    class Line {
        -ShapeProperties props
        -Point start
        -Point end
        +Line(Point, Point, String, boolean)
        +calculateLength() double
        +draw()
    }

    class Curve {
        -ShapeProperties props
        -float radius
        -int angle
        +Curve(float, int, String, boolean)
        +calculateLength() double
        +draw()
    }

    class Canvas {
        -ArrayList~Drawable~ shapes
        +Canvas()
        +Canvas(List~Drawable~)
        +getShapes() List~Drawable~
        +addShape(Drawable)
        +drawAll()
    }

    class AreaCalculatorService {
        +totalArea(List~Drawable~) double
    }

    class LengthCalculatorService {
        +printLengths(List~Drawable~)
    }

    class App {
        +main(String[])$
        +createTestData() List~Drawable~$
    }

    class Point {
        <<java.awt>>
        +int x
        +int y
    }

    Drawable <|.. Triangle : implements
    Drawable <|.. Rectangle : implements
    Drawable <|.. Circle : implements
    Drawable <|.. Line : implements
    Drawable <|.. Curve : implements
    CanCalculateArea <|.. Triangle : implements
    CanCalculateArea <|.. Rectangle : implements
    CanCalculateArea <|.. Circle : implements
    CanCalculateLength <|.. Line : implements
    CanCalculateLength <|.. Curve : implements
    Triangle *-- ShapeProperties : has
    Rectangle *-- ShapeProperties : has
    Circle *-- ShapeProperties : has
    Line *-- ShapeProperties : has
    Curve *-- ShapeProperties : has
    Canvas "1" o-- "0..*" Drawable : contains
    App ..> Canvas : uses
    App ..> AreaCalculatorService : uses
    App ..> LengthCalculatorService : uses
    AreaCalculatorService ..> CanCalculateArea : checks
    LengthCalculatorService ..> CanCalculateLength : checks
    Line --> Point : start
    Line --> Point : end
```

- **Drawable** — interface declaring `draw()`; the broadest abstraction. `Canvas` and `App` depend only on this (DIP).
- **ShapeProperties** — plain data class holding `color` and `transparent`. Composed into each concrete shape (composition over inheritance). Shared state without shared class hierarchy.
- **Triangle / Rectangle / Circle** — implement `Drawable` and `CanCalculateArea`; each *has a* `ShapeProperties` instead of extending an abstract class.
- **Line / Curve** — implement `Drawable` and `CanCalculateLength`; each *has a* `ShapeProperties`. No area.
- **Canvas** — holds `ArrayList<Drawable>`; single responsibility: hold and draw. No area or length logic (SRP). Accepts an optional initial list via a second constructor.
- **AreaCalculatorService** — single responsibility: sum areas from any `List<Drawable>`. Decoupled from `Canvas` (SRP). Works for any list of drawables from any source.
- **LengthCalculatorService** — single responsibility: print lengths from any `List<Drawable>`. Works for any shape implementing `CanCalculateLength`.
- **App** — orchestrates: wires canvas, services, and test data. Delegates all logic to the right class.
- **CanCalculateArea** — capability interface; implemented only by shapes that actually have area (ISP).
- **CanCalculateLength** — capability interface; implemented only by shapes that have length (ISP).
- **Point** — `java.awt.Point`; holds integer `x`/`y` coordinates used by `Line`.

---

## What is Maven?

**Apache Maven** is a build automation and project management tool for Java projects.  
It handles three main concerns for you:

| Concern | What Maven does |
|---------|----------------|
| **Build** | Compiles source code, runs tests, packages the result into a JAR/WAR |
| **Dependencies** | Downloads libraries from a central repository so you don't manage JARs manually |
| **Project structure** | Enforces a standard directory layout understood by every Maven-aware IDE and CI tool |

### Standard directory layout

```
vector-draw-app/
├── pom.xml                          ← Project Object Model (Maven config file)
└── src/
    ├── main/
    │   └── java/                    ← Production source code
    │       └── com/vectordraw/
    └── test/
        └── java/                    ← Unit test source code
            └── com/vectordraw/
```

### pom.xml — the heart of every Maven project

`pom.xml` (Project Object Model) is the single configuration file that describes the project.  
Key sections in this project's `pom.xml`:

```xml
<groupId>com.vectordraw</groupId>       <!-- Organisation / namespace -->
<artifactId>vector-draw-app</artifactId><!-- Project name -->
<version>1.0-SNAPSHOT</version>         <!-- Current version -->

<properties>
    <maven.compiler.source>17</maven.compiler.source>  <!-- Compile for Java 17 -->
    <maven.compiler.target>17</maven.compiler.target>
</properties>
```

`SNAPSHOT` means the version is still in development (not a final release).

---

## Maven build lifecycle

Maven organises work into **phases** that always run in order.  
The most important phases are:

```
validate → compile → test → package → verify → install → deploy
```

When you run a later phase, all earlier phases run automatically.  
For example, `mvn package` also runs `validate`, `compile`, and `test` first.

---

## Common Maven commands

### Compile source code
```bash
mvn compile
```
Compiles all `.java` files under `src/main/java/` into `target/classes/`.

### Run tests
```bash
mvn test
```
Compiles and runs all unit tests under `src/test/java/`.

### Package into a JAR
```bash
mvn package
```
Creates `target/vector-draw-app-1.0-SNAPSHOT.jar`.

### Clean build output
```bash
mvn clean
```
Deletes the `target/` folder (all compiled classes and JARs).

### Clean and repackage (most common full build)
```bash
mvn clean package
```

### Run the application directly with Maven
```bash
mvn compile exec:java "-Dexec.mainClass=com.vectordraw.App"
```

### Run the packaged JAR
```bash
java -jar target/vector-draw-app-1.0-SNAPSHOT.jar
```

### Skip tests during packaging (use sparingly)
```bash
mvn package -DskipTests
```

---

## Prerequisites

| Tool | Minimum version | Check with |
|------|----------------|-----------|
| JDK  | 17             | `java -version` |
| Maven | 3.8           | `mvn -version` |

---

## Quick start

```bash
# 1. Clone / open the project
cd vector-draw-app

# 2. Compile and run in one step
mvn compile exec:java "-Dexec.mainClass=com.vectordraw.App"
```

Expected output:
```
== Drawing all shapes ==
Drawing Triangle [color=red, transparent=false]
Drawing Rectangle [color=blue, transparent=false]
Drawing Circle [color=green, transparent=true]
Drawing Line [color=black, transparent=false]
Drawing Line [color=purple, transparent=false]
Drawing Line [color=orange, transparent=false]
Drawing Line [color=gray, transparent=true]
Drawing Curve [color=teal, transparent=false]
Drawing Curve [color=pink, transparent=true]

== Total area ==
Total area: 23.068583470577035

== Lengths (CanCalculateLength) ==
Line length: 14.142135623730951
Line length: 20.0
Line length: 12.0
Line length: 5.0
Curve length: 7.853981633974483
Curve length: 31.41592653589793
```
