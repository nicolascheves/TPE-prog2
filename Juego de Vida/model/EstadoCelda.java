package model;

public class EstadoCelda {

    private String nombre;
    private ColorCelda color;
    private char representacion;
    
    public EstadoCelda(String nombre, ColorCelda color, char representacion) {
        this.nombre = nombre;
        this.color = color;
        this.representacion = representacion;
    }

    public String getNombre() {
        return nombre;
    }
    public ColorCelda getColor() {
        return color;
    }
    public char getRepresentacion() {
        return representacion;
    }

    @Override
    public boolean equals(Object obj) {
        EstadoCelda otro = (EstadoCelda) obj;
        return this.nombre.equals(otro.getNombre());
    }
}

