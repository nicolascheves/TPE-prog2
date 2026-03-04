package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public class CondEnfermedad extends Condicion {

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("enferma");
    }

    @Override
    public EstadoCelda getEstadoSiguiente() {
        return new EstadoCelda("muerta", new ColorCelda(60, 60, 60), 'X');
    }
}
