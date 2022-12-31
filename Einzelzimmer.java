public class Einzelzimmer extends Zimmer{
    //Attribute
    private boolean balkon;
    //
    //Konstruktoren
    public Einzelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon){
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt);
        this.balkon = balkon;
    }//end constructor Einzelzimmer()
    public Einzelzimmer(){
        super();
        this.balkon = false;
    }//end constructor Einzelzimmer()
    public Einzelzimmer(int zimmernummer, boolean balkon){
        super(zimmernummer, 1, 50.00);
        this.balkon = balkon;
    }
    public Einzelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, 2, 75.00);
        this.balkon = balkon;
    }
    //
    //Methoden
    public void print(){
        super.print();
        if(balkon){
            System.out.println("Zimmer mit Balkon");
        }else System.out.println("Zimmer ohne Balkon");
        System.out.println("");
    }//end methode print()
    //notwendige getter-und setter methoden
    public void setBalkon(boolean balkon){
        this.balkon = balkon;
    }
    public boolean getBalkon(){
        return balkon;
    }
}