import java.text.DecimalFormat;
public class Buchung extends Main{
    public DecimalFormat dF = new DecimalFormat("#.00");
    //Attribute
    private int zimmernummer, preiskategorie, anzahlTage, anzahlPersonen;
    private boolean balkon, einzelzimmerzuschlag, fruehstueck;
    private boolean haustier, zimmerservice;
    private String name, anschrift, geburtsdatum; private boolean premiumkunde;
    private double summe;

    //
    //Konstruktoren
    public Buchung(int zimmernummer, int preiskategorie, int anzahlPersonen, int anzahlTage, boolean balkon, boolean einzelzimmerzuschlag, boolean fruehstueck, boolean haustier, boolean zimmerservice, String name, String anschrift, String geburtsdatum, boolean premiumkunde){
        this.zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.anzahlPersonen = anzahlPersonen;
        this.anzahlTage = anzahlTage;
        this.balkon = balkon;
        this.einzelzimmerzuschlag = einzelzimmerzuschlag;
        this.fruehstueck = fruehstueck;
        this.haustier = haustier;
        this.zimmerservice = zimmerservice;
        this.name = name;
        this.anschrift = anschrift;
        this.geburtsdatum = geburtsdatum;
        this.premiumkunde = premiumkunde;
        this.summe = summeBerechnen();
    }//end constructor Buchung()
    public Buchung(int zimmernummer, int preiskategorie, int anzahlPersonen, int anzahlTage){
        this.zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.anzahlPersonen = anzahlPersonen;
        this.anzahlTage = anzahlTage;
    }//end constructor Buchung()
    public Buchung(){
        this.zimmernummer = 0;
        this.preiskategorie = 0;
        this.anzahlPersonen = 0;
        this.anzahlTage = 0;
        this.balkon = false;
        this.einzelzimmerzuschlag = false;
        this.fruehstueck = false;
        this.haustier = false;
        this.zimmerservice = false;
        this.name = null;
        this.anschrift = null;
        this.geburtsdatum = null;
        this.premiumkunde = false;
        this.summe = 0.0;
    }
    //
    //Methoden
    public double summeBerechnen(){
        double z = 0.00;
        switch(preiskategorie) {
            case 1: z += anzahlTage * 50.00;break;
            case 2: z += anzahlTage * 75.00; break;
            case 3: z += anzahlTage * 100.00; break;
            case 4: z += anzahlTage * 150.00; break;
            default: break;
        }
        if(balkon){ z += 10.00;}
        if(fruehstueck){ z += anzahlPersonen * anzahlTage * 5.00;}
        if(einzelzimmerzuschlag){ z += 25.00;}
        if(haustier){ z += 10.00;}
        if(zimmerservice){ z += 10.00;}
        if(premiumkunde){ z *= 0.95;}
        z *= 1.19;
        return Math.round(z*100.00)/100.00;
    }//end Methode summeBerechnen()
    public void print(){
        switch(preiskategorie){
            case 1: printEinzelzimmer(); break;
            case 2: printDoppelzimmer(); break;
            case 3: printTripplezimmer(); break;
            case 4: printWohnung(); break;
            default: System.out.println("");
        }
        System.out.println("");
    }//end Methode print()
    public void printBuchung(){
        System.out.println("---Buchung---");
        print();
        System.out.println("Summe: " + dF.format(summe) + "€"); System.out.println("");
        printKundendaten();
    }//end Methode printBuchung()
    public void printKundendaten(){
        System.out.println("Kundendaten:");
        System.out.println("Name: " + name);
        System.out.println("Anschrift: " + anschrift);
        System.out.println("Geburtsdatum: " + geburtsdatum);
        if(premiumkunde){
            System.out.println("Premiumkunde");
        }
        System.out.println("----------");
    }//end Methode printKundendaten()
    public void printTagePersonen(){
        System.out.println("Anzahl Personen: " + anzahlPersonen);
        System.out.println("Anzahl Tage: " + anzahlTage);
    }//end Methode printTagePersonen()
    public void printEinzelzimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Einzelzimmer");
        System.out.println("Preiskategorie: " + preiskategorie + " --- " + dF.format(anzahlTage*50.00) + "€");
        printTagePersonen();
        if(balkon){
            System.out.println("Balkon gewuenscht ---  +10,00€");
        }
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht --- +" + dF.format(anzahlTage*anzahlPersonen*5.00) + "€");
        }
        System.out.println("----------");
    }//end Methode printEinzelzimmer()
    public void printDoppelzimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Doppelzimmer");
        System.out.println("Preiskategorie: " + preiskategorie + " --- " + dF.format(anzahlTage*75.00) + "€");
        printTagePersonen();
        if(balkon){
            System.out.println("Balkon gewuenscht ---  +10,00€");
        }
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht --- +" + dF.format(anzahlTage*anzahlPersonen*5.00) + "€");
        }
        if(einzelzimmerzuschlag){
            System.out.println("Einzelzimmerzuschlag gebucht --- +25,00€");
        }
        System.out.println("----------");
    }//end Methode printDoppelzimmer()
    public void printTripplezimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Tripplezimmer");
        System.out.println("Preiskategorie: " + preiskategorie + " --- " + dF.format(anzahlTage*100.00) + "€");
        printTagePersonen();
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht --- +" + dF.format(anzahlTage*anzahlPersonen*5.00) + "€");
        }
        System.out.println("----------");
    }//end Methode printTripplezimmer()
    public void printWohnung(){
        System.out.println("Zimmer " + zimmernummer + ": Ferienwohnung");
        System.out.println("Preiskategorie: " + preiskategorie + " --- " + dF.format(anzahlTage*150.00) + "€");
        printTagePersonen();
        if(haustier){
            System.out.println("Haustier gebucht --- +10,00€");
        }
        if(zimmerservice){
            System.out.println("Zimmerservice gebucht --- +10,00€");
        }
        System.out.println("----------");
    }//end Methode printWohnung()
    //
    //notwendige getter- und setter Methoden
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
    public void setSumme(){
        this.summe = summeBerechnen();
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
}