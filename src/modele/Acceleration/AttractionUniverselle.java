package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;
import modele.DecorateurAccel;
import modele.OutilsBille;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class AttractionUniverselle extends Decorateur {

    /**
     * Constructeur d'attractionUniverselle
     * @param b la bille subissant l'attraction
     */
    public AttractionUniverselle(Bille b) {
        super(b);
        bille = b;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes lorsque la bille subit l'attraction des autres billes
     */
    @Override
    public void gestionAcceleration(Vector<Bille> billes){
//        super.gestionAcceleration(billes);                                                                      // remise e zero du vecteur acceleration
        this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));            // contribution de l'acceleration due e l'attraction des autres billes
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        bille.collisionContour(abscisseCoinHautGauche,ordonneeCoinHautGauche,largeur,hauteur);
    }

}
