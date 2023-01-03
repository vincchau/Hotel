public class Einzelzimmer extends Zimmer{
    //Attribute
    private boolean balkon;
    //
    //Konstruktoren
    public Einzelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon){
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt);
        this.balkon = balkon;
    }//end constructor Einzelzimmer()
    //erzeugt ein Objekt des Typen Einzelzimmers und fügt das Attribut Balkon hinzu
    public Einzelzimmer(){
        super();
        this.balkon = false;
    }//end constructor Einzelzimmer()
    //setzt den PreisproZimmer auf 50 & und die Kategorie auf 1
    public Einzelzimmer(int zimmernummer, boolean balkon){
        super(zimmernummer, 1, 50.00);
        this.balkon = balkon;
    }//end constructor Einzelzimmer()
    //macht das gleiche wie der vorangegangene nur für den Fall des Einzelzimmerzuschlags,
    //indem er das Attribut einzelzimmerzuschlag hinzufügt, er passt ebenfalls die Preise an
    public Einzelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, 2, 75.00);
        this.balkon = balkon;
    }
    //
    //Methoden
    //ruft die Zimmer print Methode auf, mit der besonderheit, dass hier auch noch der Balkon, falls er gebucht wird mit ausgegeben wird
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
