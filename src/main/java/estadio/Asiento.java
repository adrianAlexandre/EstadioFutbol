package estadio;

public class Asiento {
    private boolean ocupado;
    private int asiento;
    private int fila;
    private int zona;
    //Constructor

    public Asiento(int asiento,int fila,int zona){
        this.ocupado=false;
        this.asiento=asiento;
        this.fila=fila;
        this.zona=zona;
    }
    //getters

    public boolean isOcupado() {
        return ocupado;
    }

    public int getAsiento() {
        return asiento;
    }

    public int getFila() {
        return fila;
    }

    public int getZona() {
        return zona;
    }
    //Setters

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    //Métodos

    @Override
    public String toString() {
        return "Asiento{" +
                "ocupado=" + ocupado +
                ", asiento=" + asiento +
                ", fila=" + fila +
                ", zona=" + zona +
                '}';
    }
}
