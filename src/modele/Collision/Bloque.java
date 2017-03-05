package modele.Collision;

import mesmaths.cinematique.Collisions;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 22/02/2017.
 * Classe de decoration collision pour les billes se bloquant sur les bords du cadre
 */
public class Bloque extends Decorateur{

    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public Bloque(Bille b) {
        super(b);
        bille = b;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {}

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici la bille se bloque contre les parois
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);
    }
}
