package modele.Collision;

import mesmaths.cinematique.Collisions;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 22/02/2017.
 */
public class Rebond extends Decorateur{

    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public Rebond(Bille b) {
        super(b);
        bille=b;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        bille.gestionAcceleration(billes);
    }

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici, la bille rebondit sur les paroi
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

}
