package modele.Acceleration;

import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 * Classe de decoration acceleration de frottement visqueux pour les billes nues
 */
public class FrottementVisqueux extends Decorateur {

    /**
     * Constructeur de frottementVisqueux
     * @param b la bille subissant ce frottement
     */
    public FrottementVisqueux(Bille b) {
        super(b);
        bille = b;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes pour certains type d'acceleration
     */
    @Override
    public void gestionAcceleration(Vector<Bille> billes){
        super.gestionAcceleration(billes);                                                                 // remise e zero du vecteur acceleration
        bille.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(bille.masse(), bille.getVitesse())); // contribution de l'acceleration due au frottement dans l'air
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        bille.collisionContour(abscisseCoinHautGauche,  ordonneeCoinHautGauche,largeur,  hauteur);
    }


}
