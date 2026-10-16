public class RenderizadorOpenGL implements MotorGrafico {

    boolean inicializado = false;

    @Override
    public void inicializarContexto() {
        if (inicializado == true) {
            System.out.println("El renderizador OpenGL ya estaba inicializado");
        }else{
            inicializado = true;
            System.out.println("RenderizadorOpenGL inicializado");
        }

    }

    @Override
    public void dibujarMalla(String nombreMalla) {
        if(!inicializado){
            System.out.println("Error: el contexto no está inicializado.");
            return;
        }

        System.out.println("OpenGL dibujando: " + nombreMalla);
    }

    @Override
    public void liberarRecursos() {
        if(!inicializado){
            System.out.println("OpenGL no está inicializado.");
            return;
        }

        System.out.println("Rescursos de OpenGL liberados");
        inicializado = false;
    }
}
