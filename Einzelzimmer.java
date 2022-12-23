/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel3;

/**
 *
 * @author Vincent
 */
public class Einzelzimmer extends Zimmer{
    //Attribute
    private boolean balkon;
    
    //Konstruktoren
    public Einzelzimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt, boolean balkon){//Ablage der Einzelzimmer
        super(zimmernummer, preiskategorie, preisProZimmer, zimmerProKategorie, belegt);
        this.balkon = balkon;
    }
    public Einzelzimmer(){
        super();
        this.balkon = false;
    }
    public Einzelzimmer(int zimmernummer, boolean balkon){
        super(zimmernummer, 1, 50.00);
        this.balkon = balkon;
    }
    public Einzelzimmer(int zimmernummer, boolean balkon, boolean einzelzimmerzuschlag){
        super(zimmernummer, 2, 75.00);
        this.balkon = balkon;
        
    }
    
    //Methoden
    public void setBalkon(boolean balkon){
        this.balkon = balkon;
    }
    public boolean getBalkon(){
        return balkon;
    }
    public void print(){
        super.print();
        System.out.println("Balkon? " + balkon);
        System.out.println("");
    }


}//end class
