package estadio;

import java.util.ArrayList;

public class Fila {
    private Asiento[] asientos;
    private int fila;
    private int zona;

    //Constructor
    public Fila(int numAsientos,int fila,int zona) {
        this.asientos = new Asiento[numAsientos];
            for (int i = 0; i < asientos.length; i++) {
                asientos[i] = new Asiento(i,fila,zona);
            }
        this.fila=fila;
            this.zona=zona;
    }
    //Getters

    public Asiento[] getAsientos() {
        return asientos;
    }
    //Metodos
    //Devuelve la cantidad de butacas del objeto
    public int getNumButacas() {
        return this.asientos.length;
    }

}
