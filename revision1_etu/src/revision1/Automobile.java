package revision1;

import java.util.Objects;

public class Automobile {
    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}

    private String NIP;

    private Etat etatTransmission = Etat.NEUF;
    private Etat etatCarosserie = Etat.NEUF;
    private Etat etatMoteur = Etat.NEUF;

    private Etat etatHabitacle = Etat.NEUF;

    public Automobile(String NIP) {
        this.NIP = NIP;
    }

    public Automobile() {
    }

    public String getNIP() {
        return NIP;
    }

    public Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Etat getEtatCarosserie() {
        return etatCarosserie;
    }

    public void setEtatCarosserie(Etat etatCarosserie) {
        this.etatCarosserie = etatCarosserie;
    }

    public Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "NIP='" + NIP + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatCarosserie=" + etatCarosserie +
                ", etatMoteur=" + etatMoteur +
                '}';
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public void repare() {
        if (getEtatCarosserie() != Automobile.Etat.NEUF && getEtatCarosserie() != Automobile.Etat.REPARE)
            this.setEtatCarosserie(Automobile.Etat.REPARE);
        if (getEtatMoteur() != Automobile.Etat.NEUF && getEtatMoteur() != Automobile.Etat.REPARE)
            setEtatMoteur(Automobile.Etat.REPARE);
        if (getEtatTransmission() != Automobile.Etat.NEUF && getEtatTransmission() != Automobile.Etat.REPARE)
            setEtatTransmission(Automobile.Etat.REPARE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return Objects.equals(NIP, that.NIP);
    }

}
