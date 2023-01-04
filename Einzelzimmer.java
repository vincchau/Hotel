public class Einzelzimmer extends Zimmer{
    //Attribute
    private boolean balkon;
    //
    //Konstruktoren
    //Erstellung eines Objekts des Typs Einzelzimmer (inklusive Übergabe aller Attribute).
    public Einzelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon){
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt);
        this.balkon = balkon;
    }//end constructor Einzelzimmer()
    //Erstellung eines Objekts des Typs Einzelzimmer (ohne übergebene Attribute).
    public Einzelzimmer(){
        super();
        this.balkon = false;
    }//end constructor Einzelzimmer()
    //Erstellung eines Objekts des Typs Einzelzimmer (inklusive Übergabe der zur Anlage eines Einzelzimmers notwendigen Attribute und für die Zimmerart festgelegten Werte).
    public Einzelzimmer(int zimmernummer, boolean balkon){
        super(zimmernummer, 1, 50.00);
        this.balkon = balkon;
    }//end constructor Einzelzimmer()
    //Aufgrund Vererbung: Zur erstellung eines Objekts des Typs Doppelzimmer (inklusive Übergabe der zur Anlage eines Doppelzimmers notwendigen Attribute und für die Zimmerart festgelegten Werte).
    public Einzelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, 2, 75.00);
        this.balkon = balkon;
    }
    //
    //Methoden
    public void print(){//Gibt alle Zimmerdaten inklusive Balkon aus.
        super.print();
        if(balkon){
            System.out.println("Zimmer mit Balkon");
        }else System.out.println("Zimmer ohne Balkon");
        System.out.println("");
    }//end methode print()
    //Notwendige Getter- und Setter-Methoden
    public void setBalkon(boolean balkon){
        this.balkon = balkon;
    }
    public boolean getBalkon(){
        return balkon;
    }
}
