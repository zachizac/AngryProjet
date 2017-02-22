package modele.Collision;

import mesmaths.cinematique.Collisions;
import modele.Bille;
import modele.DecorateurCollision;

/**
 * Created by Zachizac on 22/02/2017.
 */
public class Rebond extends DecorateurCollision{

    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public Rebond(Bille b) {
        bille = b;
    }

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici, la bille rebondit sur les paroi
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

}
