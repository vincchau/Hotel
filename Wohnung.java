public class Wohnung extends Zimmer{
    //Attribute
    //
    //Konstruktoren
    //Erstellung eines Objekts des Typs Tripplezimmer (inklusive Übergabe der zur Anlage eines Tripplezimmers notwendigen Attribute und für die Zimmerart festgelegten Werte).
    public Wohnung(int zimmernummer){
        super(zimmernummer, 4, 150.00);
    }
    //
    //Methoden
    public void print(){//Gibt alle Zimmerdaten aus.
        super.print();
        System.out.println("");
    }
}
