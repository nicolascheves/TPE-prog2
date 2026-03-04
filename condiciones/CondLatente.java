package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public class CondLatente extends Condicion {
    int auxiliadores;

    public CondLatente(int auxiliadores) {
        this.auxiliadores = auxiliadores; // EJEMPLO 1
    }

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("muerta") && vecinosVivos == auxiliadores; 
    }

    @Override
    public EstadoCelda getEstadoSiguiente() {
         return new EstadoCelda("viva", new ColorCelda(0, 200, 0), '.');
    }
}
