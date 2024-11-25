package com.example.pratica824;

public class Viaggio {
    private String destinazione;
    private int durataGiorni;
    private double costoBase;

    //Costruttori
    public Viaggio(String destinazione, int durataGiorni, double costoBase) {
        this.destinazione = destinazione;
        this.durataGiorni = durataGiorni;
        this.costoBase = costoBase;
    }
    public Viaggio() {
        this("NON INSERITA",0,0.0);
    }
    public Viaggio(String destinazione) {
        this(destinazione,0,0.0);
    }
    public Viaggio(int durataGiorni) {
        this("NON INSERITA",durataGiorni,0.0);
    }
    public Viaggio(double costoBase) {
        this("NON INSERITA",0,costoBase);
    }

    //get set
    public String getDestinazione() { return destinazione; }
    public void setDestinazione(String destinazione) { this.destinazione = destinazione; }

    public int getDurataGiorni() { return durataGiorni; }
    public void setDurataGiorni(int durataGiorni) { this.durataGiorni = durataGiorni; }

    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }

    //To String e equals
    @Override
    public String toString() {
        return "Destinazione='" + this.destinazione + '\'' + ", durataGiorni=" + this.durataGiorni + ", costoBase=" + this.costoBase;
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof Viaggio){
            Viaggio r=(Viaggio) object;
            return r.getDestinazione().equalsIgnoreCase(this.destinazione) && this.durataGiorni == r.getDurataGiorni() && this.costoBase == r.getCostoBase();
        }
        return false;
    }

    //Costo
    public double getCosto(){
        return getCostoBase();
    }
}
