package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;
import modele.DecorateurAcceleration;
import modele.OutilsBille;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class AttractionUniverselle extends DecorateurAcceleration {

    /**
     * Constructeur d'attractionUniverselle
     * @param b la bille subissant l'attraction
     */
    public AttractionUniverselle(Bille b) {
        bille = b;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes lorsque la bille subit l'attraction des autres billes
     */
    public void gestionAcceleration(Vector<Bille> billes){
        this.getAcceleration().set(Vecteur.VECTEURNUL);                                                         // remise e zero du vecteur acceleration
        this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));            // contribution de l'acceleration due e l'attraction des autres billes
    }

}
