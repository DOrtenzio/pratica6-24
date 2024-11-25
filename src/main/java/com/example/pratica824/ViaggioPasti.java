package com.example.pratica824;

public class ViaggioPasti extends Viaggio{
    private boolean pensioneCompleta;

    //Costruttore
    public ViaggioPasti(String destinazione, int durataGiorni, double costoBase, boolean pensioneCompleta) {
        super(destinazione, durataGiorni, costoBase);
        this.pensioneCompleta = pensioneCompleta;
    }
    public ViaggioPasti() {
        this("NON INSERITA",0,0.0,false);
    }
    public ViaggioPasti(boolean pensioneCompleta) {
        this("NON INSERITA",0,0.0,pensioneCompleta);
    }

    //Get e set
    public boolean isPensioneCompleta() { return pensioneCompleta; }
    public String getTipoPensione() {
        if (this.pensioneCompleta)
            return "pensione completa";
        else
            return "mezza pensione";
    }
    public void setPensioneCompleta(boolean pensioneCompleta) { this.pensioneCompleta = pensioneCompleta;}

    //To String e equals
    @Override
    public String toString() {
        return super.toString()+ getTipoPensione();
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof ViaggioPasti){
            ViaggioPasti r=(ViaggioPasti) object;
            return super.equals(r) && r.isPensioneCompleta()==this.pensioneCompleta;
        }
        return false;
    }

    //Costo
    @Override
    public double getCosto(){
        if (!isPensioneCompleta())
            return super.getCosto()+(super.getDurataGiorni()*25);
        else
            return super.getCosto()+(super.getDurataGiorni()*35);
    }
}
