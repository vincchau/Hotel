public class Kunde extends Main{
    //Attribute
    private String name;
    private String anschrift;
    private String geburtsdatum;
    private boolean premiumkunde;
    private int zimmernummer1, zimmernummer2, zimmernummer3;
    //
    //Konstruktoren
    public Kunde(String name, String anschrift, String geburtsdatum, boolean premiumkunde, int zimmernummer1){
        this.name = name;
        this.anschrift = anschrift;
        this.geburtsdatum = geburtsdatum;
        this.premiumkunde = premiumkunde;
        this.zimmernummer1 = zimmernummer1;
        this.zimmernummer2 = 0;
        this.zimmernummer3 = 0;
    }//end constructor Kunde
    public Kunde(){
        this.name = "";
        this.anschrift = " ";
        this.geburtsdatum = " ";
        this.premiumkunde = false;
        this.zimmernummer1 = 0;
        this.zimmernummer2 = 0;
        this.zimmernummer3 = 0;
    }//end constructor Kunde
    //
    //Methoden
    public void print(){
        System.out.println("---Kundendaten---");
        System.out.println("Name: " + name);
        System.out.println("Anschrift: " + anschrift);
        System.out.println("Geburtsdatum: " + geburtsdatum);
        if(premiumkunde){
            System.out.println("Premiumkunde");
        }//end if
        System.out.println("");
    }//end method print
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
    public void setZimmernummer1(int zimmernummer1){
        this.zimmernummer1 = zimmernummer1;
    }
    public int getZimmernummer1(){
        return zimmernummer1;
    }
    public void setZimmernummer2(int zimmernummer2){
        this.zimmernummer2 = zimmernummer2;
    }
    public int getZimmernummer2(){
        return zimmernummer2;
    }
    public void setZimmernummer3(int zimmernummer3){
        this.zimmernummer3 = zimmernummer3;
    }
    public int getZimmernummer3(){
        return zimmernummer3;
    }
}
