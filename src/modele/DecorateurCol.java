package modele;

/**
 * Created by MERTZ on 23/02/2017.
 */
public abstract class DecorateurCol extends Decorateur {

    public DecorateurCol(Bille b){super(b);}
    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

}
