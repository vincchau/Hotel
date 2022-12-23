/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel3;

/**
 *
 * @author Vincent
 */
public class Doppelzimmer extends Einzelzimmer{
    //Attribute
    private boolean einzelzimmerzuschlag;
    
    //Konstruktoren
    public Doppelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt, balkon);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    
    public Doppelzimmer(){
        super();
        this.einzelzimmerzuschlag = false;
    }
    
    public Doppelzimmer(int zimmernummer, boolean balkon){
       super(zimmernummer, balkon, false);
       this.einzelzimmerzuschlag = false;
    }
    
    public Doppelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, balkon, einzelzimmerzuschlag);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    
    //Methoden
    public void setEinzelzimmerzuschlag(boolean einzelzimmerzuschlag){
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    public boolean getEinzelzimmerzuschlag(){
        return einzelzimmerzuschlag;
    }
    public void print(){
        super.print();
        System.out.println("Einzelzimmerzuschlag? " + einzelzimmerzuschlag);
        System.out.println("");
    }

}
