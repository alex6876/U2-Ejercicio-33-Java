# 🎮 Simulación de Motores Gráficos y Renderizado (Interfaces y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema flexible de renderizado 3D capaz de interactuar con diferentes APIs gráficas (OpenGL, DirectX y Vulkan). Pone en práctica conceptos avanzados de la **Programación Orientada a Objetos (POO)** como **interfaces**, **polimorfismo en tiempo de ejecución**, **enlace dinámico (*dynamic dispatch*)** y control de estados de ciclo de vida en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza mediante un contrato común estricto y múltiples implementaciones especializadas para cada tecnología de renderizado:

*   **`MotorGrafico` (Interfaz)**: Define el contrato contractual que todo motor de renderizado debe cumplir mediante los métodos `inicializarContexto()`, `dibujarMalla(String nombreMalla)` y `liberarRecursos()`.
*   **`RenderizadorOpenGL`**: Modela el motor gráfico basado en la especificación OpenGL. Utiliza un indicador interno (`boolean inicializado`) para controlar el estado de la sesión.
*   **`RenderizadorDirectX`**: Modela el motor gráfico basado en la API DirectX de Microsoft, manteniendo una estructura homóloga de control de contexto.
*   **`RenderizadorVulkan`**: Modela el motor gráfico de bajo nivel basado en Vulkan.
*   **`Main`**: Punto de entrada de la aplicación. Utiliza una única variable polimórfica de tipo `MotorGrafico` para instanciar secuencialmente los distintos motores, inicializar contextos, renderizar múltiples mallas geométricas (jugadores, escenarios, enemigos, edificios) y liberar los recursos de forma unificada.

---

## ⚙️ Reglas de Negocio y Control de Estado

1. **Gestión Defensiva del Ciclo de Vida:** Cada renderizador evalúa de manera interna si el contexto ya se encuentra activo antes de inicializarlo, evitando aperturas duplicadas.
2. **Validación Operativa Previa al Dibujo:** Los métodos encargados de renderizar mallas (`dibujarMalla`) y liberar recursos verifican obligatoriamente que el motor esté inicializado (`!inicializado`). Si se intenta dibujar sin un contexto activo, el sistema intercepta la acción, emite un mensaje de error y retorna el flujo de manera segura.
3. **Liberación de Recursos:** Al cerrar el ciclo de un motor, la bandera de estado se restablece a `false` (`inicializado = false`), garantizando una gestión limpia en memoria.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
--- Motor OpenGL ---
RenderizadorOpenGL initialized
OpenGL dibujando: Jugador
OpenGL dibujando: Escenario
Rescursos de OpenGL liberados
--- Motor DirectX ---
Renderizador DirectX initialized
DirectX dibujando: Jugador
DirectX dibujando: Escenario
DirectX dibujando: Enemigo
Rescursos de DirectX liberados
--- Motor Vulkan ---
Renderizador Vulkan initialized
Vulkan dibujando: Jugador
Vulkan dibujando: Escenario
Vulkan dibujando: Edificios
Rescursos de Vulkan liberados
