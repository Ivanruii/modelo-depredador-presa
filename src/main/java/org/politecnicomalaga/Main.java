package org.politecnicomalaga;

import org.politecnicomalaga.model.Dato;

import java.util.Scanner;

public class Main {
    private final float porcentajeNatalidadDepredador;
    private final float porcentajeNatalidadPresa;
    private final float porcentajeMortalidadDepredador;
    private final float porcentajeMortalidadPresa;
    private final float porcentajeIndiceCazaPresa;
    private final float porcentajeIndiceAlimentacion;
    private final long maximoPresasEcosistema;
    private final int tiempoInicial;
    private final int depredadorInicial;
    private final int presaInicial;
    private final int cantidadTiempoDeSimulacion;

    public Main() {
        this.porcentajeNatalidadDepredador = leerNumFloat("Inserta el porcentaje de natalidad depredador: ");
        this.porcentajeNatalidadPresa = leerNumFloat("Inserta el porcentaje de natalidad presa: ");
        this.porcentajeMortalidadDepredador = leerNumFloat("Inserta el porcentaje de mortalidad depredador: ");
        this.porcentajeMortalidadPresa = leerNumFloat("Inserta el porcentaje de mortalidad presa: ");
        this.porcentajeIndiceCazaPresa = leerNumFloat("Inserta el porcentaje de índice de caza de la presa: ");
        this.porcentajeIndiceAlimentacion = leerNumFloat("Inserta el porcentaje de índice de alimentación: ");
        this.maximoPresasEcosistema = leerNumLong("Inserta el máximo de presas del ecosistema: ");
        this.tiempoInicial = leerNumInt("Inserta el año inicial: ");
        this.depredadorInicial = leerNumInt("Insertar número de depredador inicial: ");
        this.presaInicial = leerNumInt("Insertar número de presa inicial: ");
        // Comprobación para evitar errores en los array.
        int tempCantidadTiempoSimulacion;
        do {
            tempCantidadTiempoSimulacion = leerNumInt("Inserta el número de años que quieres realizar la simulación (debe de ser mayor a 0): ");
        } while (tempCantidadTiempoSimulacion <= 0);
        this.cantidadTiempoDeSimulacion = tempCantidadTiempoSimulacion;
    }

    // Creación de instancia de Main y ejecución inicial del programa

    public static void main(String[] args) {
        Main main = new Main();
        main.inicializarPrograma();
    }

    // Inicialización del programa

    public void inicializarPrograma () {
        // TODO: Dividir la inicialización del programa
        Dato datosIniciales = new Dato(
                this.tiempoInicial,
                this.depredadorInicial,
                this.presaInicial,
                this.porcentajeNatalidadDepredador,
                this.porcentajeMortalidadDepredador,
                this.porcentajeNatalidadPresa,
                this.porcentajeMortalidadPresa,
                this.porcentajeIndiceCazaPresa,
                this.porcentajeIndiceAlimentacion,
                this.maximoPresasEcosistema
        );

        Dato[] listaDatos = new Dato[this.getCantidadTiempoDeSimulacion()];
        listaDatos[0] = datosIniciales;
        Dato datoAnterior = listaDatos[0];

        for (int i = 1; i < listaDatos.length; i++) {
            listaDatos[i] = calcularNuevoDato(datoAnterior);
            datoAnterior = listaDatos[i];
        }

        for (Dato dato : listaDatos) {
            System.out.println(
                "\nTiempo: " + dato.getTiempo() + ", " +
                "Depredador: " + dato.getDepredador() + ", " +
                "Presa: " + dato.getPresa() + ", " +
                "Natalidad depredador: " + dato.getDepredadorNatalidad() + ", " +
                "Moratalida depredador: " + dato.getDepredadorMortalidad() + ", " +
                "Presa natalidad: " + dato.getPresaNatalidad() + ", " +
                "Presa mortalidad: " + dato.getPresaMoratilidadNatural() + ", " +
                "Presa cazada: " + dato.getPresaCazada() + ", " +
                "Depredador hambriento " + dato.getDepredadorHambriento() + ", " +
                "Diff depredador: " + dato.getDiffDepredador() + ", " +
                "Diff presa: " + dato.getDiffPresa() + ".\n"
            );
        }
    }

    // I/O: Funciones Scanner

    public static float leerNumFloat(String sMensaje) {
        System.out.print(sMensaje);
        return (new Scanner(System.in)).nextFloat();
    }

    public static long leerNumLong(String sMensaje) {
        System.out.print(sMensaje);
        return (new Scanner(System.in)).nextLong();
    }

    public static int leerNumInt(String sMensaje) {
        System.out.print(sMensaje);
        return (new Scanner(System.in)).nextInt();
    }

    public int getCantidadTiempoDeSimulacion() {
        return cantidadTiempoDeSimulacion;
    }

    // Metodos de negocio

    public Dato calcularNuevoDato(Dato datoAnterior) {
        return new Dato(
                datoAnterior.getTiempo() + 1,
                datoAnterior.getDepredador() + datoAnterior.getDiffDepredador(),
                datoAnterior.getPresa() + datoAnterior.getDiffPresa(),
                this.porcentajeNatalidadDepredador,
                this.porcentajeMortalidadDepredador,
                this.porcentajeNatalidadPresa,
                this.porcentajeMortalidadPresa,
                this.porcentajeIndiceCazaPresa,
                this.porcentajeIndiceAlimentacion,
                this.maximoPresasEcosistema
        );
    }
}
