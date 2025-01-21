package org.politecnicomalaga.model;

public class Dato {
    private int tiempo;
    private int depredador;
    private int presa;
    private int depredadorNatalidad;
    private int depredadorMortalidad;
    private int presaNatalidad;
    private int presaMoratilidadNatural;
    private int presaCazada;
    private int depredadorHambriento;
    private int diffDepredador;
    private int diffPresa;

    public Dato(int tiempo, int depredador, int presa, float porcentajeNatalidadDepredador, float porcentajeMortalidadDepredador, float porcentajeNatalidadPresa, float porcentajeMortalidadPresa, float porcentajeIndiceCazaPresa, float porcentajeIndiceAlimentacion, int maximoPresasEcosistema) {
        this.tiempo = tiempo;

        this.depredador = depredador;
        this.presa = presa;

        this.presaNatalidad = (int) (presa * porcentajeNatalidadPresa / 100);
        this.presaMoratilidadNatural = (int) (presa * (((porcentajeMortalidadPresa / 100) + presa ) / maximoPresasEcosistema));
        this.presaCazada = (int) (presa * depredador * porcentajeIndiceCazaPresa / 100);

        this.depredadorNatalidad = (int) (depredador * porcentajeNatalidadDepredador / 100);
        this.depredadorMortalidad = (int) (depredador * porcentajeMortalidadDepredador / 100);

        this.depredadorHambriento = (int) (Math.max((this.depredador - this.presaCazada * porcentajeIndiceAlimentacion / 100), 0));

        this.diffDepredador = this.depredadorNatalidad - this.depredadorMortalidad - this.depredadorHambriento;
        this.diffPresa = this.presaNatalidad - this.presaMoratilidadNatural - this.presaCazada;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getDepredador() {
        return depredador;
    }

    public void setDepredador(int depredador) {
        this.depredador = depredador;
    }

    public int getPresa() {
        return presa;
    }

    public void setPresa(int presa) {
        this.presa = presa;
    }

    public int getDepredadorNatalidad() {
        return depredadorNatalidad;
    }

    public void setDepredadorNatalidad(int depredadorNatalidad) {
        this.depredadorNatalidad = depredadorNatalidad;
    }

    public int getDepredadorMortalidad() {
        return depredadorMortalidad;
    }

    public void setDepredadorMortalidad(int depredadorMortalidad) {
        this.depredadorMortalidad = depredadorMortalidad;
    }

    public int getPresaNatalidad() {
        return presaNatalidad;
    }

    public void setPresaNatalidad(int presaNatalidad) {
        this.presaNatalidad = presaNatalidad;
    }

    public int getPresaMoratilidadNatural() {
        return presaMoratilidadNatural;
    }

    public void setPresaMoratilidadNatural(int presaMoratilidadNatural) {
        this.presaMoratilidadNatural = presaMoratilidadNatural;
    }

    public int getPresaCazada() {
        return presaCazada;
    }

    public void setPresaCazada(int presaCazada) {
        this.presaCazada = presaCazada;
    }

    public int getDepredadorHambriento() {
        return depredadorHambriento;
    }

    public void setDepredadorHambriento(int depredadorHambriento) {
        this.depredadorHambriento = depredadorHambriento;
    }

    public int getDiffDepredador() {
        return diffDepredador;
    }

    public void setDiffDepredador(int diffDepredador) {
        this.diffDepredador = diffDepredador;
    }

    public int getDiffPresa() {
        return diffPresa;
    }

    public void setDiffPresa(int diffPresa) {
        this.diffPresa = diffPresa;
    }
}
