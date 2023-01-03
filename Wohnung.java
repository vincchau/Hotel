public class Wohnung extends Zimmer{
    //Attribute
    //
    //Konstruktoren
    //erzeugt ein Objekt des Typen Wohnung mit den für ihn relevanten Infos
    public Wohnung(int zimmernummer){
        super(zimmernummer, 4, 150.00);
    }
    //
    //Methoden
    //ruft die Zimmer print Methode auf
    public void print(){
        super.print();
        System.out.println("");
    }
}
