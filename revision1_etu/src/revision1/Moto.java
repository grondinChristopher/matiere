package revision1;

public class Moto {

    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}

    private String NIP;
    private Automobile.Etat etatTransmission = Automobile.Etat.NEUF;
    private Automobile.Etat etatMoteur = Automobile.Etat.NEUF;


    public Moto(String NIP) {
        this.NIP = NIP;
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public void repare() {
        if (getEtatMoteur() != Automobile.Etat.NEUF && getEtatMoteur() != Automobile.Etat.REPARE)
            setEtatMoteur(Automobile.Etat.REPARE);
        if (getEtatTransmission() != Automobile.Etat.NEUF && getEtatTransmission() != Automobile.Etat.REPARE)
            setEtatTransmission(Automobile.Etat.REPARE);
    }

    public Automobile.Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Automobile.Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Automobile.Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Automobile.Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "NIP='" + NIP + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatMoteur=" + etatMoteur +
                '}';
    }
}
