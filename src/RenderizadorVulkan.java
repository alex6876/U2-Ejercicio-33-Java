public class RenderizadorVulkan implements MotorGrafico {


    boolean inicializado = false;

    @Override
    public void inicializarContexto() {
        if (inicializado == true) {
            System.out.println("El renderizador Vulkan ya estaba inicializado");
        }else{
            inicializado = true;
            System.out.println("Renderizador Vulkan inicializado");
        }

    }

    @Override
    public void dibujarMalla(String nombreMalla) {
        if(!inicializado){
            System.out.println("Error: el contexto no está inicializado.");
            return;
        }

        System.out.println("Vulkan dibujando: " + nombreMalla);
    }

    @Override
    public void liberarRecursos() {
        if(!inicializado){
            System.out.println("Vulkan no está inicializado.");
            return;
        }

        System.out.println("Rescursos de Vulkan liberados");
        inicializado = false;
    }
}
