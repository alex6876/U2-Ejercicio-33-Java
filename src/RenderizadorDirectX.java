public class RenderizadorDirectX implements MotorGrafico {

    boolean inicializado = false;

    @Override
    public void inicializarContexto() {
        if (inicializado == true) {
            System.out.println("El renderizador DirectX ya estaba inicializado");
        }else{
            inicializado = true;
            System.out.println("Renderizador DirectX inicializado");
        }

    }

    @Override
    public void dibujarMalla(String nombreMalla) {
        if(!inicializado){
            System.out.println("Error: el contexto no está inicializado.");
            return;
        }

        System.out.println("DirectX dibujando: " + nombreMalla);
    }

    @Override
    public void liberarRecursos() {
        if(!inicializado){
            System.out.println("DirectX no está inicializado.");
            return;
        }

        System.out.println("Rescursos de DirectX liberados");
        inicializado = false;
    }
}
