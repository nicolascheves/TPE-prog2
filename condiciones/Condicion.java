package condiciones;

//import modelo;
import model.EstadoCelda;

public abstract class Condicion {

    public abstract boolean cumple(EstadoCelda estado, int vecinosVivos);
    public abstract EstadoCelda getEstadoSiguiente();
}