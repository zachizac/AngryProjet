package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.DecorateurAcceleration;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class RectiligneUniforme extends DecorateurAcceleration {

    public RectiligneUniforme(Bille b) {
        bille = b;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes lorsque la bille subit l'attraction des autres billes
     */
    public void gestionAcceleration(Vector<Bille> billes){
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }
}
