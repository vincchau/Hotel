/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel3;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Vincent
 */
public class Hotel3 {
public static Scanner s = new Scanner(System.in);
public static void print(String p){System.out.println(p);}

public static int k = 1;

public static void main(String[] args) {

    Kunde [] Kunden = new Kunde [100];
    Zimmer [] Belegung = new Zimmer [8];
    Buchung [] Buchungen = new Buchung [8];
    //Buchung [][] Rechnungen = new Buchung [2][8];
    //
    //Kundendaten erzeugen
    //
    for(int i = 0; i<Kunden.length; i++){
        Kunden[i] = new Kunde();
    }
    //
    //Belegung erzeugen
    //
    for(int i = 0; i<Belegung.length; i++){
        switch(i){
            case 0:
                Belegung[i] = new Einzelzimmer(1, true);
                Belegung[i].setBelegt(true); 
                //Buchungen[0][i] = new Buchung(1, true, true);
                break;
            case 1:
                Belegung[i] = new Einzelzimmer(2, 1, 50.00, 2, true, false);
                Belegung[i].setBelegt(true);
                //Buchungen[0][i] = new Buchung(1, false, false);
                break;
            case 2:
                Belegung[i] = new Doppelzimmer(3, true);
                Belegung[i].setBelegt(true);
                //Buchungen[0][i] = new Buchung(2, true, true, false);
                break;
            case 3:
                Belegung[i] = new Doppelzimmer(4, false);
                Belegung[i].setBelegt(false);
                break;
            case 4:
                Belegung[i] = new Tripplezimmer(5);
                Belegung[i].setBelegt(false);
                break;
            case 5:
                Belegung[i] = new Tripplezimmer(6);
                Belegung[i].setBelegt(false);
                break;
            case 6:
                Belegung[i] = new Wohnung(7);
                Belegung[i].setBelegt(false);
                break;
            case 7:
                Belegung[i] = new Wohnung(8);
                Belegung[i].setBelegt(true);
                //Buchungen[0][i] = new Buchung(4, 4, 5, false, true);
                break;
        }//end switch
    }//end for
    //
    //
    //Start der zwei Buchungen
    //
    for(int i = 0; i<100; i++){
    //
    //Deklaration der notwendigen Attribute
    //

    int auswahl;
    int preiskategorie;
    boolean balkon;
    int zimmernummer = 0;
    boolean einzelzimmerzuschlag = false;
    boolean fruehstueck = false;
    int anzahlPersonen = 0;
    int anzahlTage = 0;
    boolean haustier = false;
    boolean zimmerservice = false;
    
    int kundennummer = 0;
    String name = null;
    String anschrift = null;
    String geburtsdatum = null;
    boolean premiumkunde = false;
    //
    //Start der Abfrage
    //

    print("Was möchten Sie aufrufen?");
    print("Buchung ausführen: 1, Belegung eines Zimmers anzeigen: 2, Alle Zimmer anzeigen: 3, Buchung eines Zimmers anzeigen: 4, Kunde Anlegen: 5, ");
    auswahl = s.nextInt();
    switch(auswahl){
        case 1:
            int b = 1;
            do{
                preiskategorie = abfrageZimmerart();
                switch(preiskategorie){
                    case 1:
                        balkon = abfrageBalkon();
                        if(balkon){
                            zimmernummer = getBelegungEinzelzimmerBalkon(Belegung);
                            if(zimmernummer == 0){
                                break;
                            }else if(zimmernummer == (2 | 4)){
                                balkon = false;
                            }else if(zimmernummer>2){
                                einzelzimmerzuschlag = true;
                            }
                        }else{
                            zimmernummer = getBelegungEinzelzimmer(Belegung);
                            if(zimmernummer == 0){
                                break;
                            }else if(zimmernummer>2){
                                einzelzimmerzuschlag = true;
                            }
                        }//end if(balkon) und abfrage zimmernummer inklusive festlegung des einzelzimmerzuschlags.
                        fruehstueck = abfrageFruehstueck();
                        anzahlPersonen = 1;
                        anzahlTage = abfrageAnzahlTage();
                        Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage);
                        Buchungen[zimmernummer-1].setBalkon(balkon);
                        Buchungen[zimmernummer-1].setFruehstueck(fruehstueck);
                        Buchungen[zimmernummer-1].setEinzelzimmerzuschlag(einzelzimmerzuschlag);
                        break;
                    case 2:
                        balkon = abfrageBalkon();
                        if(balkon){
                            zimmernummer = getBelegungDoppelzimmerBalkon(Belegung);
                            if(zimmernummer == 0){
                                break;
                            }else if(zimmernummer == 4){
                                balkon = false;
                            }   
                        }else{
                            zimmernummer = getBelegungDoppelzimmer(Belegung);
                            if(zimmernummer == 0){
                                break;
                            }
                        }//end if(balkon)
                        fruehstueck = abfrageFruehstueck();
                        anzahlPersonen = 2;
                        anzahlTage = abfrageAnzahlTage();
                        Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage);
                        Buchungen[zimmernummer-1].setBalkon(balkon);
                        Buchungen[zimmernummer-1].setFruehstueck(fruehstueck);
                        break;
                    case 3:
                        zimmernummer = getBelegungTripplezimmer(Belegung);
                        if(zimmernummer == 0){
                            break;
                        }
                        fruehstueck = abfrageFruehstueck();
                        anzahlPersonen = 3;
                        anzahlTage = abfrageAnzahlTage();
                        Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage);
                        Buchungen[zimmernummer-1].setFruehstueck(fruehstueck);
                        break;
                    case 4:
                        zimmernummer = getBelegungWohnung(Belegung);
                        if(zimmernummer == 0){
                            break;
                        }
                        anzahlPersonen = abfrageAnzahlPersonen();
                        if(anzahlPersonen>6){
                            print("Ferienwohnungen koennen für maximal 6 Personen gebucht werden.");
                            anzahlPersonen = abfrageAnzahlPersonen();
                        }
                        anzahlTage = abfrageAnzahlTage();
                        if(anzahlTage<3){
                            print("Ferienwohnungen muessen fuer mindestens 3 Tage gebucht werden.");
                            anzahlTage = abfrageAnzahlTage();
                        }
                        haustier = abfrageHaustier();
                        zimmerservice = abfrageZimmerservice();

                        if(zimmernummer == 0 | anzahlTage == 0 | anzahlPersonen == 0){
                            break;
                        }else Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage);
                        Buchungen[zimmernummer-1].setHaustier(haustier);
                        Buchungen[zimmernummer-1].setZimmerservice(zimmerservice);
                        break;
                }//end switch(preiskategorie)
                if(zimmernummer == 0){
                    break;
                }
                if(name == null) {
                    name = abfrageName();
                    geburtsdatum = abfrageGeburtsdatum();
                    kundennummer = abfrageKundennummer(name, geburtsdatum, Kunden);
                    if (kundennummer == 0) {
                        anschrift = abfrageAnschrift();
                        premiumkunde = abfragePremiumkunde();
                        Kunden[k] = new Kunde(name, anschrift, geburtsdatum, premiumkunde, zimmernummer);
                        kundennummer  =k; k++;
                    } else {
                        anschrift = Kunden[kundennummer].getAnschrift();
                        premiumkunde = Kunden[kundennummer].getPremiumkunde();
                        Kunden[kundennummer].setZimmernummer1(zimmernummer);
                    }//end if else(kundennummer)
                } else if(b == 2){
                    Kunden[kundennummer].setZimmernummer2(zimmernummer);
                } else if (b == 3) {
                    Kunden[kundennummer].setZimmernummer3(zimmernummer);
                }
                Buchungen[zimmernummer-1].setName(name); Buchungen[zimmernummer-1].setGeburtsdatum(geburtsdatum); Buchungen[zimmernummer-1].setAnschrift(anschrift); Buchungen[zimmernummer-1].setPremiumkunde(premiumkunde);
                Belegung[zimmernummer-1].setBelegt(true);
                if(b<3) print("Moechten Sie weitere Zimmer buchen?");
                if(b<3) {
                    if (!abfrageEinverstanden()) {
                        b = 4;
                    } }
                    b++;

            }while(b<4);
            break;
        case 2:
            zimmerBelegungAnzeigen(Belegung);
            break;
        case 3:
            zimmerAnzeigen(Belegung);
            break;
        case 4:
            zimmerBelegungProzent(Belegung);
            break;
        case 5:
            print("Für welches Zimmer moechten Sie die Rechnung drucken?");
                Buchungen[s.nextInt()-1].printRechnung();
            break;
      //  case 6:
        //    print("Die Rechnungen für alle Zimmer");
          //      for(int p=0; p<8;p++){
            //        Buchungen[p].printSumme();
              //  }
            //break;
    }//end switch(auswahl)
    //
    }//end for schleife i des Systems
}//end main
//1
public static int abfrageZimmerart(){
    print("Welche Zimmerart möchten Sie buchen? Einzelzimmer: 1, Doppelzimmer: 2, Tripplezimmer: 3 oder Ferienwohnung: 4.");
    int preiskategorie = s.nextInt();
    return preiskategorie;
}
public static boolean abfrageBalkon(){
    print("Möchten Sie ein Zimmer mit Balkon buchen? true, false.");
    boolean balkon = false;
    String input = s.next();
    if(input.equals("Ja") | input.equals("ja") | input.equals("j")){
        balkon = true;
    }else if(input.equals("Nein")| input.equals("nein") | input.equals("n") ){
        balkon = false;
    }
    return balkon;
}

public static int getBelegungEinzelzimmerBalkon(Zimmer[]Belegung){
    if(!Belegung[0].getBelegt()){
        return Belegung[0].getZimmernummer();
    }else if(!Belegung[2].getBelegt()){
        print("Einzelzimmer nicht frei aber Doppelzimmer mit Balkon frei.");
        if(abfrageEinverstanden()){
            return Belegung[2].getZimmernummer();
        }
    }else if(!Belegung[1].getBelegt()){
        print("Nur Einzelzimmer ohne Balkon frei.");
        if(abfrageEinverstanden()){
            return Belegung[1].getZimmernummer();
        }
    }else if(!Belegung[3].getBelegt()){
        print("Nur Doppelzimmer ohne Balkon frei.");
        if(abfrageEinverstanden()){
            return Belegung[3].getZimmernummer();
        }
    } else print("Alle Einzel- und Doppelzimmer belegt.");
    return 0;
}
public static int getBelegungDoppelzimmerBalkon(Zimmer[]Belegung){
    if(!Belegung[2].getBelegt()){
        return Belegung[2].getZimmernummer();
    }else if(!Belegung[3].getBelegt()){
        print("Nur Doppelzimmer ohne Balkon frei.");
        if(abfrageEinverstanden()){
            return Belegung[3].getZimmernummer();
        }
    } else print("Alle Doppelzimmer belegt.");
    return 0;
}

public static int getBelegungEinzelzimmer(Zimmer[]Belegung){
    if(!Belegung[0].getBelegt()){
        return Belegung[0].getZimmernummer();
    }else if(!Belegung[1].getBelegt()){
        return Belegung[1].getZimmernummer();
    }else if(!Belegung[2].getBelegt()){
        print("Einzelzimmer belegt aber Doppelzimmer frei.");
        if(abfrageEinverstanden()){
        return Belegung[2].getZimmernummer();
        }
    }else if(!Belegung[3].getBelegt()){
        print("Einzelzimmer belegt aber Doppelzimmer frei.");
        if(abfrageEinverstanden()){
        return Belegung[3].getZimmernummer();
        }
    }else print("Alle Einzel- und Doppelzimmer belegt.");
        return 0;
}
public static int getBelegungDoppelzimmer(Zimmer[]Belegung){
    if(!Belegung[2].getBelegt()){
        return Belegung[2].getZimmernummer();
    } else if(!Belegung[3].getBelegt()){
        return Belegung[3].getZimmernummer();
    } else print("Alle Doppelzimmer sind belegt.");
        return 0;
}
public static int getBelegungTripplezimmer(Zimmer[]Belegung){
    if(!Belegung[4].getBelegt()){
        return Belegung[4].getZimmernummer();
    }else if(!Belegung[5].getBelegt()){
        return Belegung[5].getZimmernummer();
    }else print("Tripplezimmer belegt");
    return 0;
}
public static int getBelegungWohnung(Zimmer[]Belegung){
    if(!Belegung[6].getBelegt()){
        return Belegung[6].getZimmernummer();
    }else if(!Belegung[7].getBelegt()){
        return Belegung[7].getZimmernummer();
    }else print("Wohnungen belegt");
    return 0;
}
public static boolean abfrageFruehstueck(){
    print("Moechten Sie Fruehstueck buchen?");
    boolean fruehstueck = false;
    String input = s.next();
    if(input.equals("Ja") | input.equals("ja") | input.equals("j")){
        fruehstueck = true;
    }else if(input.equals("Nein")| input.equals("nein") | input.equals("n") ){
        fruehstueck = false;
    }
    return fruehstueck;
}


public static int abfrageAnzahlPersonen(){
    print("Wie viele Personen werden die Ferienwohnung belegen?");
    int anzahlPersonen = s.nextInt();
    return anzahlPersonen;
}
public static int abfrageAnzahlTage(){
    print("Wie viele Tage moechten Sie bleiben?");
    int anzahlTage = s.nextInt();
    return anzahlTage;
}
public static boolean abfrageHaustier(){
    print("Moechten Sie mit Haustier anreisen?");
    boolean haustier = false;
    String input = s.next();
    if(input.equals("Ja") | input.equals("ja") | input.equals("j")){
        haustier = true;
    }else if(input.equals("Nein")| input.equals("nein") | input.equals("n") ){
        haustier = false;
    }
    return haustier;
}
public static boolean abfrageZimmerservice(){
    print("Moechten Sie zimmerservice buchen?");
    boolean zimmerservice = false;
    String input = s.next();
    if(input.equals("Ja") | input.equals("ja") | input.equals("j")){
        zimmerservice = true;
    }else if(input.equals("Nein")| input.equals("nein") | input.equals("n") ){
        zimmerservice = false;
    }
    return zimmerservice;
}
public static int abfrageKundennummer(String name, String geburtsdatum, Kunde[]Kunden){
    for(int i = 0; i<Kunden.length; i++){
        if((Kunden[i].getName() == name) & (Kunden[i].getGeburtsdatum() == geburtsdatum)){
            return i;//Verwendung als Kundennummer
        }
    }
    return 0;//Verwendung als Kundennummer
}
public static String abfrageName(){
    print("Bitte geben Sie ihren Namen ein.");
    String name = s.next();
    return name;
}
public static String abfrageAnschrift(){
    print("Bitte geben Sie ihre Anschrift ein.");
    String anschrift = s.next();
    return anschrift;
}
public static String abfrageGeburtsdatum(){
    print("Bitte geben Sie ihr Geburtsdatum ein.");
    String geburtsdatum = s.next();
    return geburtsdatum;
}
public static boolean abfragePremiumkunde(){
    print("Möchten Sie Premiumkunde werden?");
    boolean premiumkunde = false;
    String input = s.next();
    if(input.equals("Ja") | input.equals("ja") | input.equals("j")){
        premiumkunde = true;
    }else if(input.equals("Nein")| input.equals("nein") | input.equals("n") ){
        premiumkunde = false;
    }
    return premiumkunde;
}
    

public static boolean abfrageEinverstanden(){
    print("Sind Sie damit einverstanden?");
    boolean einverstanden;
    String input = s.next();
    if(Objects.equals(input, "Ja") | Objects.equals(input, "ja") | Objects.equals(input, "j")){
        einverstanden = true;
    }else if(Objects.equals(input, "Nein") | Objects.equals(input, "nein") | Objects.equals(input, "n")){
        einverstanden = false;
    }else einverstanden = false;
    return einverstanden;
}
public static void zimmerBelegungAnzeigen(Zimmer[]Belegung){
    print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
            Belegung[s.nextInt()-1].printBelegt();
}
public static void zimmerAnzeigen(Zimmer[]Belegung){
    for(int i = 0; i<Belegung.length; i++){
    Belegung[i].print();
    }
}
public static void zimmerBelegungProzent(Zimmer[]Belegung){
    double anzahlBelegt = 0;
    for(int i = 0; i<Belegung.length; i++){
        if(Belegung[i].getBelegt()){anzahlBelegt++;}
    }
    System.out.println("Das Hotel ist zu " + ((anzahlBelegt/Belegung.length)*100) + "% belegt.");
}
public static void zimmerBuchungAnzeigen(Buchung[]Buchungen){
    print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
    Buchungen[s.nextInt()].print();
}
//public static double summe(){

}//end class
