package revision1;

import java.util.Objects;

public class Vehicule {
    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}

    private String NIP;

    private Etat etatTransmission = Etat.NEUF;
    private Etat etatMoteur = Etat.NEUF;

    public Vehicule(String NIP){
        this.NIP = NIP;
    }

    public Vehicule(){
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

    public Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    public void repare(){
        if (getEtatMoteur() != Automobile.Etat.NEUF && getEtatMoteur() != Automobile.Etat.REPARE)
            setEtatMoteur(Automobile.Etat.REPARE);
        if (getEtatTransmission() != Automobile.Etat.NEUF && getEtatTransmission() != Automobile.Etat.REPARE)
            setEtatTransmission(Automobile.Etat.REPARE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(NIP, vehicule.NIP) && etatTransmission == vehicule.etatTransmission && etatMoteur == vehicule.etatMoteur;
    }

    @Override
    public String toString() {
        return "NIP='" + NIP + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatMoteur=" + etatMoteur;
    }
}
