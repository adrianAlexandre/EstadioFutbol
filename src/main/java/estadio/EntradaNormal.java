package estadio;

public class EntradaNormal extends Entrada {
    private int loteria;

    public EntradaNormal(int numEntrada, Partido partido,Asiento asiento) {
        super(numEntrada, partido, partido.getEstadio().getZonas()[asiento.getZona()], partido.getEstadio().getFila(asiento.getZona(),asiento.getFila()), asiento,50);
        loteria = partido.getNumLoteria();

    }
}
