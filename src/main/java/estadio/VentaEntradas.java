package estadio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class VentaEntradas {
    private HistoricoPartidos historicoPartidos;
    private int ultimaEntrada;
    private ArrayList<Entrada> entradas;

    public void muestraAsientos(Partido partido) {
        partido.getEstadio().muestraAsientos();
    }

    public VentaEntradas() {
        historicoPartidos=new HistoricoPartidos();
        ultimaEntrada=0;
        entradas=new ArrayList<>();
        historicoPartidos.anadirPartido(new Partido(Afluencia.MEDIA_AFLUENCIA,"Denia","Valencia",new GregorianCalendar(2021,04,01)));
    }

    public ArrayList<Partido> muestraPartidosPendientes() {
        ArrayList<Partido> partidosPendientes = new ArrayList<>();
        partidosPendientes.sort(new ComparatorFechaPartido<>());
        try {
            partidosPendientes = this.historicoPartidos.getPartidosPendientes();
            for (int i = 1; i == partidosPendientes.size(); i++) {
                System.out.println(i + ". " + partidosPendientes.get(i - 1).toString());
            }
        } catch (NullPointerException npe) {
            System.out.println("Error el histórico de partidos está vacio");
        }

        return partidosPendientes;
    }

    public void anadirPartido(Partido partido) {
        this.historicoPartidos.anadirPartido(partido);
    }

    public void venderEntrada(Partido partido,Asiento asiento){
        if (asiento!=null){
            if (!asiento.isOcupado()){
                asiento.setOcupado(true);
                if (partido.getEstadio().getZonas()[asiento.getZona()].isVip()){
                    EntradaVip entradaVip=new EntradaVip(ultimaEntrada+1,partido,asiento);
                    ultimaEntrada++;
                    entradas.add(entradaVip);
                    System.out.println(entradaVip.toString());
                }else {
                    EntradaNormal entradaNormal=new EntradaNormal(ultimaEntrada+1,partido,asiento);
                    ultimaEntrada++;
                    entradas.add(entradaNormal);
                    System.out.println(entradaNormal.toString());
                }

            }else {
                System.out.println("asiento ocupado");
            }
        }else {
            System.out.println("asiento no existe");
        }
    }
    public void devolverEntrada(int idEntrada){
        for (Entrada i:
             entradas) {
            if (i.getNumEntrada()==idEntrada){
                if (i.getPartido().getFecha().after(new GregorianCalendar())){
                    i.getAsiento().setOcupado(false);
                    entradas.remove(i);
                }else{
                    System.out.println("La entrada no se puede devolver porque ya se ha realizado el partido");
                }
            }
        }
    }
    public double getRecaudacion(Partido partido){
        double recaudacion=0;
        for (Entrada i:
             entradas) {
            if (i.getPartido().equals(partido)){
                recaudacion+=i.getPrecio();
            }
        }
        return recaudacion;
    }


}
