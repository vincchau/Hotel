public class Tripplezimmer extends Zimmer{
    //Attribute
    //
    //Konstruktoren
    //Erstellung eines Objekts des Typs Tripplezimmer (inklusive Übergabe der zur Anlage eines Tripplezimmers notwendigen Attribute und für die Zimmerart festgelegten Werte).
    public Tripplezimmer(int zimmernummer){
        super(zimmernummer, 3, 100.00);
    }//end constructor Tripplezimmer
    //Erstellung eines Objekts des Typs Tripplezimmer (ohne übergebene Attribute).
    public Tripplezimmer(){
        super();
    }//end constructor Tripplezimmer
    //Methoden
    public void print(){//Gibt alle Zimmerdaten aus.
        super.print();
        System.out.println("");
    }
}
