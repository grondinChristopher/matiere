package revision1;

public class Camion {

    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}

    private String NIP;
    private Automobile.Etat etatTransmission = Automobile.Etat.NEUF;
    private Automobile.Etat etatCarosserie = Automobile.Etat.NEUF;
    private Automobile.Etat etatMoteur = Automobile.Etat.NEUF;
    private Automobile.Etat etatEspaceCargaison = Automobile.Etat.NEUF;


    public Camion(String NIP) {
        this.NIP = NIP;
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public void repare() {
        if (getEtatCarosserie() != Automobile.Etat.NEUF && getEtatCarosserie() != Automobile.Etat.REPARE)
            setEtatCarosserie(Automobile.Etat.REPARE);
        if (getEtatMoteur() != Automobile.Etat.NEUF && getEtatMoteur() != Automobile.Etat.REPARE)
            setEtatMoteur(Automobile.Etat.REPARE);
        if (getEtatTransmission() != Automobile.Etat.NEUF && getEtatTransmission() != Automobile.Etat.REPARE)
            setEtatTransmission(Automobile.Etat.REPARE);
        if (getEtatEspaceCargaison() != Automobile.Etat.NEUF && getEtatEspaceCargaison() != Automobile.Etat.REPARE)
            setEtatEspaceCargaison(Automobile.Etat.REPARE);
    }

    public Automobile.Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Automobile.Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Automobile.Etat getEtatCarosserie() {
        return etatCarosserie;
    }

    public void setEtatCarosserie(Automobile.Etat etatCarosserie) {
        this.etatCarosserie = etatCarosserie;
    }

    public Automobile.Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Automobile.Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    public Automobile.Etat getEtatEspaceCargaison() {
        return etatEspaceCargaison;
    }

    public void setEtatEspaceCargaison(Automobile.Etat etatEspaceCargaison) {
        this.etatEspaceCargaison = etatEspaceCargaison;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "NIP='" + NIP + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatCarosserie=" + etatCarosserie +
                ", etatMoteur=" + etatMoteur +
                ", etatEspaceCargaison=" + etatEspaceCargaison +
                '}';
    }
}
