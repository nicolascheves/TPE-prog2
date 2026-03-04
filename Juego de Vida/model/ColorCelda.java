package model;

public class ColorCelda {
    private int r;
    private int g;
    private int b;

    public ColorCelda(int r, int g, int b) {
        this.r = clamp(r);
        this.g = clamp(g);
        this.b = clamp(b);
    }

    private int clamp(int v) {
        return Math.max(0, Math.min(255, v));
    }

    public int getR(){ 
        return r;
    }
    public int getG(){ 
        return g; 
    }
    public int getB(){ 
        return b;
    }
}

