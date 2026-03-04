package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public class CondReproduccion extends Condicion{
    private int reproduccionAsegurada;

    public CondReproduccion(int vecinosVivos, int reproduccionAsegurada) {
        this.reproduccionAsegurada = reproduccionAsegurada;     //  Ejemplo  3
    }

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("muerta") && vecinosVivos == reproduccionAsegurada; 
    }

    @Override
    public EstadoCelda getEstadoSiguiente() {
        return new EstadoCelda("viva", new ColorCelda(0, 200, 0), '.');
    }
}
