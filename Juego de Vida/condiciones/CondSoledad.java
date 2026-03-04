package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public class CondSoledad extends Condicion {
    private int minimo;

    public CondSoledad(int minimo) {
        this.minimo = minimo; // EJEMPLO TP 2
    }

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("viva") && vecinosVivos < minimo;
    }

    @Override
    public EstadoCelda getEstadoSiguiente() {
        return new EstadoCelda("muerta", new ColorCelda(60, 60,60), 'X');
    }
}
