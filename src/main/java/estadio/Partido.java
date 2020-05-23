package estadio;

import util.Lib;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Partido {
    private Estadio estadio;
    private Afluencia afluencia;
    private String equipoLocal;
    private String equipoVisitante;
    private GregorianCalendar fecha;
    private Bombo<String> contrasenasTaquillas;
    private Bombo<Integer> loteria;

    //Constructor
    public Partido(Afluencia afluencia, String equipoLocal, String equipoVisitante, GregorianCalendar fecha) {
        this.afluencia = afluencia;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estadio = new Estadio(5, 5, 5, 2);
        this.loteria = new Bombo<>();
        this.contrasenasTaquillas = new Bombo<>();
        llenaBomboContrasenas();
        llenarBomboLoteria();
    }
    //Getters

    public Afluencia getAfluencia() {
        return afluencia;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public Estadio getEstadio() {
        return estadio;
    }
    //Metodos


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(estadio, partido.estadio) &&
                afluencia == partido.afluencia &&
                Objects.equals(equipoLocal, partido.equipoLocal) &&
                Objects.equals(equipoVisitante, partido.equipoVisitante) &&
                Objects.equals(fecha, partido.fecha) &&
                Objects.equals(contrasenasTaquillas, partido.contrasenasTaquillas) &&
                Objects.equals(loteria, partido.loteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadio, afluencia, equipoLocal, equipoVisitante, fecha, contrasenasTaquillas, loteria);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "fecha=" + Lib.fechaAString(fecha) +
                ", afluencia=" + afluencia +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisitante='" + equipoVisitante + '\'' +
                '}';
    }

    public void llenaBomboContrasenas() {
        String contrasena;
        boolean correcto = false;
        for (int i = 0; i < estadio.getNumTaquillas(); i++) {
            do {
                contrasena = Lib.randomizeAlphanumericString(10);
                if (!contrasenasTaquillas.contiene(contrasena)) {
                    correcto = true;
                    contrasenasTaquillas.anadir(contrasena);
                }
            } while (correcto = false);
            correcto = false;
        }
    }

    public void llenarBomboLoteria() {
        for (int i = 0; i < this.estadio.getNumButacas(); i++) {
            loteria.anadir(i);
        }
    }

    public int getNumLoteria() {
        return loteria.giraBombo();
    }

    public String getContrasenaTaquilla() {
        return contrasenasTaquillas.giraBombo();
    }


}
