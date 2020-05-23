package estadio;

import util.ErrorMessage;
import util.Lib;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private VentaEntradas ventaEntradas;
    public static void main(String[] args) {
        VentaEntradas ventaEntradas = new VentaEntradas();
        Scanner read = new Scanner(System.in);
        int opcion = -1;
        do {
            do {
                mostrarMenuPrincipal();
                try {
                    opcion = read.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                } finally {
                    read.nextLine();
                }
            } while (opcion < 0 || opcion > 2);
            switch (opcion) {
                case 1:
                    nuevoPartido(ventaEntradas);
                    break;
                case 2:
                    int indicePartido = -2;
                    Lib.limpiaPantalla();
                    System.out.println("Que partido quiere reservar?");
                    ArrayList<Partido> partidos;
                    partidos = ventaEntradas.muestraPartidosPendientes();
                    if (partidos != null) {
                        do {
                            try {
                                indicePartido = read.nextInt() - 1;
                            } catch (InputMismatchException ime) {
                                System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                            } finally {
                                read.nextLine();
                            }
                        } while (indicePartido < -1 || indicePartido > partidos.size());
                        if (indicePartido >= 0 && indicePartido < partidos.size()) {
                            Partido partidoReservar = partidos.get(indicePartido);
                            opcion = -1;
                            do {
                                mostrarMenuGestionEntradas();
                                try {
                                    opcion = read.nextInt();
                                } catch (InputMismatchException ime) {
                                    System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                                } finally {
                                    read.nextLine();
                                }
                            } while (opcion < 0 || opcion > 5);
                            switch (opcion) {
                                case 1:
                                    partidoReservar.getEstadio().muestraAsientos();
                                    int zona = -1;
                                    do {
                                        System.out.println("Zona:");
                                        try {
                                            zona = read.nextInt();
                                        } catch (InputMismatchException ime) {
                                            System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                                        } finally {
                                            read.nextLine();
                                        }
                                    } while (zona < 0 || zona >= partidoReservar.getEstadio().getZonas().length);
                                    int fila = -1;

                                    do {
                                        System.out.println("Fila:");
                                        try {
                                            fila = read.nextInt();
                                        } catch (InputMismatchException ime) {
                                            System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                                        } finally {
                                            read.nextLine();
                                        }
                                    } while (fila < 0 || fila >= partidoReservar.getEstadio().getZonas()[zona].getFilas().length);
                                    int butaca = -1;
                                    do {
                                        System.out.println("Butaca:");
                                        try {
                                            butaca = read.nextInt();
                                        } catch (InputMismatchException ime) {
                                            System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                                        } finally {
                                            read.nextLine();
                                        }
                                    } while (butaca < 0 || butaca >= partidoReservar.getEstadio().getZonas()[zona].getFilas()[fila].getAsientos().length);
                                    ventaEntradas.venderEntrada(partidoReservar, partidoReservar.getEstadio().getAsiento(zona, fila, butaca));
                                    break;
                                case 2:
                                    System.out.println("Introduzca el id de la entrada");
                                    int idEntrada = -1;
                                    try {
                                        idEntrada = read.nextInt();
                                    } catch (InputMismatchException ime) {
                                        System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
                                    } finally {
                                        read.nextLine();
                                    }
                                    ventaEntradas.devolverEntrada(idEntrada);
                                    break;
                                case 3:
                                    System.out.println("Localidades Ocupadas\n=====================");
                                    ArrayList<Asiento> asientos = new ArrayList<>();
                                    asientos = partidoReservar.getEstadio().getLocalidadesOcupadas();
                                    break;
                                case 4:
                                    System.out.println("Localidades Libres\n=====================");
                                    asientos = partidoReservar.getEstadio().getLocalidadesDesocupadas();
                                    break;
                                case 5:
                                    System.out.println("Dinero recaudado");
                                    System.out.println(ventaEntradas.getRecaudacion(partidoReservar));
                                    break;
                            }
                            opcion = -1;
                            break;
                        }
                    }
            }
        } while (opcion != 0);

    }

    public static void mostrarMenuPrincipal() {
        System.out.println("=============\n" +
                "MENU\n" +
                "=============\n" +
                "1.NUEVO PARTIDO\n" +
                "2.GESTIÓN DE ENTRADAS\n" +
                "==============\n" +
                "0.SALIR");
    }

    public static void mostrarMenuGestionEntradas() {
        System.out.println("1. Venta de entradas\n" +
                "2. Devolver una entrada\n" +
                "3. Listado de localidades ocupadas\n" +
                "4. Listado de localidades libres\n" +
                "5. Mostrar recaudación del partido\n" +
                "0. Volver al menú principal");
    }

    public static void nuevoPartido(VentaEntradas ventaEntradas) {
        Scanner read = new Scanner(System.in);
        GregorianCalendar fecha;
        Afluencia afluencia = Afluencia.BAJA_AFLUENCIA;
        String equipoLocal;
        String equipoVisitante;
        String fechaString;
        int opcion;

        System.out.println("Nuevo Partido\n---------------");
        do {
            System.out.println("Fecha(dd/mm/aaaa):");
            fechaString = read.nextLine();
            fecha = Lib.getFecha(fechaString);
        } while (fecha == null);

        do {
            opcion = -1;
            System.out.println("Afluencia:\n1.Baja Afluencia\n2.Media Afluencia\n3.Alta Afluencia");
            try {
                opcion = read.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println(ErrorMessage.OPTION_OUT_OF_BOUNDS_ERROR);
            } finally {
                read.nextLine();
            }

        } while (opcion > 3 || opcion < 1);
        switch (opcion) {
            case 1:
                afluencia = Afluencia.BAJA_AFLUENCIA;
                break;
            case 2:
                afluencia = Afluencia.MEDIA_AFLUENCIA;
                break;
            case 3:
                afluencia = Afluencia.ALTA_AFLUENCIA;
                break;
        }
        System.out.println("Equipo Local:");
        equipoLocal = read.nextLine();
        System.out.println("Equipo Visitante:");
        equipoVisitante = read.nextLine();
        ventaEntradas.anadirPartido(new Partido(afluencia, equipoLocal, equipoVisitante, fecha));
    }
}
