/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel3;
/**
 *
 * @author Vincent
 */
public class Buchung {
    //Attribute 
    private int zimmernummer;
    private int preiskategorie;

    private boolean balkon;
    private boolean einzelzimmerzuschlag;
   
    private int anzahlTage;
    private int anzahlPersonen;
    
    private boolean fruehstueck;
        
    private boolean haustier;
    private boolean zimmerservice;
    
    private String name;
    private String anschrift;
    private String geburtsdatum;
    private boolean premiumkunde;
    
    private double summe;
        
    //Konstruktoren
    //
    //Für Alle Zimmer
    //
    public Buchung(int zimmernummer){
        this.zimmernummer = zimmernummer;
    }
    public Buchung(int zimmernummer, int preiskategorie){
        this(zimmernummer);
        this.preiskategorie = preiskategorie;
    }
    public Buchung(int zimmernummer, int preiskategorie, boolean balkon){
        this(zimmernummer, preiskategorie);
        this.balkon = balkon;
    }
    public Buchung(int zimmernummer, int preiskategorie, boolean balkon, int anzahlPersonen, int anzahlTage){
        this(zimmernummer, preiskategorie, balkon);
        this.anzahlPersonen = anzahlPersonen;
        this.anzahlTage = anzahlTage;
    }
    public Buchung(int zimmernummer, int preiskategorie, boolean balkon, boolean einzelzimmerzuschlag){
        this(zimmernummer, preiskategorie, balkon);
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    public Buchung(int zimmernummer, int preiskategorie, boolean balkon, boolean einzelzimmerzuschlag, int anzahlPersonen, int anzahlTage){
        this(zimmernummer, preiskategorie, balkon, einzelzimmerzuschlag);
        this.anzahlPersonen = anzahlPersonen;
        this.anzahlTage = anzahlTage;
    }
    public Buchung(int zimmernummer, int preiskategorie, int anzahlPersonen, int anzahlTage){
        this(zimmernummer, preiskategorie);
        this.anzahlPersonen = anzahlPersonen;
        this.anzahlTage = anzahlTage;
    }
    public Buchung(boolean fruehstueck){
        this.fruehstueck = fruehstueck;
    }
    public Buchung(int zimmernummer, boolean fruehstueck){
        this(zimmernummer);
        this.fruehstueck = fruehstueck;
    }
    //
    //Für Kunden
    //
    public Buchung(String name){
        this.name = name;
    }
    public Buchung(String name, String anschrift){
        this(name);
        this.anschrift = anschrift;
    }
    public Buchung(String name, String anschrift, String geburtsdatum){
        this(name, anschrift);
        this.geburtsdatum = geburtsdatum;
    }
    public Buchung(String name, String anschrift, String geburtsdatum, boolean premiumkunde){
        this(name, anschrift, geburtsdatum);
        this.premiumkunde = premiumkunde;
    }
    //
    //Für Summe und Zimernummer
    //
    public Buchung(double summe){
        this.summe = summe;
    }
    public Buchung(double summe, int zimmernummer){
        this(summe);
        this.zimmernummer = zimmernummer;
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
    public void setSumme(double summe){
        this.summe = summe;
    }
    public double getSumme(){
        return summe;
    }
    
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
    public void setAnzahlTage(int anzahlTage){
        this.anzahlTage = anzahlTage;
    }
    public int getAnzahlTage(){
        return anzahlTage;
    }
    public void setAnzahlPersonen(int anzahlPersonen){
        this.anzahlPersonen = anzahlPersonen;
    }
    public int getAnzahlPersonen(){
        return anzahlPersonen;
    }
    public void setBalkon(boolean balkon){
        this.balkon = balkon;
    }
    public boolean getBalkon(){
        return balkon;
    }
    public void setFruehstueck(boolean fruehstueck){
        this.fruehstueck = fruehstueck;
    }
    public boolean getFruehstueck(){
        return fruehstueck;
    }
    public void setEinzelzimmerzuschlag(boolean einzelzimmerzuschlag){
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
    }
    public boolean getEinzelzimmerzuschlag(){
        return einzelzimmerzuschlag;
    }
    public void setHaustier(boolean haustier){
        this.haustier = haustier;
    }
    public boolean getHaustier(){
        return haustier;
    }
    public void setZimmerservice(boolean zimmerservice){
        this.zimmerservice = zimmerservice;
    }
    public boolean getZimmerservice(){
        return zimmerservice;
    }
    
    public void print(){
        System.out.println("-----Buchung-----");
        switch(preiskategorie){
            case 1:
                printEinzelzimmer();
                break;
            case 2:
                printDoppelzimmer();
                break;
            case 3:
                printTripplezimmer();
                break;
            case 4:
                printWohnung();
                break;
        }
        printKundendaten();
        printSumme();
    }
    
    public void printEinzelzimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Einzelzimmer");
        System.out.println("Preiskategorie: " + preiskategorie);
        if(balkon){
            System.out.println("Balkon gewünscht");
        }
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht");
        }
        System.out.println("----------");
    }
    public void printDoppelzimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Doppelzimmer");
        System.out.println("Preiskategorie: " + preiskategorie);
        if(balkon){
            System.out.println("Balkon gewünscht");
        }
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht");
        }
        if(einzelzimmerzuschlag){
            System.out.println("Einzelzimmerzuschlag gebucht");
        }
        System.out.println("----------");
    }
    public void printTripplezimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Tripplezimmer");
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht");
        }
        System.out.println("----------");
    }
    public void printWohnung(){
        System.out.println("Zimmer " + zimmernummer + ": Ferienwohnung");
        System.out.println("Anzahl Personen: " + anzahlPersonen);
        System.out.println("Anzahl Tage: " + anzahlTage);
        if(haustier){
            System.out.println("Haustier gebucht");
        }
        if(zimmerservice){
            System.out.println("Zimmerservice gebucht");
        }
        System.out.println("----------");
    }
    public void printKundendaten(){
        System.out.println("Kundendaten:");
        System.out.println("Name: " + name);
        System.out.println("Anschrift: " + anschrift);
        System.out.println("Geburtsdatum: " + geburtsdatum);
        if(premiumkunde){
            System.out.println("Premiumkunde");
        }
        System.out.println("----------");
    }
    public void printSumme(){
        System.out.println("Summe: " + summe + "€");
        System.out.println("----------");
    }
    public void printRechnung(){
        System.out.println("---Rechnung---");
        printKundendaten();
        switch(preiskategorie){
            case 1:
                printEinzelzimmer();
                break;
            case 2:
                printDoppelzimmer();
                break;
            case 3:
                printTripplezimmer();
                break;
            case 4:
                printWohnung();
                break;
        }
        printSumme();
    }
}//end class
