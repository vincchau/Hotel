public class Wohnung extends Zimmer{
    //Attribute
    //
    //Konstruktoren
    public Wohnung(int zimmernummer){
        super(zimmernummer, 4, 150.00);
    }
    //
    //Methoden
    public void print(){
        super.print();
        System.out.println("");
    }
}