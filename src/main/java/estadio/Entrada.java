package estadio;

import java.util.Objects;

public abstract class Entrada {
    private double precioBase;
    private int numEntrada;
    private Partido partido;
    private Zona zona;
    private Fila fila;
    private Asiento asiento;
    private double precio;

    //Constructores

    public Entrada(int numEntrada, Partido partido, Zona zona, Fila fila, Asiento asiento,double precioBase) {
        this.numEntrada = numEntrada;
        this.partido = partido;
        this.zona = zona;
        this.fila = fila;
        this.asiento = asiento;
        precio=precioBase*partido.getAfluencia().getPorcentajeAfluencia();
    }

    //Getters

    public int getNumEntrada() {
        return numEntrada;
    }

    public Partido getPartido() {
        return partido;
    }

    public Zona getZona() {
        return zona;
    }

    public Fila getFila() {
        return fila;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecio() {
        return precio;
    }
    //Setters

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setNumEntrada(int numEntrada) {
        this.numEntrada = numEntrada;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //Metodos


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return numEntrada == entrada.numEntrada &&
                Objects.equals(partido, entrada.partido) &&
                Objects.equals(zona, entrada.zona) &&
                Objects.equals(fila, entrada.fila) &&
                Objects.equals(asiento, entrada.asiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEntrada, partido, zona, fila, asiento);
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "numEntrada=" + numEntrada +
                ", partido=" + partido +
                ", zona=" + asiento.getZona() +
                ", fila=" + asiento.getFila() +
                ", asiento=" + asiento.getAsiento() +
                ", precio=" + precio +
                '}';
    }
}
