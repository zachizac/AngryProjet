package modele.Collision;

import mesmaths.cinematique.Collisions;
import modele.Bille;
import modele.DecorateurCollision;

/**
 * Created by Zachizac on 22/02/2017.
 */
public class PasseMuraille extends DecorateurCollision{

    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public PasseMuraille(Bille b) {
        bille = b;
    }

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici la bille traverse les parois et arrive de l'autre cote
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

}
