package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 * Classe de decoration acceleration de rectiligne uniforme pour les billes nues
 */
public class RectiligneUniforme extends Decorateur {

    /**
     * Constructeur de mouvement rectiligne uniforme
     * @param b bille subissant ce mouvement
     */
    public RectiligneUniforme(Bille b) {
        super(b);
        bille=b;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        bille.collisionContour(abscisseCoinHautGauche,ordonneeCoinHautGauche,largeur,hauteur);
    }

}
