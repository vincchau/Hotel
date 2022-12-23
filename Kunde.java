/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel3;

/**
 *
 * @author Vincent
 */
public class Kunde extends Hotel3{
    //Attribute
    private String name = "Max Mustermann";
    private String anschrift = "Musterstr. 31, 42069 Musterstadt";
    private String geburtsdatum = "##.##.####";
    private boolean premiumkunde = false;
    
    //Konstruktoren
    public Kunde(String name, String anschrift, String geburtsdatum, boolean premiumkunde){//Ablage der Kundendaten
        this.name = name;
        this.anschrift = anschrift;
        this.geburtsdatum = geburtsdatum;
        this.premiumkunde = premiumkunde;
    }
    public Kunde(){
        this.name = "Max Mustermann";
        this.anschrift = "Musterstr";
        this.geburtsdatum = "##.##.####";
        this.premiumkunde = false;
    }
    
    //Methoden
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAnschrift(String anschrift){
        this.anschrift = anschrift;
    }
    public String getAnschrift(){
        return anschrift;
    }
    public void setGeburtsdatum(String geburtsdatum){
        this.geburtsdatum = geburtsdatum;
    }
    public String getGeburtsdatum(){
        return geburtsdatum;
    }
    public void setPremiumkunde(boolean premiumkunde){
        this.premiumkunde = premiumkunde;
    }
    public boolean getPremiumkunde(){
        return premiumkunde;
    }
    
    public void printKunde(){
        System.out.println("---Kundendaten--- ");
        System.out.println("Name: " + name);
        System.out.println("Anschrift: " + anschrift);
        System.out.println("Geburtsdatum: " + geburtsdatum);
        if(premiumkunde){
            System.out.println("Premiumkunde");
        }
        System.out.println("");
    }
}//end class
