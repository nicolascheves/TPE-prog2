package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public class CondViva extends Condicion {

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("viva") && estado.getRepresentacion()== '.';
    }

    public EstadoCelda getEstadoSiguiente() {
        if (Math.random() < 0.25) {
            return new EstadoCelda("enferma", new ColorCelda(200, 0, 0), '.');
        } else return new EstadoCelda("viva", new ColorCelda(0, 200, 0), '.');
    }

}
