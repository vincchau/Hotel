public class Doppelzimmer extends Einzelzimmer{
    //Attribute
    private boolean einzelzimmerzuschlag;
    //
    //Konstruktoren
    //Erstellung eines Objekts des Typs Doppelzimmer (inklusive Übergabe aller Attribute).
    public Doppelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt, balkon);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }//end constructor Doppelzimmer()
    //Erstellung eines Objekts des Typs Einzelzimmer (ohne übergebene Attribute).
    public Doppelzimmer(){
        super();
        this.einzelzimmerzuschlag = false;
    }//end constructor Doppelzimmer()
    //Erstellung eines Objekts des Typs Einzelzimmer (inklusive Übergabe einiger Attribute).
    public Doppelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, balkon, einzelzimmerzuschlag);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }//end constructor Doppelzimmer()
    //
    //Methoden
    public void print(){//Gibt alle Zimmerdaten inklusive Balkon und Einzelzimmerzuschlag aus.
        super.print();
        if(einzelzimmerzuschlag){
            System.out.println("Als Einzelzimmer belegt.");
        }
        System.out.println("");
    }//end methode print()
    //
    //Notwendige Getter- und Setter-Methoden
    public void setEinzelzimmerzuschlag(boolean einzelzimmerzuschlag){
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    public boolean getEinzelzimmerzuschlag(){
        return einzelzimmerzuschlag;
    }
}
