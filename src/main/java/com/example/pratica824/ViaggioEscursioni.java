package com.example.pratica824;

public class ViaggioEscursioni extends ViaggioPasti{
    private int numeroEscursioni;

    //Costruttore
    public ViaggioEscursioni(String destinazione, int durataGiorni, double costoBase, boolean pensioneCompleta, int numeroEscursioni) {
        super(destinazione, durataGiorni, costoBase, pensioneCompleta);
        this.numeroEscursioni = numeroEscursioni;
    }

    public ViaggioEscursioni(int numeroEscursioni) {
        this("NON INSERITA",0,0.0,false,numeroEscursioni);
    }

    public ViaggioEscursioni(boolean pensioneCompleta, int numeroEscursioni) {
        this("NON INSERITA",0,0.0,pensioneCompleta,numeroEscursioni);
    }

    public ViaggioEscursioni(String destinazione, int durataGiorni, double costoBase, boolean pensioneCompleta) {
        this(destinazione, durataGiorni, costoBase, pensioneCompleta,0);
    }

    public ViaggioEscursioni() {
        this("NON INSERITA",0,0.0,false,0);
    }

    public ViaggioEscursioni(boolean pensioneCompleta) {
        this("NON INSERITA",0,0.0,pensioneCompleta,0);
    }
    //get e set
    public int getNumeroEscursioni() { return numeroEscursioni; }
    public void setNumeroEscursioni(int numeroEscursioni) { this.numeroEscursioni = numeroEscursioni; }

    //To String e equals
    @Override
    public String toString() {
        return super.toString()+", numero di escursioni"+this.numeroEscursioni;
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof ViaggioEscursioni){
            ViaggioEscursioni r=(ViaggioEscursioni) object;
            return super.equals(r) && r.getNumeroEscursioni()==this.numeroEscursioni;
        }
        return false;
    }

    //Costo
    @Override
    public double getCosto(){
        return super.getCosto()+(super.getCosto()*((double) (getNumeroEscursioni() * 15) /100));
    }
}
