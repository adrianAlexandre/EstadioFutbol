package estadio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Zona {
    private boolean vip;
    private Fila[] filas;
    int zona;

    //Constructores
    public Zona(int numFilas, int asientosFila, boolean vip,int zona) {
        this.filas = new Fila[numFilas];
        for (int i = 0; i < numFilas; i++){
            filas[i] = new Fila(asientosFila,i,zona);
        }
        this.vip = vip;
        this.zona=zona;
    }
    //Getters

    public Fila[] getFilas() {
        return filas;
    }

    public Boolean isVip() {
        return vip;
    }

    //Métodos
    public int getAsientosLibres() {
        int cont = 0;
        for (Fila i :
                filas) {
            for (Asiento u :
                    i.getAsientos()) {
                if (u.isOcupado()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public void muestraAsientos() {
        System.out.println("ZONA "+zona+": \n===========");
        for (Fila i :
                filas) {
            for (Asiento u :
                    i.getAsientos()) {
                if (!u.isOcupado()) {
                    System.out.printf("\u001B[36m(" + u.getFila()+"-"+u.getAsiento() + ")\u001B[0m");
                } else {
                    System.out.printf("\u001B[31m(" + u.getFila()+"-"+u.getAsiento()+ ")\u001B[0m");
                }

            }
            System.out.println("");
        }
    }
    //Devuelve la cantidad de butacas del objeto
    public int getNumButacas() {
        int butacas=0;
        for (Fila i:
             filas) {
            butacas+=i.getNumButacas();
        }
        return butacas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return vip == zona.vip &&
                Arrays.equals(filas, zona.filas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(vip);
        result = 31 * result + Arrays.hashCode(filas);
        return result;
    }
}
