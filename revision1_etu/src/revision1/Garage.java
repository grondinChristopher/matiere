package revision1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Automobile[] stationnements;
    private Automobile[] garages;
    private Map reparation;

    /**
     * crée un Garage avec le nombre de place de stationnement demandé et toujours 2 places de garage pour les réparations.
     *
     * @param nombrePlacesStationnement le nombre de places requises.
     */
    public Garage(int nombrePlacesStationnement) {
        assert nombrePlacesStationnement > 0 : "valeur négative";

        reparation = new HashMap<LocalDateTime, String>();
        garages = new Automobile[2];
        stationnements = new Automobile[nombrePlacesStationnement];
    }

    /**
     * Stationne l'auto dans le premier emplacement vide. La méthode trouveIndexPlaceLibre peut aider à le faire.
     * La méthode stationnementEstPlein indique s'il y a une place disponible.
     *
     * @param auto l'auto à placer dans le stationnement
     * @return faux s'il n'y a plus de palce
     */
    public boolean stationne(Automobile auto) {
        int place = trouveIndexPlaceLibre();

        if (place != -1) {
            stationnements[place] = auto;
            return true;
        }

        return false;
    }

    /**
     * indique si le stationnement est plein
     *
     * @return vrai s'il est plein
     */
    private boolean stationnementEstPlein() {
        int place = trouveIndexPlaceLibre();

        if (place == -1) {
            return true;
        }

        return false;
    }

    /**
     * trouve la première place libre. On doit vérifier qu'il y a une place libre avant d'appeler cette méthode
     *
     * @return l'indice de la place libre ou ArrayIndexOutOfBoundsException si le stationnement est plein
     */
    private int trouveIndexPlaceLibre() {
        for (int i = 0; i < stationnements.length; i++) {
            if (stationnements[i] == null) {
                return i;
            }
        }

        throw new ArrayIndexOutOfBoundsException("stationnement plein");
    }

    /**
     * trouve la première place libre. On doit vérifier qu'il y a une place libre avant d'appeler cette méthode
     *
     * @return l'indice de la place libre ou ArrayIndexOutOfBoundsException si le stationnement est plein
     */
    public int trouvePlace() {
        return trouveIndexPlaceLibre() + 1;
    }


    /**
     * entre le vehicule demandé dans le garage à la place demandé. On peut retrouver la
     * place de stationnement d'un vehicule à l'aide de la méthode chercheVehiculeStationnement.
     *
     * @param vehiculeRepare le vehicule à entrer (il doit être dans le stationnement)
     * @param placeGarage    la place du garage (elle ne doit pas contenir de vehicule)
     * @return vrai si le vehicule a pu être entré
     */
    public boolean entreVehiculeGarage(Automobile vehiculeRepare, int placeGarage) {
        int indexGarage = placeGarage - 1;
        assert vehiculeRepare != null : "null Vehicule";
        assert indexGarage >= 0 : "place négative";
        assert indexGarage < garages.length : "place inexistante";

        if (garages[indexGarage] == null) {
            for (int i = 0; i < stationnements.length; i++) {
                if (stationnements[i] == vehiculeRepare) {
                    stationnements[i] = null;
                }
            }
            garages[indexGarage] = vehiculeRepare;
            return true;
        } else {
            return false;
        }

    }

    /**
     * trouve le vehicule reçu en paramètre dans le stationnement et retourne son index
     *
     * @param vehiculeRepare le véhicule à trouver (avec méthode equals)
     * @return l'index du vehicule ou -1 s'il n'a pas été trouvé
     */
    private int chercheVehiculeStationnement(Automobile vehiculeRepare) {
        assert vehiculeRepare != null : "parametre null";

        for (int i = 0; i < stationnements.length; i++) {
            if (stationnements[i] == vehiculeRepare) {
                return i;
            }
        }

        return -1;
    }

    /**
     * sort le vehicule du garage et le remet dans le stationnement.
     *
     * @param placeGarage       la place du garabe où prendre le vehicule à sortir ( il doit y avoir un vehicule à cette place)
     * @param placeStationement la place de stationnement où mettre le vehicule (le stationnement doit être libre)
     * @return retourne vrai si le vehicule est sorti.
     */
    public boolean sortVehicule(int placeGarage, int placeStationement) {
        int indexGarage = placeGarage - 1;
        int indexStationnement = placeStationement - 1;

        if (stationnements[indexStationnement] != null || garages[indexGarage] == null) {
            return false;
        } else {
            stationnements[indexStationnement] = garages[indexGarage];
            garages[indexGarage] = null;
            return true;
        }

    }

    /**
     * gère le départ d'un véhicule en l'effacant du stationnement et en retournant sa valeur
     *
     * @param auto le vehicule qui doit être retiré
     * @return le vehicule qui doit être retiré sii il est trouvé null autrement.
     */
    public Automobile faitDepartVehicule(Automobile auto) {

        for (int i = 0; i < stationnements.length; i++) {
            if (stationnements[i] == auto) {
                stationnements[i] = null;
                return auto;
            }
        }

        return null;
    }

    /**
     * répare tous les dommages de tous les vehicules dans le garage en indiquant l'état réparé.
     */
    public void repare() {
        for (int i = 0; i < garages.length; i++) {
            String listeRepa = garages[i].getNIP() + "-";

            if (garages[i].getEtatMoteur() == Automobile.Etat.BRISE || garages[i].getEtatMoteur() == Automobile.Etat.TRES_BRISE){
                garages[i].setEtatMoteur(Automobile.Etat.REPARE);
                listeRepa += " moteur";
            }
            if (garages[i].getEtatCarosserie() == Automobile.Etat.BRISE || garages[i].getEtatCarosserie() == Automobile.Etat.TRES_BRISE){
                garages[i].setEtatCarosserie(Automobile.Etat.REPARE);
                listeRepa += " carosserie";
            }
            if (garages[i].getEtatTransmission() == Automobile.Etat.BRISE || garages[i].getEtatTransmission() == Automobile.Etat.TRES_BRISE){
                garages[i].setEtatTransmission(Automobile.Etat.REPARE);
                listeRepa += " transmission";
            }
            reparation.put(LocalDateTime.now(), listeRepa);
        }
    }

}
