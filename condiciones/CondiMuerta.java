package condiciones;

import model.ColorCelda;
import model.EstadoCelda;

public  class CondiMuerta extends Condicion {
    private int reproduccionAsegurada;

    public CondiMuerta(int reproduccionAsegurada) {
        this.reproduccionAsegurada = reproduccionAsegurada; // EJEMPLO TP 2
    }

    public boolean cumple(EstadoCelda estado, int vecinosVivos) {
        return estado.getNombre().equals("muerta") && vecinosVivos != reproduccionAsegurada;
    }

    @Override 
    public EstadoCelda getEstadoSiguiente() {
        return new EstadoCelda("muerta", new ColorCelda(60, 60, 60), 'X');
    } 
}
