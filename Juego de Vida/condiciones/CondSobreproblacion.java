package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public class CondSobreproblacion extends Condicion {
    private int tope;

    public CondSobreproblacion(int tope) {
        this.tope = tope; //  3
    }

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("viva") && vecinosVivos > tope;
    }

    @Override
    public EstadoCelda getEstadoSiguiente() {
        return new EstadoCelda("muerta", new ColorCelda(60, 60, 60), 'X');
    }
    
}
