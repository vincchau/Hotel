public class Tripplezimmer extends Zimmer{
    //Attribute
    //
    //Konstruktoren
    //erzeugt ein Objekt des Typen Tripplezimmer mit den für ihn vorgesehenen fixen Werten
    public Tripplezimmer(int zimmernummer){
        super(zimmernummer, 3, 100.00);
    }//end constructor Tripplezimmer
    public Tripplezimmer(){
        super();
    }//end constructor Tripplezimmer
    //Methoden
    //ruft die Zimmer print Methode auf
    public void print(){
        super.print();
        System.out.println("");
    }
}
