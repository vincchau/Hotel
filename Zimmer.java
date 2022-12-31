public class Zimmer extends Main{
    //Attribute
    private int zimmernummer;
    private int preiskategorie;
    private double preisProZimmer;
    private int zimmerProKategorie;
    private boolean belegt;

    //Konstruktoren
    public Zimmer(int zimmernummer, int preiskategorie, double preisProZimmer, int zimmerProKategorie, boolean belegt){
        this.zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.preisProZimmer = preisProZimmer;
        this.zimmerProKategorie = zimmerProKategorie;
        this.belegt = belegt;
    }//end constructor Zimmer()
    public Zimmer(int zimmernummer, int preiskategorie, double preisProZimmer){
        this. zimmernummer = zimmernummer;
        this.preiskategorie = preiskategorie;
        this.preisProZimmer = preisProZimmer;
        this.zimmerProKategorie = 2;
        this.belegt = false;
    }//end constructor Zimmer()
    public Zimmer(){
        this.zimmernummer = 0;
        this.preiskategorie = 0;
        this.preisProZimmer = 0.0;
        this.zimmerProKategorie = 2;
        this.belegt = false;
    }//end constructor Zimmer()
    //
    //Methoden
    public void print(){
        if (preiskategorie == 1){
            System.out.println("---Einzelzimmer---");
        }else if(preiskategorie == 2){
            System.out.println("---Doppelzimmer---");
        } else if(preiskategorie == 3){
            System.out.println("---Tripplezimmer");
        }else System.out.println("---Ferienwohnung---");
        System.out.println("Zimmernummer " +  zimmernummer + ":");
        System.out.println("Preiskategorie: " + preiskategorie);
        System.out.println("Preis Pro Zimmer: " + preisProZimmer + "€");
        System.out.println("Zimmer Pro Kategorie: " + zimmerProKategorie);
        if(belegt){
            System.out.println("--Zimmer belegt--");
        }else System.out.println("--Zimmer frei--");
    }//end methode print()
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
            System.out.println("--Zimmer belegt--");
        }else System.out.println("--Zimmer frei--");
    }//end methode printBelegt()
    //
    //Notwendige getter- und setter methoden
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
}