package model;

public class Celda {

    private EstadoCelda estado;

    public Celda(EstadoCelda estado) {
        this.estado = estado;
    }

    public void setEstado(EstadoCelda estado) {
        this.estado = estado;
    }

    public EstadoCelda getEstado() {
        return estado;
    }

    public ColorCelda getColor() {
        return estado.getColor();
    }

    public char getRepresentacion() {
        return estado.getRepresentacion();
    }    
    public String getNombre() {
        return estado.getNombre();
    }

    public boolean isViva(){
        return this.estado.getNombre().equals("Viva");
    }
}


