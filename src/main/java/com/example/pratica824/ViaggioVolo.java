package com.example.pratica824;

public class ViaggioVolo extends Viaggio{
    private boolean andataRitorno;

    //Costruttore
    public ViaggioVolo(String destinazione, int durataGiorni, double costoBase, boolean andataRitorno) {
        super(destinazione, durataGiorni, costoBase);
        this.andataRitorno = andataRitorno;
    }
    public ViaggioVolo() {
        this("NON INSERITA",0,0.0,false);
    }
    public ViaggioVolo(boolean andataRitorno) {
        this("NON INSERITA",0,0.0,andataRitorno);
    }
    //Get e set
    public boolean isAndataRitorno() { return andataRitorno; }
    public String getTipoVolo() {
        if (this.andataRitorno)
            return "andata e ritorno";
        else
            return "solo andata";
    }
    public void setAndataRitorno(boolean andataRitorno) { this.andataRitorno = andataRitorno;}

    //To String e equals
    @Override
    public String toString() {
        return super.toString()+ getTipoVolo();
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof ViaggioVolo){
            ViaggioVolo r=(ViaggioVolo) object;
            return super.equals(r) && r.isAndataRitorno()==this.andataRitorno;
        }
        return false;
    }

    //Costo
    @Override
    public double getCosto(){
        if (!isAndataRitorno())
            return super.getCosto()*1.5;
        else
            return super.getCosto()*1.85;
    }
}
