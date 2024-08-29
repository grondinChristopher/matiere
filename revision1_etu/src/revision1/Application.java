package revision1;

public class Application {
    public static void main(String[] args) {
        Garage garage = new Garage(4);
        Automobile autoA = new Automobile("A");
        Automobile autoB = new Automobile("B");
        Automobile autoC = new Automobile("C");
        Automobile autoD = new Automobile("D");
        int val =5;

//        if(autoA == autoB) System.out.println("Sdfsdf");
        if(autoA.equals(autoB) ) System.out.println("Sdfsdf");

        garage.stationne(autoA);
        garage.stationne(autoB);
        garage.stationne(autoC);
        garage.stationne(autoD);

        autoA.setEtatTransmission(Automobile.Etat.TRES_BRISE);
        autoA.setEtatMoteur(Automobile.Etat.BRISE);
        autoB.setEtatTransmission(Automobile.Etat.BRISE);

        autoC.setEtatCarosserie(Automobile.Etat.TRES_BRISE);
        autoD.setEtatMoteur(Automobile.Etat.BRISE);

        System.out.println("Les autos sont endommagés");
        System.out.println(autoA);
        System.out.println(autoB);
        System.out.println(autoC);
        System.out.println(autoD);

        System.out.println("\n les autos sont réparées");
        // Réparation des autos A et B
        garage.entreVehiculeGarage(autoA, 1);
        garage.entreVehiculeGarage(autoB,2);

        garage.repare();
        garage.sortVehicule(1,garage.trouvePlace());
        garage.sortVehicule(2,garage.trouvePlace());

        garage.faitDepartVehicule(autoA);
        garage.faitDepartVehicule(autoB);

        System.out.println(autoA);
        System.out.println(autoB);

        // Réparation des autos C et D
        //TODO autoC pas réparer
        garage.entreVehiculeGarage(autoC, 1);
        garage.entreVehiculeGarage(autoD,2);

        garage.repare();
        garage.sortVehicule(1,garage.trouvePlace());
        garage.sortVehicule(2,garage.trouvePlace());

        garage.faitDepartVehicule(autoC);
        garage.faitDepartVehicule(autoD);

        System.out.println(autoC);
        System.out.println(autoD);

    }
}
