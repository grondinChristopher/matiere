package revision1;

public class Moto extends Vehicule{

    public Moto(String NIP) {
        super(NIP);
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public void repare() {
        super.repare();
    }

    @Override
    public String toString() {
        return "Moto{" +
                super.toString() +
                '}';
    }
}
