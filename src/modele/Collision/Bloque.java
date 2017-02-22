package modele.Collision;

import mesmaths.cinematique.Collisions;
import modele.Bille;
import modele.DecorateurCollision;

/**
 * Created by Zachizac on 22/02/2017.
 */
public class Bloque extends DecorateurCollision{

    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public Bloque(Bille b) {
        bille = b;
    }

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici la bille se bloque contre les parois
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);
    }
}
