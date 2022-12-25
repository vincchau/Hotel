import java.text.DecimalFormat;
public class Buchung extends Main{
    public DecimalFormat dF = new DecimalFormat("#.00");
    //Attribute
    private int zimmernummer, preiskategorie, anzahlTage, anzahlPersonen;
    private boolean balkon, einzelzimmerzuschlag, fruehstueck;
    private boolean haustier, zimmerservice;
    private String name, vorname, anschrift, geburtsdatum; private boolean premiumkunde;
    private double summe;

    //
    //Konstruktoren
    public Buchung(int zimmernummer, int preiskategorie, int anzahlPersonen, int anzahlTage){
        this.zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.anzahlPersonen = anzahlPersonen;
        this.anzahlTage = anzahlTage;
    }//end constructor Buchung()
    //
    //Methoden
    public double summeBerechnen(){
        switch(preiskategorie) {
            case 1: summe = anzahlTage *= 50.00;break;
            case 2: summe = anzahlTage * 75.00; break;
            case 3: summe = anzahlTage * 100.00; break;
            case 4: summe = anzahlTage * 150.00; break;
        }
        if (balkon) summe += 10.00;
        if (fruehstueck) summe += 5.00;
        if (einzelzimmerzuschlag) summe += 25.00;
        if (haustier) summe += 10.00;
        if (zimmerservice) summe += 10;
        if(premiumkunde) summe *= 0.95;
        summe *= 1.19;
        return Math.round(summe*100)/100;
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
        System.out.println("Name: " + vorname + " " + name);
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
        System.out.println("Preiskategorie: " + preiskategorie);
        printTagePersonen();
        if(balkon){
            System.out.println("Balkon gewuenscht");
        }
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht");
        }
        System.out.println("----------");
    }//end Methode printEinzelzimmer()
    public void printDoppelzimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Doppelzimmer");
        System.out.println("Preiskategorie: " + preiskategorie);
        printTagePersonen();
        if(balkon){
            System.out.println("Balkon gewuenscht");
        }
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht");
        }
        if(einzelzimmerzuschlag){
            System.out.println("Einzelzimmerzuschlag gebucht");
        }
        System.out.println("----------");
    }//end Methode printDoppelzimmer()
    public void printTripplezimmer(){
        System.out.println("Zimmer " + zimmernummer + ": Tripplezimmer");
        System.out.println("Preiskategorie: " + preiskategorie);
        printTagePersonen();
        if(fruehstueck){
            System.out.println("Fruehstueck gebucht");
        }
        System.out.println("----------");
    }//end Methode printTripplezimmer()
    public void printWohnung(){
        System.out.println("Zimmer " + zimmernummer + ": Ferienwohnung");
        System.out.println("Preiskategorie: " + preiskategorie);
        printTagePersonen();
        if(haustier){
            System.out.println("Haustier gebucht");
        }
        if(zimmerservice){
            System.out.println("Zimmerservice gebucht");
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
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
    public String getVorname(){
        return vorname;
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
