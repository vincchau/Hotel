import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static DecimalFormat dF = new DecimalFormat("#.00");
    public static Scanner s = new Scanner(System.in);//Deklaration eines Scanners für die gesamte main Class
    public static Scanner sd = new Scanner(System.in).useDelimiter("\s");//Deklaration eines Scanners mit delimiter zur überbrückung von leerzeichen
    public static void print(String p){System.out.println(p);}//Print funktion zum Abkürzen des Schreibaufwands
    public static int k = 1;//Deklaration und initialisierung einer laufvariable. Verwendet als kundennummer
    //
    //Deklaration der notwendigen Arrays:
    //Class Kunde zur speicherung der Kundendaten
    //Class Zimmer zur speicherung der einzelnen Zimmerdaten
    //Class Buchung zur speicherung der einzelnen Buchungen
    private static Kunde [] Kunden = new Kunde[100];//Zum Ablegen der Kundedaten
    private static Zimmer [] Belegung = new Zimmer[8];//Zum Ablegen der einzelnen Zimmer
    private static Buchung [] Buchungen = new Buchung[8];//zum Ablegen der einzelnen Buchungen an sich
    public static void main(String[] args) {
        //
        //Anfangsbelegung erzeugen
        belegungErzeugen();
        //
        //For Schleife des Systems
        for(int i = 0; i<100; i++){
            //
            //Start der Abfrage Auswahl
            print("Was möchten Sie aufrufen?");
            print("1. Buchung ausführen, 2. Belegung eines Zimmers anzeigen, 3. Alle Zimmer anzeigen, 4. Zimmerbelegung in Prozent anzeigen, 5. Buchung eines Zimmers anzeigen \n" +
                    "6. Buchungen eines Kunden anzeigen, 7. Rechnung für ein Zimmer erstellen, 8. Kunde anlegen, 9. Kunden anzeigen, 10. Gesamtrechnung für einen Kunden erstellen.");
            int auswahl = s.nextInt();
            switch(auswahl){
                case 1: buchungAusfuehren(); break;
                case 2: zimmerBelegungAnzeigen(); break;
                case 3: zimmerAnzeigen(); break;
                case 4: zimmerBelegungProzent(); break;
                case 5: zimmerBuchungAnzeigen(); break;
                case 6: buchungKundeAnzeigen(); break;
                case 7: rechnungZimmerErstellen(); break;
                case 8: neuenKundenAnlegen(); break;
                case 9: kundenAnzeigen(); break;
                case 10: rechnungKundeErstellen(); break;
                default: break;
            }//end switch(auswahl)
        }//end for schleife des systems
    }//end main
    //
    //Methoden
    //
    //AUSWAHL MÖGLICHKEIT 1 - Ausführen einer Buchung eines Zimmers
    public static void buchungAusfuehren(){
        //Deklaration der notwendigen Variablen
        int kundennummer = 0, b = 1;
        while(b<4) {
            int preiskategorie, zimmernummer = 0, anzahlPersonen = 7, anzahlTage = 0;
            boolean balkon = false, einzelzimmerzuschlag = false, fruehstueck = false, haustier = false, zimmerservice = false;
            preiskategorie = abfrageZimmerart();
            switch (preiskategorie) {
                case 1:
                    balkon = abfrageBalkon();
                    if (balkon) {
                        zimmernummer = getBelegungEinzelzimmerBalkon(Belegung);
                        if (zimmernummer == 0) {
                            print("Ende der Buchung!");
                            break;
                        }
                        if (zimmernummer == 2 | zimmernummer == 4) {
                            balkon = false;
                        }
                        if (zimmernummer > 2) {
                            einzelzimmerzuschlag = true;
                            preiskategorie = 2;
                        }
                    } else {
                        zimmernummer = getBelegungEinzelzimmer(Belegung);
                        if (zimmernummer == 0) {
                            print("Ende der Buchung!");
                            break;
                        }
                        if(zimmernummer > 2) {
                            einzelzimmerzuschlag = true;
                            preiskategorie = 2;
                        }
                    }//end if(balkon) und abfrage zimmernummer inklusive festlegung des einzelzimmerzuschlags.
                    fruehstueck = abfrageFruehstueck();
                    anzahlPersonen = 1;
                    anzahlTage = abfrageAnzahlTage();
                    break;
                case 2:
                    balkon = abfrageBalkon();
                    if (balkon) {
                        zimmernummer = getBelegungDoppelzimmerBalkon(Belegung);
                        if (zimmernummer == 0) {
                            break;
                        }
                        if (zimmernummer == 4) {
                            balkon = false;
                        }
                    } else {
                        zimmernummer = getBelegungDoppelzimmer(Belegung);
                        if (zimmernummer == 0) {
                            break;
                        }
                    }//end if(balkon)
                    fruehstueck = abfrageFruehstueck();
                    anzahlPersonen = 2;
                    anzahlTage = abfrageAnzahlTage();
                    break;
                case 3:
                    zimmernummer = getBelegungTripplezimmer(Belegung);
                    if (zimmernummer == 0) {
                        break;
                    }
                    fruehstueck = abfrageFruehstueck();
                    anzahlPersonen = 3;
                    anzahlTage = abfrageAnzahlTage();
                    break;
                case 4:
                    zimmernummer = getBelegungWohnung(Belegung);
                    if (zimmernummer == 0) {
                        break;
                    }
                    while (anzahlPersonen > 6) {
                        anzahlPersonen = abfrageAnzahlPersonen();
                        if (anzahlPersonen > 6) {
                            print("Ferienwohnungen koennen für maximal 6 Personen gebucht werden.");
                        }
                    }
                    while (anzahlTage < 3) {
                        anzahlTage = abfrageAnzahlTage();
                        if (anzahlTage < 3) {
                            print("Ferienwohnungen muessen fuer mindestens 3 Tage gebucht werden.");
                        }
                    }
                    haustier = abfrageHaustier();
                    zimmerservice = abfrageZimmerservice();
                    break;
                default:
                    break;
            }//end switch(preiskategorie)
            if (zimmernummer == 0) {
                b = 4;
            } else {
                if(kundennummer == 0) {
                    kundennummer = neuenKundenAnlegen();
                }
                if (Kunden[kundennummer].getZimmernummer1() != 0) {
                    if (Kunden[kundennummer].getZimmernummer2() != 0) {
                        if (Kunden[kundennummer].getZimmernummer3() != 0) {
                            print("Sie können nicht mehr als 3 Zimmer gleichzeitig Buchen!");
                            b = 4;
                        } else {
                            Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage, balkon, einzelzimmerzuschlag, fruehstueck, haustier, zimmerservice, Kunden[kundennummer].getName(), Kunden[kundennummer].getAnschrift(), Kunden[kundennummer].getGeburtsdatum(), Kunden[kundennummer].getPremiumkunde());
                            System.out.println("Moechten Sie die gewaehlte Unterkunft jetzt zum Preis von " + dF.format(Buchungen[zimmernummer-1].getSumme()) + "€ buchen?");
                            if(abfrageEinverstanden()){
                                Kunden[kundennummer].setZimmernummer3(zimmernummer);
                                Belegung[zimmernummer-1].setBelegt(true);
                            }else Buchungen[zimmernummer-1] = new Buchung();
                            b = 4;
                        }
                    } else {
                        Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage, balkon, einzelzimmerzuschlag, fruehstueck, haustier, zimmerservice, Kunden[kundennummer].getName(), Kunden[kundennummer].getAnschrift(), Kunden[kundennummer].getGeburtsdatum(), Kunden[kundennummer].getPremiumkunde());
                        print("Moechten Sie die ausgewaehlte Unterkunft jetzt zum Preis von " + dF.format(Buchungen[zimmernummer-1].getSumme()) + "€ buchen?");
                        if(abfrageEinverstanden()){
                            Kunden[kundennummer].setZimmernummer2(zimmernummer);
                            Belegung[zimmernummer-1].setBelegt(true);
                            b = 2;
                        }else {Buchungen[zimmernummer-1] = new Buchung(); b = 4;}
                    }
                } else {
                    Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage, balkon, einzelzimmerzuschlag, fruehstueck, haustier, zimmerservice, Kunden[kundennummer].getName(), Kunden[kundennummer].getAnschrift(), Kunden[kundennummer].getGeburtsdatum(), Kunden[kundennummer].getPremiumkunde());
                    print("Moechten Sie die ausgewaehlte Unterkunft jetzt zum Preis von " + dF.format(Buchungen[zimmernummer-1].getSumme()) + "€ buchen?");
                    if(abfrageEinverstanden()){
                        Kunden[kundennummer].setZimmernummer1(zimmernummer);
                        Belegung[zimmernummer-1].setBelegt(true);
                        b = 1;
                    }else {Buchungen[zimmernummer-1] = new Buchung(); b = 4;}
                }
            }//end if(zimmernummer == 0) else
            if(b<4){
                print("Moechten Sie weitere Unterkuenfte buchen?");
                if(abfrageEinverstanden()){
                    b++;
                }else b = 4;
            }
        }//end while(b)
    }//end Methode buchungAusfuehren(b)
    //fragt nach welche Zimmerart sie gerne buchen würden
    public static int abfrageZimmerart(){
        print("Welche Zimmerart möchten Sie buchen? 1. Einzelzimmer, 2. Doppelzimmer, 3. Tripplezimmer oder 4. Ferienwohnung");
        return s.nextInt();
    }//end Methode abfrageZimmerart()
    //klärt die Balkon Frage fragt also nach ob Balkon erwünscht ist ja oder nein
    public static boolean abfrageBalkon(){
        print("Möchten Sie ein Zimmer mit Balkon buchen?");
        return abfrageEinverstanden();
    }//end Methode abfrageBalkon()
    //prüft ob ein Einzelzimmer frei ist bzw. schlägt das passende nicht Einzelzimmer vor, was dann eben ein Doppelzimmer wäre.
    //Fragt dann ob man damit dann einverstanden ist.
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
    //prüft ob ein Doppelzimmer mit Balkon frei ist und fragt nach Einverständnis
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
    //prüft ob ein Einzelzimmer frei ist und fragt nach Einverständnis, wenn alle Einzelzimmer belegt ist fragt er nach Doppelzimmer einverständnis
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
    //prüft ob ein Doppelzimmer frei ist, wenn alle Zimmer der Kategorie belegt sind wird ausgegeben Alle belegt
    public static int getBelegungDoppelzimmer(Zimmer[]Belegung){
        if(!Belegung[2].getBelegt()){
            return Belegung[2].getZimmernummer();
        } else if(!Belegung[3].getBelegt()){
            return Belegung[3].getZimmernummer();
        } else print("Alle Doppelzimmer sind belegt.");
        return 0;
    }//end Methode getBelegungDoppelzimmer()
    //prüft ob ein Tripplezimmer frei ist, wenn alle Zimmer der Kategorie belegt sind wird ausgegeben Alle belegt
    public static int getBelegungTripplezimmer(Zimmer[]Belegung){
        if(!Belegung[4].getBelegt()){
            return Belegung[4].getZimmernummer();
        }else if(!Belegung[5].getBelegt()){
            return Belegung[5].getZimmernummer();
        }else print("Tripplezimmer belegt");
        return 0;
    }//end Methode getBelegungTripplezimmer()
    //prüft ob eine Wohnung frei ist, wenn alle Zimmer der Kategorie belegt sind wird ausgegeben Alle belegt
    public static int getBelegungWohnung(Zimmer[]Belegung){
        if(!Belegung[6].getBelegt()){
            return Belegung[6].getZimmernummer();
        }else if(!Belegung[7].getBelegt()){
            return Belegung[7].getZimmernummer();
        }else print("Wohnungen belegt");
        return 0;
    }//end Methode getBelegungWohnung()
    //fragt den Kunden ob er Frühstück möchte
    public static boolean abfrageFruehstueck(){
        print("Moechten Sie Fruehstueck buchen?");
        return abfrageEinverstanden();
    }//end Methode abfrageFruehstueck()
    //fragt den Kunden mit wie vielen Personen die Wohnung gebucht wird
    public static int abfrageAnzahlPersonen(){
        print("Wie viele Personen werden die Ferienwohnung belegen?");
        return s.nextInt();
    }//end Methode abfrageAnzahlPersonen()
    //fragt den Kunden, wie lange er bleiben möchte
    public static int abfrageAnzahlTage() {
        print("Wie viele Tage moechten Sie bleiben?");
        return s.nextInt();
    }//end Methode abfrageAnzahlTage()
    //fragt ob der Kunde mit Haustier reisen möchte
    public static boolean abfrageHaustier(){
        print("Moechten Sie mit Haustier anreisen?");
        return abfrageEinverstanden();
    }//end Methode abfrageHaustier()
    //fragt ob der Kunde gerne Zimmerservice hätte
    public static boolean abfrageZimmerservice(){
        print("Moechten Sie zimmerservice buchen?");
        return abfrageEinverstanden();
    }//end Methode abfrageZimmerservice()
     //vergleicht bereits eingegeben Namen und Geburtsdaten mit den aktuell eingegeben um somit auszuschließen, dass zu viele Kunden angelegt werden.
    public static int abfrageKundennummer(String name, String geburtsdatum){
        for(int i = k-1; i>0; i--){
            if((Kunden[i].getName().equals(name)) & (Kunden[i].getGeburtsdatum().equals(geburtsdatum))){
                return i;
            }
        }
        return 0;
    }//end Methode abfrageKundennummer()
    //bittet den Kunden seinen Namen einzugeben
    public static String abfrageName(){
        print("Bitte geben Sie Ihren Vor- und Nachnamen ein.");
        return sd.nextLine();
    }//end Methode abfrageName()
     //bittet den Kunden seine Adresse einzugeben
    public static String abfrageAnschrift(){

        print("Bitte geben Sie ihre Anschrift ein.");
        return sd.nextLine();
    }//end Methode abfrageAnschrift()
    //bittet den Kunden sein Geburtsdatum eizugeben
    public static String abfrageGeburtsdatum(){
        print("Bitte geben Sie ihr Geburtsdatum ein.");
        return s.next();
    }//end Methode abfrageGeburtsdatum()
    //fragt den Kunden ob er gerne Premiumkunde werden möchte
    public static boolean abfragePremiumkunde(){
        print("Möchten Sie Premiumkunde werden?");
        return abfrageEinverstanden();
    }//end Methode abfragePremiumkunde()
    //Ende der ersten Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 2
    //fragt nach für welches Zimmer man gerne die Belegung sehen würde.
    //Nach einer Eingabe einer Zahl gibt er dann die Belegung für das Zimmer mit der Zimmernummer aus, welche man eingegeben hat.
    public static void zimmerBelegungAnzeigen(){
        print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
        Belegung[s.nextInt()-1].print();
    }//end Methode zimmerBelegungAnzeigen()
    //Ende Auswahl Möglichkeit 2
    //
    //AUSWAHL MÖGLICHKEIT 3
    //gibt die Attribute des Zimmers wieder, für das Zimmer das man aufruft.
    public static void zimmerAnzeigen(){
        for(int c = 0; c<Belegung.length; c++){
            Belegung[c].print();
        }
    }//end Methode zimmerAnzeigen()
    //Ende der dritten Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 4
    //gibt die Belegung des Hotel in % aus
    public static void zimmerBelegungProzent(){
        double anzahlBelegt = 0;
        for(int o = 0; o<Belegung.length; o++){
            if(Belegung[o].getBelegt()){
                anzahlBelegt++;
            }
        }
        System.out.println("Das Hotel ist zu " + ((anzahlBelegt/Belegung.length)*100) + "% belegt.");
    }//end Methode zimmerBelegungProzent()
    //Ende der vierten Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 5
    //zeigt die Buchung für ein spezielles Zimmer auf abhängig von der Zahl die man eingibt
    public static void zimmerBuchungAnzeigen(){
        print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
        Buchungen[s.nextInt()-1].printBuchung();
    }//end Methode zimmerBuchungAnzeigen()
    //Ende der fünften Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 6
    //bittet um Eingabe eines Namens und gibt dann für den Kunden die dazu gehörigen Zimmer aus, die die Person gebucht hat
    public static void buchungKundeAnzeigen(){
        print("Bitte geben Sie den Vor- und Nachname des Kunden ein dessen Buchung Sie aufrufen moechten?");
        String name = sd.nextLine();
        for(int d = k-1; d>0; d--){
            if(Kunden[d].getName().equals(name)){
                Kunden[d].print();
                if(Kunden[d].getZimmernummer1() != 0){
                    Buchungen[Kunden[d].getZimmernummer1()-1].print();
                }
                if(Kunden[d].getZimmernummer2() != 0){
                    Buchungen[Kunden[d].getZimmernummer2()-1].print();
                }
                if(Kunden[d].getZimmernummer3() != 0){
                    Buchungen[Kunden[d].getZimmernummer3()-1].print();
                }
            }//end if(namensvergleich)
        }//end for schleife
    }//end Methode buchungKundeAnzeigen()
    //Ende der sechsten Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 7
    //Gibt die gesamt für ein Zimmer aus, mit allen wichtigen Daten,
    //bzw. gibt aus Zimmer nicht belegt, wenn noch keine Buchung für das Zimmer statt fand
    public static void rechnungZimmerErstellen(){
        print("Geben Sie die Zimmernummer ein für die Sie die Rechnung erstellen wollen.");
        int r = s.nextInt();
        if(Belegung[r-1].getBelegt()){
            print("---Rechnung---");
            Buchungen[r - 1].printKundendaten();
            Buchungen[r - 1].print();
            printSumme(Buchungen[r - 1].getSumme(), Buchungen[r-1].getPremiumkunde());
        }else print("Das Zimmer ist nicht belegt");
    }//end Methode rechnungZimmerErstellen()
    //Ende der siebten Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 8
    //Ermöglicht das Anlegen eines neuen Kunden solange der Kunde bisher noch nicht existiert.
    //Falls Kunde bereits existiert wird ein Fehler bzw. den Kunden gibt es schon ausgegeben.
    public static int neuenKundenAnlegen(){
        String name = abfrageName();
        String geburtsdatum = abfrageGeburtsdatum();
        int kundennummer = abfrageKundennummer(name, geburtsdatum);
        if(kundennummer != 0){
            print("Dieser Kunde existiert bereits.");
        } else {
            String anschrift = abfrageAnschrift(); boolean premiumkunde = abfragePremiumkunde();
            Kunden[k] = new Kunde(name, anschrift, geburtsdatum, premiumkunde);
            kundennummer = k;
            k++;
            print("Neuer Kunde angelegt.");
        }
        return kundennummer;
    }//end Methode neuenKundenAnlegen()
    //Ende der achten Auswahl Möglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 9
    //Gibt alle zugehörigen Kundendaten aus, sowie die Zimmer die die Person gebucht hat
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
    //Ende der neunten Auswahl Möglichkeit
    //AUSWAHL MÖGLICHKEIT 10
    //Erstellung einer gesamt Rechnung für den dazu gehörigen Kunden, denn man eingeben muss
    public static void rechnungKundeErstellen(){
        int kundennummer = 0; double gesamtSumme = 0.0;
        print("Geben Sie den Vor- und Nachnamen des Kunden ein fuer den Sie eine Gesamtrechnung erstellen wollen.");
        String name = sd.nextLine();
        for(int r = k-1; r>0; r--){
            if(Kunden[r].getName().equals(name) & ((Kunden[r].getZimmernummer1() != 0) | (Kunden[r].getZimmernummer2() != 0) | (Kunden[r].getZimmernummer3() != 0))) {
                kundennummer = r;
            }
        }//end for Schleife
        if(kundennummer != 0){
            print("---Rechnung---");
            Kunden[kundennummer].print();
            if(Kunden[kundennummer].getZimmernummer1() != 0){
                Buchungen[Kunden[kundennummer].getZimmernummer1()-1].print();
                gesamtSumme += Buchungen[Kunden[kundennummer].getZimmernummer1()-1].getSumme();
            }
            if(Kunden[kundennummer].getZimmernummer2() != 0){
                Buchungen[Kunden[kundennummer].getZimmernummer2()-1].print();
                gesamtSumme += Buchungen[Kunden[kundennummer].getZimmernummer2()-1].getSumme();
            }
            if(Kunden[kundennummer].getZimmernummer3() != 0){
                Buchungen[Kunden[kundennummer].getZimmernummer3()-1].print();
                gesamtSumme += Buchungen[Kunden[kundennummer].getZimmernummer3()-1].getSumme();
            }
            printSumme(gesamtSumme, Kunden[kundennummer].getPremiumkunde());
        }else print("Fuer diesen Kunden liegt keine Buchung vor.");
    }//end Methode rechnungKundeErstellen()
    //Ende der zehnten Auswahl Möglichkeit
    //
    //Methode zur Ausgabe der übergebenen Summe inkl. MwSt.
    public static void printSumme(double summe, boolean premiumkunde){
        System.out.println("Netto: " + dF.format(Math.round((summe/1.19)*100)/100) + "€");
        if(premiumkunde){
            System.out.println("Netto ohne Premiumkundenrabatt: " + dF.format(Math.round((summe/1.19/0.95)*100.00)/100.00) + "€");
        }
        System.out.println("MwSt.: " + dF.format(Math.round((summe - summe / 1.19)*100.00)/100.00) + "€");
        System.out.println("Brutto: " + dF.format(Math.round(summe*100)/100) + "€");
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
                    Belegung[i] = new Einzelzimmer(i+1, true); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(i+1, 1, 1, 3); Buchungen[i].setBalkon(true);Buchungen[i].setFruehstueck(true);
                    Buchungen[i].setName("Moritz Meier"); Buchungen[i].setAnschrift("Konrad-Adenauer-Allee 31, 53111 Bonn");
                    Buchungen[i].setGeburtsdatum("28.04.1974"); Buchungen[i].setPremiumkunde(true); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Moritz Meier", "Konrad-Adenauer-Allee 31, 53111 Bonn", "28.04.1974", true, i+1);
                    k++;
                    break;
                case 1:
                    Belegung[i] = new Einzelzimmer(i+1, 1, 50.00, 2, true, false); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(i+1, 1, 1, 2); Buchungen[i].setBalkon(false); Buchungen[i].setFruehstueck(true);
                    Buchungen[i].setName("Maria Müller"); Buchungen[i].setAnschrift("Hohe Str. 32, 51069 Köln");
                    Buchungen[i].setGeburtsdatum("04.12.1968"); Buchungen[i].setPremiumkunde(false); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Maria Müller", "Hohe Str. 32, 51069 Köln", "04.12.1968", false, i+1);
                    k++;
                    break;
                case 2:
                    Belegung[i] = new Doppelzimmer(i+1, true, false); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(i+1, 2, 2, 7); Buchungen[i].setBalkon(true); Buchungen[i].setFruehstueck(false);
                    Buchungen[i].setName("Olaf Scholz"); Buchungen[i].setAnschrift("Willy-Brandt-Str. 1, 10557 Berlin");
                    Buchungen[i].setGeburtsdatum("14.06.1958"); Buchungen[i].setPremiumkunde(true); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Olaf Scholz", "Willy-Brandt-Straße 1, 10557 Berlin", "14.06.1958", true, i+1);
                    k++;
                    break;
                case 3:
                    Belegung[i] = new Doppelzimmer(i+1, false, false); Belegung[i].setBelegt(false);
                    break;
                case 4, 5:
                    Belegung[i] = new Tripplezimmer(i+1); Belegung[i].setBelegt(false);
                    break;
                case 6:
                    Belegung[i] = new Wohnung(i+1); Belegung[i].setBelegt(false);
                    break;
                case 7:
                    Belegung[i] = new Wohnung(i+1); Belegung[i].setBelegt(true);
                    Buchungen[i] = new Buchung(i+1, 4, 5, 4); Buchungen[i].setHaustier(false); Buchungen[i].setZimmerservice(true);
                    Buchungen[i].setName("Anelise Mond"); Buchungen[i].setAnschrift("Mondstr. 17, 68730 Mond");
                    Buchungen[i].setGeburtsdatum("01.01.0000"); Buchungen[i].setPremiumkunde(false); Buchungen[i].setSumme();
                    Kunden[k] = new Kunde("Anelise Mond", "Mondstr. 17 68730 Mond", "01.01.0000", false, i+1);
                    k++;
                    break;
                default: break;
            }//end switch
        }//end for
    }//end Methode belegungErzeugen()
}//end class
