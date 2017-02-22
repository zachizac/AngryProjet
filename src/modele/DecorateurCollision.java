package modele;

/**
 * Created by Zachizac on 21/02/2017.
 */
public abstract class DecorateurCollision extends Bille{

    protected Bille bille;

    /**
     * gestion de l'eventuelle collision de la bille (this) avec le contour rectangulaire de l'ecran defini par (abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur)
     * <p>
     * detecte si il y a collision et le cas echeant met e jour position et vitesse
     * <p>
     * La nature du comportement de la bille en reponse e cette collision est definie dans les classes derivees
     */
    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

}
