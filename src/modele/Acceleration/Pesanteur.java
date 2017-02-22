package modele.Acceleration;

import modele.Bille;
import modele.DecorateurAcceleration;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class Pesanteur extends DecorateurAcceleration{

    /**
     * Constructeur de pesanteur
     * @param b la bille supportant la pesanteur
     */
    public Pesanteur(Bille b) {
        bille = b;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes pour certains type d'acceleration
     */
    public void gestionAcceleration(Vector<Bille> billes){

    }
}
