package estadio;

public enum Afluencia {
    BAJA_AFLUENCIA(0.75),ALTA_AFLUENCIA(1),MEDIA_AFLUENCIA(1.30);
    private double porcentajeAfluencia;

    public double getPorcentajeAfluencia() {
        return porcentajeAfluencia;
    }

    Afluencia(double porcentajeAfluencia) {
        this.porcentajeAfluencia = porcentajeAfluencia;
    }
}
