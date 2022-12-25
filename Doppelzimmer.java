public class Doppelzimmer extends Einzelzimmer{
    //Attribute
    private boolean einzelzimmerzuschlag;
    //
    //Konstruktoren
    public Doppelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt, balkon);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }//end constructor Doppelzimmer()
    public Doppelzimmer(){
        super();
        this.einzelzimmerzuschlag = false;
    }//end constructor Doppelzimmer()
    public Doppelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, balkon, einzelzimmerzuschlag);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }//end constructor Doppelzimmer()
    //
    //Methoden
    public void print(){
        super.print();
        if(einzelzimmerzuschlag){
            System.out.println("Als Einzelzimmer belegt.");
        }
        System.out.println("");
    }//end methode print()
    //
    //notwendige getter- und setter methoden
    public void setEinzelzimmerzuschlag(boolean einzelzimmerzuschlag){
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    public boolean getEinzelzimmerzuschlag(){
        return einzelzimmerzuschlag;
    }
}
