# Reto 7

**Arquitectura, estilo MVC (Model-View-Controller) con paquete Command:**
El proyecto está diseñado para separar la estructura del "mapa" de las reglas de simulación física. En el paquete **model**, la clase `Manifold` maneja la matriz de datos, detecta el punto de partida 'S' y se encarga de la protección ante desbordamientos de límites. En el paquete **view**, `ConsoleResultPrinter` se encarga de la salida por consola. En **controller**, `ManifoldController` organiza el flujo: carga el mapa y selecciona la simulación adecuada (división de rayos o líneas temporales).

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Alta cohesión en las clases. `FileInputReader` abstrae la complejidad de I/O, `Manifold` actúa como una estructura de datos inteligente (sabe qué hay en cada coordenada pero no qué hacer con ello), y las implementaciones de `ManifoldSimulation` contienen exclusivamente la lógica algorítmica.
* **Inversión de Dependencias (DIP):** El controlador y el main dependen de abstracciones (`InputReader`, `ResultPrinter`, `ManifoldSimulation`), lo que permite intercambiar implementaciones sin afectar al núcleo de la aplicación.
* **Abierto-Cerrado (OCP):** El sistema está abierto a la extensión. Si se introduce un nuevo elemento en el mapa, se puede crear una nueva clase sin modificar la clase `Manifold` ni las simulaciones existentes.

**Extras:**
* **Paquete Command:** Encapsulado en la interfaz `ManifoldSimulation`, permite ejecutar algoritmos de "División de Rayos" y "Caminos Cuánticos" de manera intercambiable.
* **Programación Dinámica (Parte 2):** Uso de `Map<Integer, Long>` en `QuantumPathSimulation` para contar eficientemente las líneas temporales fusionando resultados (`Map.merge`), evitando la explosión combinatoria.
* **Streams y FlatMap:** Uso de `activeBeams.stream().flatMap(...)` en la Parte 1 para modelar de forma declarativa cómo un solo rayo se divide en múltiples trayectorias.
