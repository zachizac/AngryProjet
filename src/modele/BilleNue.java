package modele;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Zachizac on 22/02/2017.
 * Classe bille nue qui etend la classe Bille. Les billes nues sont des billes sans aucun decorateurs, elles sont la
 * base de toute nouvelle bille.
 */
public class BilleNue extends Bille{

    /**
     * Constructeur de billeNue avec acceleration definie
     *
     * @param position
     * @param rayon
     * @param vitesse
     * @param couleur
     */
    public BilleNue(Vecteur position, double rayon, Vecteur vitesse,
                    Vecteur acceleration, Color couleur) {
    super(position,rayon,vitesse,acceleration,couleur);
    }

    /**
     * Constructeur de billeNue sans acceleration
     *
     * @param position
     * @param rayon
     * @param vitesse
     * @param couleur
     */
    public BilleNue(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
        this(position, rayon, vitesse, new Vecteur(), couleur);
    }

    public void gestionAcceleration(Vector<Bille> billes){}

    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur){}

}
