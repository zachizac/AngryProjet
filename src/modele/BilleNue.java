package modele;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;

/**
 * Created by Zachizac on 22/02/2017.
 */
public class BilleNue extends Bille{

    /**
     * Constructeur de billeNue avec acceleration definie
     *
     * @param position
     * @param rayon
     * @param vitesse
     * @param acceleration
     * @param couleur
     */
    public BilleNue(Vecteur position, double rayon, Vecteur vitesse,
                    Vecteur acceleration, Color couleur) {
        this.position = position;
        this.rayon = rayon;
        this.vitesse = vitesse;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.clef = Bille.prochaineClef++;
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


}
