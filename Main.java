import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static DecimalFormat dF = new DecimalFormat("#.00");
    public static Scanner s = new Scanner(System.in);//Deklaration eines Scanners für die gesamte main Class
    public static Scanner sd = new Scanner(System.in).useDelimiter("\s");//Deklaration eines Scanners mit delimiter zur überbrückung von leerzeichen
    public static void print(String p){System.out.println(p);}//Print funktion zum Abkürzen des Schreibaufwands
    public static int k = 1;//Deklaration und initialisierung einer laufvariable. Verwendet als kundennummer
    private static Kunde [] Kunden = new Kunde[100];
    private static Zimmer [] Belegung = new Zimmer[8];
    private static Buchung [] Buchungen = new Buchung[8];
    public static void main(String[] args) {
        //
        //Deklaration der notwendigen Arrays:
        //Class Kunde zur speicherung der Kundendaten
        //Class Zimmer zur speicherung der einzelnen Zimmerdaten
        //Class Buchung zur speicherung der einzelnen Buchungen
        //
        //Anfangsbelegung erzeugen
        belegungErzeugen();
        //
        //For Schleife des Systems
        for(int i = 0; i<100; i++){

            //
            //Start der Abfrage Auswahl
            print("Was möchten Sie aufrufen?");
            print("1. Buchung ausführen, 2. Belegung eines Zimmers anzeigen, 3. Alle Zimmer anzeigen, 4. Zimmerbelegung in Prozent anzeigen \n" +
                    "5. Buchung eines Zimmers anzeigen, 6. Buchungen eines Kunden anzeigen, 7. Rechnung drucken, 8. Kunde anlegen, 9. Kunden anzeigen");
            int auswahl = s.nextInt();
            switch(auswahl){
                case 1:
                    int b = 1, kundennummer = 0;
                    String name = null, anschrift = null, geburtsdatum = null;
                    do{
                        //Deklaration der notwendigen Variablen
                        int preiskategorie, zimmernummer = 0, anzahlPersonen, anzahlTage;
                        boolean balkon, einzelzimmerzuschlag = false, fruehstueck, haustier, zimmerservice, premiumkunde = false;
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
                                        preiskategorie = 2;
                                    }
                                }else{
                                    zimmernummer = getBelegungEinzelzimmer(Belegung);
                                    if(zimmernummer == 0){
                                        break;
                                    }else if(zimmernummer>2){
                                        einzelzimmerzuschlag = true;
                                        preiskategorie = 2;
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

                                if(anzahlTage == 0 | anzahlPersonen == 0){
                                    break;
                                }else Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage);
                                Buchungen[zimmernummer-1].setHaustier(haustier);
                                Buchungen[zimmernummer-1].setZimmerservice(zimmerservice);
                                break;
                            default: break;
                        }//end switch(preiskategorie)
                        if(zimmernummer == 0){
                            break;
                        }
                        if(name == null) {
                            name = abfrageName();
                            geburtsdatum = abfrageGeburtsdatum();
                            kundennummer = abfrageKundennummer(name, geburtsdatum);
                            if (kundennummer == 0) {
                                anschrift = abfrageAnschrift();
                                premiumkunde = abfragePremiumkunde();
                                kundennummer = k;
                                Kunden[k] = new Kunde(name, anschrift, geburtsdatum, premiumkunde, zimmernummer);
                                k++;
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
                        Buchungen[zimmernummer-1].setName(name); Buchungen[zimmernummer-1].setGeburtsdatum(geburtsdatum);
                        Buchungen[zimmernummer-1].setAnschrift(anschrift); Buchungen[zimmernummer-1].setPremiumkunde(premiumkunde);
                        Buchungen[zimmernummer-1].setSumme();
                        Belegung[zimmernummer-1].setBelegt(true);

                        if(b<3) print("Moechten Sie weitere Zimmer buchen?");
                        if(b<3) {
                            if (!abfrageEinverstanden()) {
                                b = 4;
                            } }
                        b++;

                    }while(b<4);
                    break;
                case 2: zimmerBelegungAnzeigen(); break;
                case 3: zimmerAnzeigen(); break;
                case 4: zimmerBelegungProzent(); break;
                case 5: zimmerBuchungAnzeigen(); break;
                case 6: buchungKundeAnzeigen(); break;
                case 7: rechnungErstellen(); break;
                case 8: neuenKundenAnlegen(); break;
                case 9: kundenAnzeigen(); break;
                default: break;
            }//end switch(auswahl)
        }//end for schleife des systems
    }//end main
    //
    //Methoden
    //
    //AUSWAHL MÖGLICHKEIT 1
    public static int abfrageZimmerart(){
        print("Welche Zimmerart möchten Sie buchen? Einzelzimmer: 1, Doppelzimmer: 2, Tripplezimmer: 3 oder Ferienwohnung: 4.");
        return s.nextInt();
    }//end Methode abfrageZimmerarte()
    public static boolean abfrageBalkon(){
        print("Möchten Sie ein Zimmer mit Balkon buchen? true, false.");
        return abfrageEinverstanden();
    }//end Methode abfrageBalkon()
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
    }//end Methode getBelegungEinzelzimmerBalkon()
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
    }//end Methode getBelegungEinzelzimmerBalkon()
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
    }//end Methode getBelegungEinzelzimmer()
    public static int getBelegungDoppelzimmer(Zimmer[]Belegung){
        if(!Belegung[2].getBelegt()){
            return Belegung[2].getZimmernummer();
        } else if(!Belegung[3].getBelegt()){
            return Belegung[3].getZimmernummer();
        } else print("Alle Doppelzimmer sind belegt.");
        return 0;
    }//end Methode getBelegungDoppelzimmer()
    public static int getBelegungTripplezimmer(Zimmer[]Belegung){
        if(!Belegung[4].getBelegt()){
            return Belegung[4].getZimmernummer();
        }else if(!Belegung[5].getBelegt()){
            return Belegung[5].getZimmernummer();
        }else print("Tripplezimmer belegt");
        return 0;
    }//end Methode getBelegungTripplezimmer()
    public static int getBelegungWohnung(Zimmer[]Belegung){
        if(!Belegung[6].getBelegt()){
            return Belegung[6].getZimmernummer();
        }else if(!Belegung[7].getBelegt()){
            return Belegung[7].getZimmernummer();
        }else print("Wohnungen belegt");
        return 0;
    }//end Methode getBelegungWohnung()
    public static boolean abfrageFruehstueck(){
        print("Moechten Sie Fruehstueck buchen?");
        return abfrageEinverstanden();
    }//end Methode abfrageFruehstueck()
    public static int abfrageAnzahlPersonen(){
        print("Wie viele Personen werden die Ferienwohnung belegen?");
        return s.nextInt();
    }//end Methode abfrageAnzahlPersonen()
    public static int abfrageAnzahlTage() {
        print("Wie viele Tage moechten Sie bleiben?");
        return s.nextInt();
    }//end Methode abfrageAnzahlTage()
    public static boolean abfrageHaustier(){
        print("Moechten Sie mit Haustier anreisen?");
        return abfrageEinverstanden();
    }//end Methode abfrageHaustier()
    public static boolean abfrageZimmerservice(){
        print("Moechten Sie zimmerservice buchen?");
        return abfrageEinverstanden();
    }//end Methode abfrageZimmerservice()
    public static int abfrageKundennummer(String name, String geburtsdatum){
        for(int i = k-1; i>0; i--){
            if((Kunden[i].getName().equals(name)) & (Kunden[i].getGeburtsdatum().equals(geburtsdatum))){
                return i;
            }
        }
        return 0;
    }//end Methode abfrageKundennummer()
    public static String abfrageName(){
        print("Bitte geben Sie Ihren Vor- und Nachnamen ein.");
        return sd.nextLine();
    }//end Methode abfrageName()
    public static String abfrageAnschrift(){

        print("Bitte geben Sie ihre Anschrift ein.");
        return sd.nextLine();
    }//end Methode abfrageAnschrift()
    public static String abfrageGeburtsdatum(){
        print("Bitte geben Sie ihr Geburtsdatum ein.");
        return s.next();
    }//end Methode abfrageGeburtsdatum()
    public static boolean abfragePremiumkunde(){
        print("Möchten Sie Premiumkunde werden?");
        return abfrageEinverstanden();
    }//end Methode abfragePremiumkunde()
    //
    //AUSWAHL MÖGLICHKEIT 2
    public static void zimmerBelegungAnzeigen(){
        print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
        Belegung[s.nextInt()-1].print();
    }//end Methode zimmerBelegungAnzeigen()
    //
    //AUSWAHL MÖGLICHKEIT 3
    public static void zimmerAnzeigen(){
        for(int c = 0; c<Belegung.length; c++){
            Belegung[c].print();
        }
    }//end Methode zimmerAnzeigen()
    //
    //AUSWAHL MÖGLICHKEIT 4
    public static void zimmerBelegungProzent(){
        double anzahlBelegt = 0;
        for(int o = 0; o<Belegung.length; o++){
            if(Belegung[o].getBelegt()){
                anzahlBelegt++;
            }
        }
        System.out.println("Das Hotel ist zu " + ((anzahlBelegt/Belegung.length)*100) + "% belegt.");
    }//end Methode zimmerBelegungProzent()
    //
    //AUSWAHL MÖGLICHKEIT 5
    public static void zimmerBuchungAnzeigen(){
        print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
        Buchungen[s.nextInt()-1].printBuchung();
    }//end Methode zimmerBuchungAnzeigen()
    //
    //AUSWAHL MÖGLICHKEIT 6
    public static void buchungKundeAnzeigen(){
        print("Bitte geben Sie den Vor- und Nachname des Kunden ein dessen Buchung Sie aufrufen moechten?");
        String name = sd.nextLine();
        for(int d = k-1; d>0; d--){
            if(Kunden[d].getName().equals(name)){
                Kunden[d].print();
                Buchungen[Kunden[d].getZimmernummer1()-1].print();
                if(Kunden[d].getZimmernummer2() != 0){
                    Buchungen[Kunden[d].getZimmernummer2()-1].print();
                }
                if(Kunden[d].getZimmernummer3() != 0){
                    Buchungen[Kunden[d].getZimmernummer3()-1].print();
                }
            }//end erstes if
        }//end for schleife
    }//end Methode buchungKundeAnzeigen()
    //
    //AUSWAHL MÖGLICHKEIT 7
    public static void rechnungErstellen(){
        double gesamtSumme = 0.00;
        print("Geben Sie die Zimmernummer ein für die Sie die Rechnung erstellen wollen.");
        int n = s.nextInt();
        if(Kunden[abfrageKundennummer(Buchungen[n-1].getName(), Buchungen[n-1].getGeburtsdatum())].getZimmernummer2() != 0){
            print("Moechten Sie fuer alle verknuepften Zimmer eine Rechnung drucken?");
            if(abfrageEinverstanden()){
                print("---Rechnung---");
                Buchungen[n-1].printKundendaten();
                Buchungen[n-1].print();
                gesamtSumme += Buchungen[n-1].getSumme();
                Buchungen[Kunden[abfrageKundennummer(Buchungen[n-1].getName(), Buchungen[n-1].getGeburtsdatum())].getZimmernummer2()].print();
                gesamtSumme += Buchungen[Kunden[abfrageKundennummer(Buchungen[n-1].getName(), Buchungen[n-1].getGeburtsdatum())].getZimmernummer2()].getSumme();
                if(Kunden[abfrageKundennummer(Buchungen[n-1].getName(), Buchungen[n-1].getGeburtsdatum())].getZimmernummer3() != 0){
                    Buchungen[Kunden[abfrageKundennummer(Buchungen[n-1].getName(), Buchungen[n-1].getGeburtsdatum())].getZimmernummer3()].print();
                    gesamtSumme += Buchungen[Kunden[abfrageKundennummer(Buchungen[n-1].getName(), Buchungen[n-1].getGeburtsdatum())].getZimmernummer3()].getSumme();
                }
                printSumme(gesamtSumme);
            }
        }else {
            print("---Rechnung---");
            Buchungen[n-1].printKundendaten();
            Buchungen[n-1].print();
            printSumme(Buchungen[n-1].getSumme());
        }
    }//end Methode rechnungErstellen()
    //
    //AUSWAHL MÖGLICHKEIT 8
    public static void neuenKundenAnlegen(){
        String name = abfrageName();
        String geburtsdatum = abfrageGeburtsdatum();
        int kundennummer = abfrageKundennummer(name, geburtsdatum);
        if(kundennummer != 0){
            Kunden[kundennummer].print();
        } else {
            String anschrift = abfrageAnschrift(); boolean premiumkunde = abfragePremiumkunde();
            Kunden[k] = new Kunde(name, anschrift, geburtsdatum, premiumkunde, 0);
            Kunden[k].print();
            k++;
        }
    }//end Methode neuenKundenAnlegen()
    //
    //AUSWAHL MÖGLICHKEIT 9
    public static void kundenAnzeigen(){
        print("Bitte geben Sie den Vor- und Nachname des Kunden ein dessen Kundendaten Sie aufrufen moechten?");
        String name = sd.nextLine();
        for(int d = k-1; d>0; d--){
            if(Kunden[d].getName().equals(name)){
                Kunden[d].print();
                if(Kunden[d].getZimmernummer1() != 0){
                    System.out.println("Zimmer " + Kunden[d].getZimmernummer1());
                }
                if(Kunden[d].getZimmernummer2() != 0){
                    System.out.println("Zimmer " + Kunden[d].getZimmernummer2());
                }
                if(Kunden[d].getZimmernummer3() != 0){
                    System.out.println("Zimmer " + Kunden[d].getZimmernummer3());
                }
            }//end erstes if
        }//end for schleife
    }//end Methode kundenAnzeigen()
    //
    //Methode zur Ausgabe der übergebenen Summe inkl. MwSt.
    public static void printSumme(double summe){
        System.out.println("Summe: " + dF.format(summe) + "€ inkl. " + dF.format(summe*0.19) + "€ MwSt.");
    }//end Methode printSumme()
    //
    //Methode zur vereinfachung der Abfrage bei Auswahlmöglichkeiten
    public static boolean abfrageEinverstanden(){
        print("JA | NEIN");
        boolean einverstanden;
        String input = s.next();
        if(input.equals("Ja") | input.equals("ja") | input.equals("j")){
            einverstanden = true;
        }else if(input.equals("Nein") | input.equals("nein") | input.equals("n")){
            einverstanden = false;
        }else einverstanden = false;
        return einverstanden;
    }//end Methode abfrageEinverstanden()
    //
    //Methode zur Erzeugung der Anfangsbelegung
    public static void belegungErzeugen(){
        for(int i = 0; i<Belegung.length; i++){
            switch(i){
                case 0:
                    Belegung[i] = new Einzelzimmer(1, true); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(1, 1, 1, 3); Buchungen[i].setBalkon(true);Buchungen[i].setFruehstueck(true);
                    Buchungen[i].setName("Moritz Meier"); Buchungen[i].setAnschrift("Konrad-Adenauer-Allee 31, 53111 Bonn");
                    Buchungen[i].setGeburtsdatum("28.04.1974"); Buchungen[i].setPremiumkunde(true); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Moritz Meier", "Konrad-Adenauer-Allee 31, 53111 Bonn", "28.04.1974", true, 1);
                    k++;
                    break;
                case 1:
                    Belegung[i] = new Einzelzimmer(2, 1, 50.00, 2, true, false); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(2, 1, 1, 2); Buchungen[i].setBalkon(false); Buchungen[i].setFruehstueck(true);
                    Buchungen[i].setName("Maria Müller"); Buchungen[i].setAnschrift("Hohe Str. 32, 51069 Köln");
                    Buchungen[i].setGeburtsdatum("04.12.1968"); Buchungen[i].setPremiumkunde(false); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Maria Müller", "Hohe Str. 32, 51069 Köln", "04.12.1968", false, 2);
                    k++;
                    break;
                case 2:
                    Belegung[i] = new Doppelzimmer(3, true, false); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(3, 2, 2, 7); Buchungen[i].setBalkon(true); Buchungen[i].setFruehstueck(false);
                    Buchungen[i].setName("Olaf Scholz"); Buchungen[i].setAnschrift("Willy-Brandt-Str. 1, 10557 Berlin");
                    Buchungen[i].setGeburtsdatum("14.06.1958"); Buchungen[i].setPremiumkunde(true); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Olaf Scholz", "Willy-Brandt-Straße 1, 10557 Berlin", "14.06.1958", true, 3);
                    k++;
                    break;
                case 3:
                    Belegung[i] = new Doppelzimmer(4, false, false); Belegung[i].setBelegt(false);
                    break;
                case 4:
                    Belegung[i] = new Tripplezimmer(5); Belegung[i].setBelegt(false);
                    break;
                case 5:
                    Belegung[i] = new Tripplezimmer(6); Belegung[i].setBelegt(false);
                    break;
                case 6:
                    Belegung[i] = new Wohnung(7); Belegung[i].setBelegt(false);
                    break;
                case 7:
                    Belegung[i] = new Wohnung(8); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(8, 4, 5, 4); Buchungen[i].setHaustier(false); Buchungen[i].setZimmerservice(true);
                    Buchungen[i].setName("Anelise Mond"); Buchungen[i].setAnschrift("Mondstr. 17, 68730 Mond");
                    Buchungen[i].setGeburtsdatum("01.01.0000"); Buchungen[i].setPremiumkunde(false); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Anelise Mond", "Mondstr. 17 68730 Mond", "01.01.0000", false, 8);
                    k++;
                    break;
                default: break;
            }//end switch
        }//end for
    }//end Methode belegungErzeugen()
}//end class