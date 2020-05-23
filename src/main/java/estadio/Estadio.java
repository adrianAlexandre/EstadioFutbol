package estadio;

import java.util.ArrayList;

public class Estadio {
    private Zona[] zonas;

    //Constructores
    public Estadio(int numZonas, int numFilas, int numAsientos, int zonasVip) {
        this.zonas = new Zona[numZonas];
        if (zonasVip > numZonas) {
            zonasVip = numZonas;
        }
        for (int i = 0; i < zonasVip; i++) {
            zonas[i] = new Zona(numFilas, numAsientos, true,i);
        }
        for (int i = zonasVip; i < numZonas; i++) {
            zonas[i] = new Zona(numFilas, numAsientos, false,i);
        }
    }

    //Getters
    public Zona[] getZonas() {
        return zonas;
    }

    //Metodos
    public Asiento getAsiento(int numZona, int numFila, int numAsiento) {
        try {
            return zonas[numZona].getFilas()[numFila].getAsientos()[numAsiento];
        } catch (NullPointerException npe) {
            System.out.println("El asiento no existe");
            return null;
        }
    }

    public Fila getFila(int numZona, int numFila) {
        try {
            return zonas[numZona].getFilas()[numFila];
        } catch (NullPointerException npe) {
            System.out.println("La fila no existe");
            return null;
        }
    }
    //Devueleve la cantidad de taquillas del estadio
    public int getNumTaquillas() {
        int taquillas = 0;
        for (Zona i:
             zonas) {
            if (i.isVip()){
                taquillas+=i.getNumButacas();
            }
        }
        return taquillas;
    }
    //Devuelve la cantidad de butacas del objeto
    public int getNumButacas() {
        int butacas = 0;
        for (Zona i :
                zonas) {
            butacas += i.getNumButacas();
        }
        return butacas;
    }
    public ArrayList<Asiento> getLocalidadesOcupadas(){
        ArrayList<Asiento> asientos=new ArrayList<>();
        int cont=1;
        for (Zona i:
                zonas) {
            System.out.println("Zona "+i.zona+"\n=================");
            for (Fila q:
                    i.getFilas()) {
                for (Asiento l:
                        q.getAsientos()) {
                    if (l.isOcupado()){
                        asientos.add(l);
                        System.out.println(cont+". "+l.toString());
                        cont++;
                    }
                }
            }
        }
        return asientos;
    }
    public ArrayList<Asiento> getLocalidadesDesocupadas(){
        ArrayList<Asiento> asientos=new ArrayList<>();
        int cont=1;
        for (Zona i:
                zonas) {
            System.out.println("Zona "+i.zona+"\n=================");
            for (Fila q:
                    i.getFilas()) {
                for (Asiento l:
                        q.getAsientos()) {
                    if (!l.isOcupado()){
                        asientos.add(l);
                        System.out.println(cont+". "+l.toString());
                        cont++;
                    }
                }
            }
        }
        return asientos;
    }
    public void muestraAsientos(){
        for (Zona i:
             zonas) {
            i.muestraAsientos();
        }
    }
}
