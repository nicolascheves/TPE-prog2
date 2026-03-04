package model;

import java.util.ArrayList;

import condiciones.Condicion;

public class Tabla {
    int filas;
    int columnas ;
    Celda[][] celdas;

    // POSIBLES ESTADOS DE LAS CELDAS & condiciones de cambio de estado.
    private ArrayList<EstadoCelda> estados;
    private ArrayList<Condicion> condiciones; 

    public Tabla(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[filas][columnas];
        this.estados = new ArrayList<EstadoCelda>();
        this.condiciones = new ArrayList<Condicion>();
    }
   
    public void addEstado(EstadoCelda estado) {
        this.estados.add(estado);
    }

    // debe crearse una nueva matriz
    public Celda[][] nextGen() {

        Celda[][] nuevaTabla = this.celdas;
        nuevaTabla = calcularSiguienteGeneracion();
        return nuevaTabla;
    }

    public Celda[][] calcularSiguienteGeneracion() {

        Celda[][] nuevaTabla = new Celda[filas][columnas];
        int cambios = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                EstadoCelda nuevoEstado = evaluarNuevoEstado(i, j);
                Celda aux = new Celda(nuevoEstado);
                nuevaTabla[i][j] = aux;                               

                if (!nuevoEstado.equals(celdas[i][j].getEstado())) {   
                    cambios++;
                }
            }
        }

        if (cambios == 0) {
            return celdas;        
        } else {
            return nuevaTabla;   
        }
    }

    private EstadoCelda evaluarNuevoEstado(int fila, int col) {

        // color verde
        EstadoCelda vivo = new EstadoCelda("vivo", new ColorCelda(0, 200, 0), '.');
        EstadoCelda estadoActual = celdas[fila][col].getEstado();

        int vecinosVivos = contarVecinosConEstado( fila, col, vivo); 

        for (Condicion condicion : condiciones) {
            if (condicion.cumple(estadoActual, vecinosVivos)) {
                return condicion.getEstadoSiguiente();
            }
        }
        return estadoActual;
    }

    public int contarVecinosConEstado(int fila, int col, EstadoCelda estadoBuscado) {

        int contador = 0;

        for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {

                // Saltar la celda actual
                if (i == 0 && j == 0) continue;

                int nuevaFila = fila + i; 
                int nuevaCol = col + j;

                // Verificar que esté dentro de la matriz
                if (nuevaFila >= 0 && nuevaFila < filas && nuevaCol >= 0 && nuevaCol < columnas) {

                    EstadoCelda estadoVecino = celdas[nuevaFila][nuevaCol].getEstado();

                    if (estadoVecino.equals(estadoBuscado)) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public void cargarDesdeArchivo(ArrayList<String> lineas) {

        this.filas = lineas.size();
        this.columnas = lineas.get(0).length();

        this.celdas = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                char simbolo = lineas.get(i).charAt(j); 

                EstadoCelda estado = identificarPorChar(simbolo, this.estados);

                // a revisar
                celdas[i][j] = new Celda(estado);
            }
        }
    }

    private EstadoCelda identificarPorChar(char c, ArrayList<EstadoCelda> estados) {
        for (EstadoCelda e : estados) {
            if (e.getRepresentacion() == c) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado no reconocido: " + c); 
    }

    public void setCelda(int fila, int col, EstadoCelda estado) {
        celdas[fila][col].setEstado(estado);
    }

    public int getFilas() { 
        return filas; 
    }

    public int getColumnas() { 
        return columnas; 
    }
   
    public Celda[][] getCopiaTabla() { 
        
        Celda[][] copiaTabla = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                copiaTabla[i][j] = this.celdas[i][j];
            }
        }
        return copiaTabla; 
    }    
}

