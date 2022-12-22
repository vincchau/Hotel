/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel3;

/**
 *
 * @author Vincent
 */
public class Wohnung extends Zimmer{
    //Attribute
    
    
    //Konstruktoren
    public Wohnung(int zimmernummer){
        super(zimmernummer, 4, 150.00);
    }
    
    //Methoden
    public void print(){
        super.print();
        System.out.println("");
    }
    
}
