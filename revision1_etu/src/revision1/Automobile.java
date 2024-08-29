package revision1;

import java.util.Objects;

public class Automobile extends Vehicule{

    private Etat etatHabitacle = Etat.NEUF;
    private Etat etatCarosserie = Etat.NEUF;

    public Automobile(String NIP) {
        super(NIP);
    }

    public Automobile() {
    }

    public Etat getEtatHabitacle() {
        return etatHabitacle;
    }

    public void setEtatHabitacle(Etat etatHabitacle) {
        this.etatHabitacle = etatHabitacle;
    }

    public Etat getEtatCarosserie() {
        return etatCarosserie;
    }

    public void setEtatCarosserie(Etat etatCarosserie) {
        this.etatCarosserie = etatCarosserie;
    }



    @Override
    public String toString() {
        return "Automobile{" +
                super.toString() +
                ", etatCarosserie=" + etatCarosserie +
                ", etatHabitacle=" + etatHabitacle +
                '}';
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public void repare() {
        if (getEtatCarosserie() != Automobile.Etat.NEUF && getEtatCarosserie() != Automobile.Etat.REPARE)
            this.setEtatCarosserie(Automobile.Etat.REPARE);
        super.repare();
    }

    @Override
    public boolean equals(Object o) {
        Automobile a = (Automobile) o;
        return super.equals(o) && etatCarosserie == a.etatCarosserie && etatHabitacle == a.etatHabitacle;
    }

}
