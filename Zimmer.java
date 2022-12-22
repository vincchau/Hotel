/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel3;

/**
 *
 * @author Vincent
 */
public class Zimmer {
    //Attribute
    private int zimmernummer;
    private int preiskategorie = 0;
    private double preisProZimmer = 0.0;
    private int zimmerProKategorie = 2;
    private boolean belegt = false;
    
    //Konstruktoren
    public Zimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt){//Ablage der Zimmer
        this.zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.preisProZimmer = preisProZimmer;
        this.zimmerProKategorie = zimmerProKategorie;
        this.belegt = belegt;
    }
    public Zimmer(){
        this.preiskategorie = 0;
        this.preisProZimmer = 0.0;
        this.zimmerProKategorie = 2;
        this.belegt = false;
    }
    public Zimmer(int zimmernummer, int preiskategorie, double preisProZimmer){
        this.zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.preisProZimmer = preisProZimmer;
        this.zimmerProKategorie = 2;
        this.belegt = false;
    }
    
    //Methoden
    public void setZimmernummer(int zimmernummer){
        this.zimmernummer = zimmernummer;
    }
    public int getZimmernummer(){
        return zimmernummer;
    }
    public void setPreiskategorie(int preiskategorie){
        this.preiskategorie = preiskategorie;
    }
    public int getPreiskategorie(){
        return preiskategorie;
    }
    public void setPreisProZimmer(double preisProZimmer){
        this.preisProZimmer = preisProZimmer;
    }
    public double getPreisProZimmer(){
        return preisProZimmer;
    }
    public void setZimmerProKategorie(int zimmerProKategorie){
        this.zimmerProKategorie = zimmerProKategorie;
    }
    public int getZimmerProKategorie(){
        return zimmerProKategorie;
    }
    public void setBelegt(boolean belegt){
        this.belegt = belegt;
    }
    public boolean getBelegt(){
        return belegt;
    }
    public void print(){
        if(preiskategorie == 1){
            System.out.println("---Einzelzimmer---");
        }else if(preiskategorie == 2){
            System.out.println("---Doppelzimmer---");
        } else if(preiskategorie == 3){
            System.out.println("---Tripplezimmer");
        }else System.out.println("---Ferienwohnung---");
        System.out.println("Zimmernummer " +  zimmernummer + ":");
        System.out.println("Preiskategorie: " + preiskategorie);
        System.out.println("Preis Pro Zimmer: " + preisProZimmer);
        System.out.println("Zimmer Pro Kategorie: " + zimmerProKategorie);
        System.out.println("Zimmer belegt? " + belegt);
    }
    public void printBelegt(){
        System.out.println("Zimmer " + zimmernummer + ": ");
        if(preiskategorie == 1){
            System.out.println("---Einzelzimmer---");
        }else if(preiskategorie == 2){
            System.out.println("---Doppelzimmer---");
        } else if(preiskategorie == 3){
            System.out.println("---Tripplezimmer");
        }else System.out.println("---Ferienwohnung---");
        
        if(belegt){
            System.out.println("Zimmer belegt.");
        }else System.out.println("Zimmer frei.");
    }
}//end class
