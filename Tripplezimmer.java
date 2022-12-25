public class Tripplezimmer extends Zimmer{
    //Attribute
    //
    //Konstruktoren
    public Tripplezimmer(int zimmernummer){
        super(zimmernummer, 3, 100.00);
    }//end constructor Tripplezimmer
    public Tripplezimmer(){
        super();
    }//end constructor Tripplezimmer
    //Methoden
    public void print(){
        super.print();
        System.out.println("");
    }
}
