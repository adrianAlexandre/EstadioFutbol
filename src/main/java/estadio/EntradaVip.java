package estadio;

public class EntradaVip extends Entrada {
    private String codigoTaquilla;

    public EntradaVip(int numEntrada, Partido partido, Asiento asiento) {
        super(numEntrada, partido, partido.getEstadio().getZonas()[asiento.getZona()], partido.getEstadio().getFila(asiento.getZona(),asiento.getFila()), asiento,100);
        codigoTaquilla = partido.getContrasenaTaquilla();
    }
    }
