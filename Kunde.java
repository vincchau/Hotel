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
    public Kunde [] Kunden = new Kunde [100];
    private String name = "Max Mustermann";
    private String anschrift = "Musterstr. 31, 42069 Musterstadt";
    private String geburtsdatum = "##.##.####";
    private boolean premiumkunde = false;
    private int zimmernummer1, zimmernummer2, zimmernummer3;

    //Konstruktoren
    public Kunde(String name, String anschrift, String geburtsdatum, boolean premiumkunde,
                 int zimmernummer1){//Ablage der Kundendaten
        this.name = name;
        this.anschrift = anschrift;
        this.geburtsdatum = geburtsdatum;
        this.premiumkunde = premiumkunde;
        this.zimmernummer1 = zimmernummer1;

    }
    public Kunde(String name, String anschrift, String geburtsdatum, boolean premiumkunde,
                 int zimmernummer1, int zimmernummer2){//Ablage der Kundendaten
        this(name, anschrift,geburtsdatum,premiumkunde,zimmernummer1);
        this.zimmernummer2 = zimmernummer2;

    }
    public Kunde(String name, String anschrift, String geburtsdatum, boolean premiumkunde,
                 int zimmernummer1, int zimmernummer2, int zimmernummer3){//Ablage der Kundendaten
        this(name, anschrift,geburtsdatum,premiumkunde,zimmernummer1,zimmernummer2);
        this.zimmernummer3 = zimmernummer3;

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

    public void setZimmernummer1(int zimmernummer1) {
        this.zimmernummer1 = zimmernummer1;
    }

    public int getZimmernummer1() {
        return zimmernummer1;
    }

    public void setZimmernummer2(int zimmernummer2) {
        this.zimmernummer2 = zimmernummer2;
    }

    public int getZimmernummer2() {
        return zimmernummer2;
    }

    public void setZimmernummer3(int zimmernummer3) {
        this.zimmernummer3 = zimmernummer3;
    }

    public int getZimmernummer3() {
        return zimmernummer3;
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
    //Kundendaten erzeugen
    //
   public void kundenErzeugen() {
       for (int i = 0; i < Kunden.length; i++) {
           Kunden[i] = new Kunde();
       }
   }
}//end class
