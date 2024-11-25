package com.example.pratica824;

public class AgenziaViaggi {
    private Viaggio [] viaggios;
    private int inseriti;

    //Costruttore
    public AgenziaViaggi(Viaggio[] viaggios,int inseriti) {
        this.viaggios = viaggios;
        this.inseriti=inseriti;
    }
    public AgenziaViaggi(int numeriViaggios) {
        this(new Viaggio[numeriViaggios],0);
    }
    public AgenziaViaggi() {
        this(new Viaggio[100],0);
    }

    //Get e set
    public Viaggio[] getViaggios() { return viaggios; }
    public void setViaggios(Viaggio[] viaggios) { this.viaggios = viaggios; }

    public int getInseriti() { return inseriti; }
    public void setInseriti(int inseriti) { this.inseriti = inseriti; }

    //to string e equals
    @Override
    public String toString() {
        String s="ELENCO VIAGGI:\n";
        for (int i=0;i<this.inseriti;i++){
            s=s+viaggios[i].toString()+", costo: "+viaggios[i].getCosto()+" \n";
        }
        return s;
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof AgenziaViaggi){
            AgenziaViaggi r=(AgenziaViaggi) object;
            for (int i=0;i<this.inseriti;i++){
                if (!viaggios[i].equals(r.getViaggios()[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //Metodi
    public double getCostoMedio(){
        double costo=0.0;
        for (int i=0;i<this.inseriti;i++){
            costo+=viaggios[i].getCosto();
        }
        return costo/this.inseriti;
    }
    public int getPosizionePacchettoMin(){
        double costoMin=viaggios[0].getCosto();
        int posMin=0;
        for (int i=0;i<this.inseriti;i++){
            if (costoMin>viaggios[i].getCosto()){
                costoMin=viaggios[i].getCosto();
                posMin=i;
            }
        }
        return posMin;
    }
    public int getPosizionePacchettoMax(){
        double costoMax=viaggios[0].getCosto();
        int posMax=0;
        for (int i=0;i<this.inseriti;i++){
            if (costoMax<viaggios[i].getCosto()){
                costoMax=viaggios[i].getCosto();
                posMax=i;
            }
        }
        return posMax;
    }
    public String getMinMax(){
        return "MAX: "+viaggios[getPosizionePacchettoMax()].toString()+"\n\n MIN: "+viaggios[getPosizionePacchettoMin()].toString();
    }
}
