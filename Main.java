//Import der notwendigen Java Libraries.
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static DecimalFormat dF = new DecimalFormat("#.00");//Deklaration und Initialisierung eines Formats zur richtigen darstellung der Summen.
    public static Scanner s = new Scanner(System.in);//Deklaration und Initialisierung eines Scanners für die gesamte main Class.
    public static Scanner sd = new Scanner(System.in).useDelimiter("\s");//Deklaration und Initialisierung eines Scanners mit Delimiter zur überbrückung von leerzeichen.
    public static void print(String p){System.out.println(p);}//Print-Methode zum Abkürzen des Schreibaufwands.
    public static int k = 1;//Deklaration und initialisierung einer laufvariable. Verwendet als Kundennummer.
    //
    //Deklaration der notwendigen Arrays...
    private static Kunde [] Kunden = new Kunde[100];//...zur speicherung der Kundendaten.
    private static Zimmer [] Belegung = new Zimmer[8];//...zur speicherung der einzelnen Zimmerdaten.
    private static Buchung [] Buchungen = new Buchung[8];//...zur speicherung der einzelnen Buchungen.
    public static void main(String[] args) {
        //
        belegungErzeugen();//Die vorgegebene Anfangsbelegung wird erzeugt.
        //
        while(true){//Start der While-Schleife in der die Menüauswahl läuft.
            //
            //Start der Abfrage der Menüauswahl
            print("##########Menü##########");
            print("1. Buchung ausführen, 2. Belegung eines Zimmers anzeigen, 3. Alle Zimmer anzeigen, 4. Zimmerbelegung in Prozent anzeigen, 5. Buchung eines Zimmers anzeigen \n" +
                    "6. Buchungen eines Kunden anzeigen, 7. Rechnung für ein Zimmer erstellen, 8. Kunde anlegen, 9. Kunden anzeigen, 10. Gesamtrechnung für einen Kunden erstellen.");
            int auswahl = s.nextInt();//Eingabe des zu öffnenden Menüs.
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
        }//end While-Schleife der Menüauswahl.
    }//end main
    //
    //Methoden
    //
    //AUSWAHL MÖGLICHKEIT 1 - Ausführen einer Buchung eines Zimmers
    public static void buchungAusfuehren(){
        //Deklaration und Initialisierung der notwendigen Variablen die außerhalb der While-Schleife bestehen müssen.
        int kundennummer = 0, b = 1;
        while(b<4) {//Start der While-Schleife die bei maximal 3 möglichen Buchungen endet.
            //Deklaration und Initialisierung der notwendigen Variablen.
            int preiskategorie, zimmernummer = 0, anzahlPersonen = 7, anzahlTage = 0;
            boolean balkon = false, einzelzimmerzuschlag = false, fruehstueck = false, haustier = false, zimmerservice = false;
            preiskategorie = abfrageZimmerart();//Eingabe der gewünschten Zimmerkategorie.
            switch (preiskategorie) {//Start der von Zimmer zu Zimmer unterschiedlichen Abfragen.
                case 1://Für ein Einzelzimmer...
                    balkon = abfrageBalkon();//...wird abgefragt, ob ein Balkon gewünscht ist.
                    if (balkon) {//Wenn ja, ...
                        zimmernummer = getBelegungEinzelzimmerBalkon();//...wird eine Zimmernummer gespeichert abhängig von der Belegung der Zimmerkategorie.
                        if (zimmernummer == 0) {//Wenn kein Zimmer der Zimmerkategorie frei ist, ...
                            print("Ende der Buchung!");//...wird ein Hinweis ausgegeben...
                            break;//...und die Buchung beendet.
                        }
                        if (zimmernummer == 2 | zimmernummer == 4) {//Wenn der Kunde mit einem Einzel- oder Doppelzimmer ohne Balkon einverstanden war, ...
                            balkon = false;//...wird der Balkonwunsch zurückgesetzt.
                        }
                        if (zimmernummer > 2) {//Wenn der Kunde mit einem Doppelzimmer einverstanden war, ...
                            einzelzimmerzuschlag = true;//...wird der Einzelzimmerzuschlag gespeichert...
                            preiskategorie = 2;//...und die Preiskategorie für spätere Berechnungen abgelegt.
                        }
                    } else {//Wenn nein, ...
                        zimmernummer = getBelegungEinzelzimmer();//...wird eine Zimmernummer gespeichert abhängig von der Belegung der Zimmerkategorie.
                        if (zimmernummer == 0) {//Wenn kein Zimmer der Zimmerkategorie frei ist, ...
                            print("Ende der Buchung!");//...wird ein Hinweis ausgegeben...
                            break;//...und die Buchung beendet.
                        }
                        if(zimmernummer > 2) {//Wenn der Kunde mit einem Doppelzimmer einverstanden war, ...
                            einzelzimmerzuschlag = true;//...wird der Einzelzimmerzuschlag gespeichert...
                            preiskategorie = 2;//...und die Preiskategorie für spätere Berechnungen abgelegt.
                        }
                    }//end if(balkon) else
                    fruehstueck = abfrageFruehstueck();//Dann wird abgefragt, ob das Einzel- oder Doppelzimmer mit Frühstück, ...
                    anzahlTage = abfrageAnzahlTage();//...und wie lange gebucht werden soll.
                    anzahlPersonen = 1;//Außerdem wird die Personenzahl für spätere Berechnungen abgelegt.
                    break;
                case 2://Für Doppelzimmer...
                    balkon = abfrageBalkon();//...wird abgefragt, ob ein Balkon gewünscht ist.
                    if (balkon) {//Wenn ja, ...
                        zimmernummer = getBelegungDoppelzimmerBalkon();//...wird eine Zimmernummer gespeichert abhängig von der Belegung der Zimmerkategorie.
                        if (zimmernummer == 0) {//Wenn kein Zimmer der Zimmerkategorie frei ist, ...
                            print("Ende der Buchung!");//...wird ein Hinweis ausgegeben...
                            break;//...und die Buchung beendet.
                        }
                        if (zimmernummer == 4) {//Wenn der Kunde mit einem Doppelzimmer ohne Balkon einverstanden war, ...
                            balkon = false;//...wird der Balkonwunsch zurückgesetzt.
                        }
                    } else {//Wenn nein, ...
                        zimmernummer = getBelegungDoppelzimmer();//...wird eine Zimmernummer gespeichert abhängig von der Belegung der Zimmerkategorie.
                        if (zimmernummer == 0) {//Wenn kein Zimmer der Zimmerkategorie frei ist, ...
                            print("Ende der Buchung!");//...wird ein Hinweis ausgegeben...
                            break;//...und die Buchung beendet.
                        }
                    }//end if(balkon) else
                    fruehstueck = abfrageFruehstueck();//Dann wird abgefragt, ob das Doppelzimmer mit Frühstück, ...
                    anzahlTage = abfrageAnzahlTage();//...und wie lange gebucht werden soll.
                    anzahlPersonen = 2;//Außerdem wird die Personenzahl für spätere Berechnungen abgelegt.
                    break;
                case 3://Für Tripplezimmer...
                    zimmernummer = getBelegungTripplezimmer();//...wird eine Zimmernummer gespeichert abhängig von der Belegung der Zimmerkategorie.
                    if (zimmernummer == 0) {//Wenn kein Zimmer der Zimmerkategorie frei ist, ...
                        print("Ende der Buchung!");//...wird ein Hinweis ausgegeben...
                        break;//...und die Buchung beendet.
                    }
                    fruehstueck = abfrageFruehstueck();//Dann wird abgefragt, ob das Tripplezimmer mit Frühstück, ...
                    anzahlTage = abfrageAnzahlTage();//...und wie lange gebucht werden soll.
                    anzahlPersonen = 3;//Außerdem wird die Personenzahl für spätere Berechnungen abgelegt.
                    break;
                case 4://Für Wohnungen...
                    zimmernummer = getBelegungWohnung();//...wird eine Zimmernummer gespeichert abhängig von der Belegung der Zimmerkategorie.
                    if (zimmernummer == 0) {//Wenn kein Zimmer der Zimmerkategorie frei ist, ...
                        print("Ende der Buchung!");//...wird ein Hinweis ausgegeben...
                        break;//...und die Buchung beendet.
                    }
                    while (anzahlPersonen > 6) {//Dann, ...
                        anzahlPersonen = abfrageAnzahlPersonen();//...wird die gewünschte Personenzahl abgefragt...
                        if (anzahlPersonen > 6) {//...und ein Hinweis ausgegeben, ...
                            print("Ferienwohnungen koennen für maximal 6 Personen gebucht werden.");
                        }
                    }//...bis die Personenzahl gültig ist.
                    while (anzahlTage < 3) {//Dann, ...
                        anzahlTage = abfrageAnzahlTage();//...wird die gewünschte Aufenthaltsdauer abgefragt...
                        if (anzahlTage < 3) {//...und ein Hinweis ausgegeben, ...
                            print("Ferienwohnungen muessen fuer mindestens 3 Tage gebucht werden.");
                        }
                    }//...bis die Aufenthaltsdauer gültig ist.
                    haustier = abfrageHaustier();//Dann wird abgefragt, ob die Wohnung mit Haustier gebucht werden soll...
                    zimmerservice = abfrageZimmerservice();//...und/oder mit Zimmerservice.
                    break;
                default://Bei ungültiger Eingabe...
                    break;//...wird keine Auswahl getroffen.
            }//end switch(preiskategorie)
            if (zimmernummer == 0) {//Sollte keine Auswahl getroffen worden sein, ...
                b = 4;//...wird die While-Schleife der Buchung beendet.
            } else {//Sonst...
                if(kundennummer == 0) {//...wird geprüft, ob vor dieser bereits eine Buchung vorgenommen wurde, ...
                    kundennummer = neuenKundenAnlegen();//...um andernfalls die Kundendaten zu erfassen.
                }
                if (Kunden[kundennummer].getZimmernummer1() != 0) {//Wenn bereits eine Buchung vorliegt, ...
                    if (Kunden[kundennummer].getZimmernummer2() != 0) {//...wird geprüft,ob eine zweite vorliegt. Wenn bereits eine zweite Buchung vorliegt, ...
                        if (Kunden[kundennummer].getZimmernummer3() != 0) {//...wird geprüft, ob eine dritte vorliegt.
                            print("Sie können nicht mehr als 3 Zimmer gleichzeitig Buchen!");//Wenn ja, wird ein Hinweis ausgegeben...
                            b = 4;//...und die While-Schleife der Buchung beendet.
                        } else {//Wenn keine dritte Buchung vorliegt, ...
                            Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage, balkon, einzelzimmerzuschlag, fruehstueck, haustier, zimmerservice, Kunden[kundennummer].getName(), Kunden[kundennummer].getAnschrift(), Kunden[kundennummer].getGeburtsdatum(), Kunden[kundennummer].getPremiumkunde());//...wird ein Objekt vom Typ Buchung erzeugt...
                            System.out.println("Moechten Sie die gewaehlte Unterkunft jetzt zum Preis von " + dF.format(Buchungen[zimmernummer-1].getSumme()) + "€ buchen?");//...und abgefragt, ob das Zimmer so gebucht werden soll.
                            if(abfrageEinverstanden()){//Wenn ja, ...
                                Kunden[kundennummer].setZimmernummer3(zimmernummer);//...wird das gebuchte Zimmer in den Kundendaten gespeichert...
                                Belegung[zimmernummer-1].setBelegt(true);//...und die Zimmerbelegung auf belegt gestellt.
                            }else Buchungen[zimmernummer-1] = new Buchung();//Wenn nein, wird die Buchung verworfen...
                            b = 4;//Dann wird die While-Schleife beendet.
                        }
                    } else {//Wenn keine zweite Buchung vorliegt, ...
                        Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage, balkon, einzelzimmerzuschlag, fruehstueck, haustier, zimmerservice, Kunden[kundennummer].getName(), Kunden[kundennummer].getAnschrift(), Kunden[kundennummer].getGeburtsdatum(), Kunden[kundennummer].getPremiumkunde());//...wird ein Objekt vom Typ Buchung erzeugt...
                        print("Moechten Sie die ausgewaehlte Unterkunft jetzt zum Preis von " + dF.format(Buchungen[zimmernummer-1].getSumme()) + "€ buchen?");//...und abgefragt, ob das Zimmer so gebucht werden soll.
                        if(abfrageEinverstanden()){//Wenn ja, ...
                            Kunden[kundennummer].setZimmernummer2(zimmernummer);//...wird das gebuchte Zimmer in den Kundendaten gespeichert, ...
                            Belegung[zimmernummer-1].setBelegt(true);//...die Zimmerbelegung auf belegt gestellt...
                            b = 2;//...und nur noch eine weitere Buchung zugelassen.
                        }else {Buchungen[zimmernummer-1] = new Buchung(); b = 4;}//Wenn nein, wird die Buchung verworfen und die While-Schleife beendet.
                    }
                } else {//Wenn keine Buchung vorliegt, ...
                    Buchungen[zimmernummer-1] = new Buchung(zimmernummer, preiskategorie, anzahlPersonen, anzahlTage, balkon, einzelzimmerzuschlag, fruehstueck, haustier, zimmerservice, Kunden[kundennummer].getName(), Kunden[kundennummer].getAnschrift(), Kunden[kundennummer].getGeburtsdatum(), Kunden[kundennummer].getPremiumkunde());//...wird ein Objekt vom Typ Buchung erzeugt...
                    print("Moechten Sie die ausgewaehlte Unterkunft jetzt zum Preis von " + dF.format(Buchungen[zimmernummer-1].getSumme()) + "€ buchen?");//...und abgefragt, ob das Zimmer so gebucht werden soll.
                    if(abfrageEinverstanden()){//Wenn ja, ...
                        Kunden[kundennummer].setZimmernummer1(zimmernummer);//...wird das gebuchte Zimmer in den Kundendaten gespeichert, ...
                        Belegung[zimmernummer-1].setBelegt(true);//...die Zimmerbelegung auf belegt gestellt...
                        b = 1;//...und noch zwei weitere Buchungen zugelassen.
                    }else {Buchungen[zimmernummer-1] = new Buchung(); b = 4;}//Wenn nein, wird die Buchung verworfen und die While-Schleife beendet.
                }
            }//end if(zimmernummer == 0) else
            if(b<4){//Wenn die While-Schleife der Buchung noch nicht zu Ende ist, ...
                print("Moechten Sie weitere Unterkuenfte buchen?");//...wird abgefragt, ob weitere Unterkünfte gebucht werden sollen.
                if(abfrageEinverstanden()){//Wenn ja, ...
                    b++;//...wird b um eins erhöht, ...
                }else b = 4;//...wenn nein, wird die While-Schleife der Buchung beendet.
            }
        }//end while(b)
    }//end Methode buchungAusfuehren(b)
    public static int abfrageZimmerart(){//Fragt nach, welche Zimmerart gebucht werden soll...
        print("Welche Zimmerart möchten Sie buchen? 1. Einzelzimmer, 2. Doppelzimmer, 3. Tripplezimmer oder 4. Ferienwohnung");
        return s.nextInt();//...und gibt den eingegebenen Wert zurück.
    }//end Methode abfrageZimmerart()
    public static boolean abfrageBalkon(){//Fragt nach, ob ein Zimmer mit Balkon gewünscht ist...
        print("Möchten Sie ein Zimmer mit Balkon buchen?");
        return abfrageEinverstanden();//...und gibt zurück, ob man damit einverstanden ist
    }//end Methode abfrageBalkon()
    public static int getBelegungEinzelzimmerBalkon(){//Prüft, ob ein Einzelzimmer mit Balkon frei ist.
        if(!Belegung[0].getBelegt()){//Wenn ja, ...
            return Belegung[0].getZimmernummer();//...wird die Zimmernummer zurückgegeben.
        }else if(!Belegung[2].getBelegt()){//Wenn kein Einzelzimmer mit Balkon frei ist, wird geprüft, ob ein Doppelzimmer mit Balkon frei ist.
            print("Alle Einzelzimmer mit Balkon sind belegt. Sie koennen stattdessen ein Doppelzimmer mit Balkon und Einzelzimmerzuschlag (+25.00€) buchen.");//Wenn ja, wird ein Hinweis ausgegeben...
            if(abfrageEinverstanden()){//...und gefragt, ob man damit einverstanden ist.
                return Belegung[2].getZimmernummer();//Wenn ja, wird die Zimmernummer zurückgegeben.
            }
        }else if(!Belegung[1].getBelegt()){//Wenn nein, wird geprüft, ob ein Einzelzimmer ohne Balkon frei ist.
            print("Alle Einzelzimmer mit Balkon sind belegt. Sie koennen stattdessen ein Einzelzimmer ohne Balkon buchen.");//Wenn ja, wird ein Hinweis ausgegeben...
            if(abfrageEinverstanden()){//...und gefragt, ob man damit einverstanden ist.
                return Belegung[1].getZimmernummer();//Wenn ja, wird die Zimmernummer zurückgegeben.
            }
        }else if(!Belegung[3].getBelegt()){//Wenn nein, wird geprüft, ob ein Doppelzimmer ohne Balkon frei ist.
            print("Alle Einzelzimmer mit Balkon sind belegt. Sie koennen stattdessen ein Doppelzimmer ohne Balkon und mit Einzelzimmerzuschlag (+25.00€) buchen.");//Wenn ja, wird ein Hinweis ausgegeben...
            if(abfrageEinverstanden()){//...und gefragt, ob man damit einverstanden ist.
                return Belegung[3].getZimmernummer();//Wenn ja, wird die Zimmernummer zurückgegeben.
            }
        } else print("Alle Einzel- und Doppelzimmer belegt.");//Wenn alle Zimmer der Kategorie belegt sind, wird ein Hinweis ausgegeben...
        return 0;//... und 0 zurückgegeben.
    }//end Methode getBelegungEinzelzimmerBalkon()
    public static int getBelegungDoppelzimmerBalkon(){//Prüft, ob ein Doppelzimmer mit Balkon frei ist.
        if(!Belegung[2].getBelegt()){//Wenn ja, ...
            return Belegung[2].getZimmernummer();//...wird die Zimmernummer zurückgegeben.
        }else if(!Belegung[3].getBelegt()){//Wenn kein Doppelzimmer mit Balkon frei ist, wird geprüft, ob ein Doppelzimmer ohne Balkon frei ist.
            print("Alle Doppelzimmer mit Balkon sind belegt. Sie koennen stattdessen ein Doppelzimmer ohne Balkon Buchen.");//Wenn ja, wird ein Hinweis ausgegeben...
            if(abfrageEinverstanden()){//... und gefragt, ob man damit einverstanden ist.
                return Belegung[3].getZimmernummer();//Wenn ja, wird die Zimmernummer zurückgegeben.
            }
        } else print("Alle Doppelzimmer belegt.");//Wenn alle Zimmer der Kategorie belegt sind, wird ein Hinweis ausgegeben...
        return 0;//...und 0 zurückgegeben.
    }//end Methode getBelegungEinzelzimmerBalkon()
    public static int getBelegungEinzelzimmer(){//Prüft, ob ein Einzelzimmer frei ist.
        if(!Belegung[0].getBelegt()){//Wenn ja, ...
            return Belegung[0].getZimmernummer();//...wird die Zimmernummer zurückgegeben.
        }else if(!Belegung[1].getBelegt()){
            return Belegung[1].getZimmernummer();
        }else if(!Belegung[2].getBelegt()){//Wenn kein Einzelzimmer frei ist, wird geprüft, ob ein Doppelzimmer frei ist.
            print("Alle Einzelzimmer sind belegt. Sie koennen aber ein Doppelzimmer mit Einzelzimmerzuschlag (+25.00€) buchen.");//Wenn ja, wird ein Hinweis ausgegeben...
            if(abfrageEinverstanden()){//...und gefragt, ob man damit einverstanden ist.
                return Belegung[2].getZimmernummer();//Wenn ja, wird die Zimmernummer zurückgegeben.
            }
        }else if(!Belegung[3].getBelegt()){
            print("Alle Einzelzimmer sind belegt. Sie koennen aber ein Doppelzimmer mit Einzelzimmerzuschlag (+25.00€) buchen.");
            if(abfrageEinverstanden()){
                return Belegung[3].getZimmernummer();
            }
        }else print("Alle Einzel- und Doppelzimmer belegt.");//Wenn alle Zimmer der Kategorie belegt sind, wird ein Hinweis ausgegeben...
        return 0;//...und 0 zurückgegeben.
    }//end Methode getBelegungEinzelzimmer()
    public static int getBelegungDoppelzimmer(){//Prüft, ob ein Doppelzimmer frei ist.
        if(!Belegung[2].getBelegt()){//Wenn ja, ...
            return Belegung[2].getZimmernummer();//...wird die Zimmernummer zurückgegeben.
        } else if(!Belegung[3].getBelegt()){
            return Belegung[3].getZimmernummer();
        } else print("Alle Doppelzimmer sind belegt.");//Wenn alle Zimmer der Kategorie belegt sind, wird ein Hinweis ausgegeben...
        return 0;//...und 0 zurückgegeben.
    }//end Methode getBelegungDoppelzimmer()
    public static int getBelegungTripplezimmer(){//Prüft, ob ein Tripplezimmer frei ist.
        if(!Belegung[4].getBelegt()){//Wenn ja, ...
            return Belegung[4].getZimmernummer();//...wird die Zimmernummer zurückgegeben.
        }else if(!Belegung[5].getBelegt()){
            return Belegung[5].getZimmernummer();
        }else print("Tripplezimmer belegt");//Wenn alle Zimmer der Kategorie belegt sind, wird ein Hinweis ausgegeben...
        return 0;//...und 0 zurückgegeben.
    }//end Methode getBelegungTripplezimmer()
    public static int getBelegungWohnung(){//Prüft, ob eine Wohnung frei ist.
        if(!Belegung[6].getBelegt()){//Wenn ja, ...
            return Belegung[6].getZimmernummer();//...wird die Zimmernummer zurückgegeben.
        }else if(!Belegung[7].getBelegt()){
            return Belegung[7].getZimmernummer();
        }else print("Alle Wohnungen sind belegt. Sie können jetzt eine neue Buchung beginnen.");//Wenn alle Zimmer der Kategorie belegt sind, wird ein Hinweis ausgegeben...
        return 0;//...und 0 zurückgegeben.
    }//end Methode getBelegungWohnung()
    public static boolean abfrageFruehstueck(){//Fragt den Kunden, ob er Frühstück buchen möchte...
        print("Moechten Sie Fruehstueck buchen?");
        return abfrageEinverstanden();//...und gibt zurück, ob man damit einverstanden ist.
    }//end Methode abfrageFruehstueck()
    public static int abfrageAnzahlPersonen(){//Fragt den Kunden, mit wie vielen Personen die Wohnung gebucht werden soll...
        print("Wie viele Personen werden die Ferienwohnung belegen?");
        return s.nextInt();//...und gibt den eingegebenen Wert zurück.
    }//end Methode abfrageAnzahlPersonen()
    public static int abfrageAnzahlTage() {//Fragt den Kunden, wie lange er bleiben möchte...
        print("Wie viele Tage moechten Sie bleiben?");
        return s.nextInt();//...und gibt den eingegebenen Wert zurück.
    }//end Methode abfrageAnzahlTage()
    public static boolean abfrageHaustier(){//Fragt, ob der Kunde mit Haustier anreisen möchte...
        print("Moechten Sie mit Haustier anreisen?");
        return abfrageEinverstanden();//...und gibt zurück, ob man damit einverstanden ist
    }//end Methode abfrageHaustier()
    public static boolean abfrageZimmerservice(){ //Fragt, ob der Kunde Zimmerservice buchen möchte...
        print("Moechten Sie zimmerservice buchen?");
        return abfrageEinverstanden();//... und gibt zurück, ob man damit einverstanden ist
    }//end Methode abfrageZimmerservice()
    public static int abfrageKundennummer(String name, String geburtsdatum){//Vergleicht den eingegebenen Namen und Geburtsdatum mit bereits angelegten Kundenobjekten.
        for(int i = k-1; i>0; i--){
            if((Kunden[i].getName().equals(name)) & (Kunden[i].getGeburtsdatum().equals(geburtsdatum))){
                return i;//Gibt, wenn bereits Daten vorhanden sind die kundennummer zurück.
            }
        }
        return 0;//Gibt 0 zurück, falls keine Daten vorhanden sind.
    }//end Methode abfrageKundennummer()
    public static String abfrageName(){//Bittet den Kunden seinen Namen einzugeben...
        print("Bitte geben Sie Ihren Vor- und Nachnamen ein.");
        return sd.nextLine();//...und gibt den Wert zurück.
    }//end Methode abfrageName()
    public static String abfrageAnschrift(){//Bittet den Kunden seine Anschrift einzugeben...
        print("Bitte geben Sie ihre Anschrift ein: Musterstr. 3, 72739 Musterstadt");
        return sd.nextLine();//...und gibt den Wert zurück.
    }//end Methode abfrageAnschrift()
    public static String abfrageGeburtsdatum(){//Bittet den Kunden sein Geburtsdatum einzugeben...
        print("Bitte geben Sie ihr Geburtsdatum ein: TT.MM.JJJJ");
        return s.next();//...und gibt den Wert zurück.
    }//end Methode abfrageGeburtsdatum()
    public static boolean abfragePremiumkunde(){//Fragt den Kunden, ob er Premiumkunde werden möchte...
        print("Möchten Sie Premiumkunde werden?");
        return abfrageEinverstanden();//...und gibt zurück, ob man damit einverstanden ist.
    }//end Methode abfragePremiumkunde()
    //Ende der ersten Auswahlmöglichkeit
    //
    //AUSWAHL MÖGLICHKEIT 2
    public static void zimmerBelegungAnzeigen(){//Fragt nach, für welches Zimmer die Belegung angezeigt werden soll.
        print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
        Belegung[s.nextInt()-1].print();//Nach Eingabe einer Zahl wird die Belegung für das Zimmer ausgegeben.
    }//end Methode zimmerBelegungAnzeigen()
    //Ende Auswahl Möglichkeit 2
    //
    //AUSWAHL MÖGLICHKEIT 3
    public static void zimmerAnzeigen(){//Gibt die attribute aller Zimmer aus.
        for(int c = 0; c<Belegung.length; c++){
            Belegung[c].print();
        }
    }//end Methode zimmerAnzeigen()
    //Ende der dritten Auswahlmöglichkeit
    //
    //AUSWAHL: MÖGLICHKEIT 4
    public static void zimmerBelegungProzent(){//Gibt die Belegung des Hotels in % aus
        double anzahlBelegt = 0;
        for(int o = 0; o<Belegung.length; o++){
            if(Belegung[o].getBelegt()){
                anzahlBelegt++;
            }
        }
        System.out.println("Das Hotel ist zu " + ((anzahlBelegt/Belegung.length)*100) + "% belegt.");
    }//end Methode zimmerBelegungProzent()
    //Ende der vierten Auswahlmöglichkeit
    //
    //AUSWAHL: MÖGLICHKEIT 5
    public static void zimmerBuchungAnzeigen(){//Gibt die Buchung eines Zimmers aus.
        print("Welches Zimmer moechten Sie aufrufen? 1, 2, 3...");
        Buchungen[s.nextInt()-1].printBuchung();
    }//end Methode zimmerBuchungAnzeigen()
    //Ende der fünften Auswahl Möglichkeit
    //
    //AUSWAHL: MÖGLICHKEIT 6
    public static void buchungKundeAnzeigen(){//Zeigt die Buchungen eines gewünschten Kunden an.
        print("Bitte geben Sie den Vor- und Nachname des Kunden ein dessen Buchung Sie aufrufen moechten?");
        String name = sd.nextLine();//Bittet um Eingabe eines Namens.
        boolean kDaten = false, zDaten = false;
        for(int d = k-1; d>0; d--){//Durchläuft alle bereits mit Objekten belegte Kundennummern.
            if(Kunden[d].getName().equals(name)){//Wenn die Eingabe mit einer Kundendatei übereinstimmt, ...
                kDaten = true;
                Kunden[d].print();//...werden die Kundendaten angezeigt.
                if(Kunden[d].getZimmernummer1() != 0){//Wenn Zimmer gebucht wurden,
                    Buchungen[Kunden[d].getZimmernummer1()-1].print();//werden diese Buchungen angezeigt.
                    zDaten = true;
                }
                if(Kunden[d].getZimmernummer2() != 0){
                    Buchungen[Kunden[d].getZimmernummer2()-1].print();
                    zDaten = true;
                }
                if(Kunden[d].getZimmernummer3() != 0){
                    Buchungen[Kunden[d].getZimmernummer3()-1].print();
                    zDaten = true;
                }
            }//end if(Namensvergleich)
        }//end for schleife
        if(!kDaten){//Wenn keine Kundendaten vorhanden sind, wird ein Hinweis ausgegeben.
            print("Kein Kunde unter diesem Namen gespeichert!");
        }
        if(!zDaten){//Wenn keine Buchung vorhanden ist, wird ein Hinweis ausgegeben.
            print("Keine Buchung vorhanden.");
        }
    }//end Methode buchungKundeAnzeigen()
    //Ende der sechsten Auswahlmöglichkeit
    //
    //AUSWAHL: MÖGLICHKEIT 7
    public static void rechnungZimmerErstellen(){//Gibt die Rechnung für ein Zimmer aus.
        print("Geben Sie die Zimmernummer ein für die Sie die Rechnung erstellen wollen.");
        int r = s.nextInt();//Bittet um Eingabe einer Zimmernummer.
        if(Belegung[r-1].getBelegt()){//Wenn das gewünschte Zimmer belegt ist, ...
            print("---Rechnung---");//...wird die Rechnung für das Zimmer ausgegeben.
            Buchungen[r - 1].printKundendaten();//Inkl. Kundendaten, ...
            Buchungen[r - 1].print();//...der Buchung, ...
            printSumme(Buchungen[r - 1].getSumme(), Buchungen[r-1].getPremiumkunde());//...sowie der Summe.
            print("Soll die Zimmerbelegung auf FREI gestellt werden?");//Außerdem wird abgefragt,...
            if(abfrageEinverstanden()){//... ob die Zimmerbelegung auf frei gestellt, ...
                Belegung[r-1].setBelegt(false);
                Buchungen[r-1] = new Buchung();//...die Buchung...
                for(int i = k-1; i>0; i--){//...und die Verknüpfung zum Kundenobjekt gelöscht werden soll.
                    if(Kunden[i].getZimmernummer1() == r){
                        Kunden[i].setZimmernummer1(0);
                    }
                    if(Kunden[i].getZimmernummer2() == r){
                        Kunden[i].setZimmernummer2(0);
                    }
                    if(Kunden[i].getZimmernummer3() == r){
                        Kunden[i].setZimmernummer3(0);
                    }
                }
            }
        }else print("Das Zimmer ist nicht belegt");//Wenn das Zimmer nicht belegt ist, wird ein Hinweis ausgegeben.
    }//end Methode rechnungZimmerErstellen()
    //Ende der siebten Auswahlmöglichkeit
    //
    //AUSWAHL: MÖGLICHKEIT 8
    public static int neuenKundenAnlegen(){//Ermöglicht das Anlegen eines neuen Kunden, solange der Kunde noch nicht existiert.
        String name = abfrageName();//Zunächst wird der Name abgefragt, ...
        String geburtsdatum = abfrageGeburtsdatum();//...und das Geburtsdatum.
        int kundennummer = abfrageKundennummer(name, geburtsdatum);//Dann wird versucht, passende, existierende Kundendaten zu finden.
        if(kundennummer != 0){//Falls ein Kunde bereits existiert...
            print("Dieser Kunde existiert bereits.");//...wird ein Hinweis ausgegeben.
        } else {
            String anschrift = abfrageAnschrift(); boolean premiumkunde = abfragePremiumkunde();//Sonst werden die restlichen Daten erfasst...
            Kunden[k] = new Kunde(name, anschrift, geburtsdatum, premiumkunde);//...und ein neues Objekt vom Typen Kunden erzeugt.
            kundennummer = k;
            k++;
            print("Neuer Kunde angelegt.");//Dann wird ein Hinweis ausgegeben.
        }
        return kundennummer;//Schließlich wird die kundennummer zurückgegeben.
    }//end Methode neuenKundenAnlegen()
    //Ende der achten Auswahlmöglichkeit
    //
    //AUSWAHL: MÖGLICHKEIT 9
    public static void kundenAnzeigen(){//Gibt alle zugehörigen Kundendaten aus.
        print("Bitte geben Sie den Vor- und Nachname des Kunden ein dessen Kundendaten Sie aufrufen moechten?");
        String name = sd.nextLine();//Bittet um Eingabe eines Namens.
        boolean kDaten = false, zDaten = false;
        for(int d = k-1; d>0; d--){//Durchläuft alle bereits mit Objekten belegte Kundennummern.
            if(Kunden[d].getName().equals(name)){//Wenn die Eingabe mit einer Kundendatei übereinstimmt, ...
                kDaten = true;
                Kunden[d].print();//...werden die Kundendaten angezeigt.
                if(Kunden[d].getZimmernummer1() != 0){//Wenn Zimmerbuchungen vorliegen, ...
                    System.out.println("Zimmer " + Kunden[d].getZimmernummer1());//...werden die Zimmernummern angezeigt.
                    zDaten = true;
                }
                if(Kunden[d].getZimmernummer2() != 0){
                    System.out.println("Zimmer " + Kunden[d].getZimmernummer2());
                    zDaten = true;
                }
                if(Kunden[d].getZimmernummer3() != 0){
                    System.out.println("Zimmer " + Kunden[d].getZimmernummer3());
                    zDaten = true;
                }
            }//end erstes if(Namensvergleich)
        }//end for schleife
        if(!kDaten){//Wenn keine Kundendaten vorhanden sind, wird ein Hinweis ausgegeben.
            print("Kein Kunde Unter diesem Namen gespeichert.");
        }
        if(!zDaten){//Wenn keine Buchung vorhanden ist, wird ein Hinweis ausgegeben.
            print("Keine aktuelle Buchung.");
        }
    }//end Methode kundenAnzeigen()
    //
    //Ende der neunten Auswahlmöglichkeit
    //AUSWAHL: MÖGLICHKEIT 10
    public static void rechnungKundeErstellen(){//Erstellt eine Gesamtrechnung für alle Buchungen eines Kunden
        int kundennummer = 0; double gesamtSumme = 0.0;
        print("Geben Sie den Vor- und Nachnamen des Kunden ein fuer den Sie eine Gesamtrechnung erstellen wollen.");
        String name = sd.nextLine();//Bittet um Eingabe eines Namens.
        for(int r = k-1; r>0; r--){//Durchläuft alle bereits mit Objekten belegte Kundennummern.
            if(Kunden[r].getName().equals(name) & ((Kunden[r].getZimmernummer1() != 0) | (Kunden[r].getZimmernummer2() != 0) | (Kunden[r].getZimmernummer3() != 0))) {//Wenn ein passender Name mit aktueller Buchung gefunden wird, ...
                kundennummer = r;//...wird dessen Kundennummer abgelegt.
            }
        }//end for Schleife
        if(kundennummer != 0){//Wenn eine passende Kundennummer abgelegt wurde, ...
            print("---Rechnung---");//...wird eine Rechnung...
            Kunden[kundennummer].print();//...inkl. Kundendaten ...
            if(Kunden[kundennummer].getZimmernummer1() != 0){
                Buchungen[Kunden[kundennummer].getZimmernummer1()-1].print();//...und allen Buchungen ausgegeben.
                gesamtSumme += Buchungen[Kunden[kundennummer].getZimmernummer1()-1].getSumme();//Um eine Gesamtsumme anzuzeigen, wird die Summe der einzelnen Buchungen abgelegt...
            }
            if(Kunden[kundennummer].getZimmernummer2() != 0){
                Buchungen[Kunden[kundennummer].getZimmernummer2()-1].print();
                gesamtSumme += Buchungen[Kunden[kundennummer].getZimmernummer2()-1].getSumme();
            }
            if(Kunden[kundennummer].getZimmernummer3() != 0){
                Buchungen[Kunden[kundennummer].getZimmernummer3()-1].print();
                gesamtSumme += Buchungen[Kunden[kundennummer].getZimmernummer3()-1].getSumme();
            }
            printSumme(gesamtSumme, Kunden[kundennummer].getPremiumkunde());//...und ausgegeben.
            print("Soll die Zimmerbelegung auf FREI gestellt werden?");//Außerdem wird abgefragt,...
            if(abfrageEinverstanden()){//... ob die Zimmerbelegung auf frei gestellt...
                if(Kunden[kundennummer].getZimmernummer1() != 0){
                    Belegung[Kunden[kundennummer].getZimmernummer1()-1].setBelegt(false);
                    Buchungen[Kunden[kundennummer].getZimmernummer1()-1] = new Buchung();
                    Kunden[kundennummer].setZimmernummer1(0);//...und die Verknüpfung zum Kundenobjekt gelöscht werden soll.
                }
                if(Kunden[kundennummer].getZimmernummer2() != 0){
                    Belegung[Kunden[kundennummer].getZimmernummer2()-1].setBelegt(false);
                    Buchungen[Kunden[kundennummer].getZimmernummer2()-1] = new Buchung();
                    Kunden[kundennummer].setZimmernummer2(0);
                }
                if(Kunden[kundennummer].getZimmernummer3() != 0){
                    Belegung[Kunden[kundennummer].getZimmernummer3()-1].setBelegt(false);
                    Buchungen[Kunden[kundennummer].getZimmernummer3()-1] = new Buchung();
                    Kunden[kundennummer].setZimmernummer3(0);
                }
            }
        }else print("Fuer diesen Kunden liegt keine Buchung vor.");//Wenn keine passende Kundennummer abgelegt wurde, wird ein Hinweis ausgegeben.
    }//end Methode rechnungKundeErstellen()
    //Ende der zehnten Auswahlmöglichkeit
    //
    public static void printSumme(double summe, boolean premiumkunde){//Methode zur Ausgabe...
        System.out.println("Netto: " + dF.format(Math.round((summe/1.19)*100)/100) + "€");//...des Nettobetrags, ...
        if(premiumkunde){//...falls vorhanden...
            System.out.println("Netto ohne Premiumkundenrabatt: " + dF.format(Math.round((summe/1.19/0.95)*100.00)/100.00) + "€");//...des Premiumkunderabatts, ...
        }
        System.out.println("MwSt.: " + dF.format(Math.round((summe - summe / 1.19)*100.00)/100.00) + "€");//...der Mehrwertsteuer und...
        System.out.println("Brutto: " + dF.format(Math.round(summe*100)/100) + "€");//...des Bruttobetrags.
        print("----------");
    }//end Methode printSumme()
    //
    public static boolean abfrageEinverstanden(){//Methode zur vereinfachung der Abfrage bei Auswahlmöglichkeiten
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
    public static void belegungErzeugen(){//Methode zur Erzeugung der Anfangsbelegung entsprechend der gestellten Aufgabe.
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
