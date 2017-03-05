package modele.Collision;

import mesmaths.cinematique.Collisions;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 22/02/2017.
 * Classe de decoration collision pour les billes ne reagissent pas aux bords et qui apparaissent de l'autre cote du cadre
 */
public class PasseMuraille extends Decorateur {

    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public PasseMuraille(Bille b) {
        super(b);
        bille = b;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {}

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici la bille traverse les parois et arrive de l'autre cote
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }

}
