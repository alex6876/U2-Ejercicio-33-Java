public class Main {
    public static void main(String[] args) {

        MotorGrafico motor;

        System.out.println("--- Motor OpenGL ---");
        motor = new RenderizadorOpenGL();
        motor.inicializarContexto();
        motor.dibujarMalla("Jugador");
        motor.dibujarMalla("Escenario");
        motor.liberarRecursos();

        System.out.println("--- Motor DirectX ---");
        motor =  new RenderizadorDirectX();
        motor.inicializarContexto();
        motor.dibujarMalla("Jugador");
        motor.dibujarMalla("Escenario");
        motor.dibujarMalla("Enemigo");
        motor.liberarRecursos();

        System.out.println("--- Motor Vulkan ---");
        motor = new RenderizadorVulkan();
        motor.inicializarContexto();
        motor.dibujarMalla("Jugador");
        motor.dibujarMalla("Escenario");
        motor.dibujarMalla("Edificios");
        motor.liberarRecursos();

    }
}