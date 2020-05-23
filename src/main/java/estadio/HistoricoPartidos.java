package estadio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class HistoricoPartidos {
    private ArrayList<Partido> partidos;

    //Constructores


    public HistoricoPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public HistoricoPartidos() {
        this.partidos=new ArrayList<>();
    }

    //Getters
    public Partido getPartido(GregorianCalendar fecha, String equipoLocal, String equipoVisitante) {
        for (Partido i :
                partidos) {
            if (i.getEquipoLocal() == equipoLocal && fecha == i.getFecha() && equipoVisitante == i.getEquipoVisitante()) {
                return i;
            }
        }
        return null;
    }
    //Metodos
    public ArrayList<Partido> getPartido(GregorianCalendar fecha) {
        ArrayList<Partido> partidos = new ArrayList<>();
        for (Partido i :
                partidos) {
            if (i.getFecha().equals(fecha)) {
                partidos.add(i);
            }
        }
        return partidos;
    }

    public void mostrarPartidos() {
        ComparatorFechaPartido comparatorFechaPartido = new ComparatorFechaPartido<>();
        partidos.sort(comparatorFechaPartido);
        int cont = 1;
        for (Partido i :
                partidos) {
            System.out.println(cont + ". " + i.toString());
            cont++;
        }
    }

    public ArrayList<Partido> getPartidosPendientes(){
        ArrayList<Partido> partidosPendientes=new ArrayList<>();
        for (Partido i:
             partidos) {
            if (i.getFecha().after(new GregorianCalendar())||i.getFecha().equals(new GregorianCalendar())){
                partidosPendientes.add(i);
            }
        }
    return partidosPendientes;
    }
    public void anadirPartido(Partido partido){
        this.partidos.add(partido);
    }

}
