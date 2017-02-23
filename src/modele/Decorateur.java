package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public abstract class Decorateur extends Bille{

    protected Bille bille;

    public Decorateur(){}
    public Decorateur(Bille b){
        super(b);
    }


    public abstract void gestionAcceleration(Vector<Bille> billes);

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);


    /**
     * calcul (c-e-d mise e jour) eventuel  du vecteur acceleration.
     * billes est la liste de toutes les billes en mouvement
     * Cette methode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
     * La nature du calcul du vecteur acceleration de la bille  est definie dans les classes derivees
     * A ce niveau le vecteur acceleration est mis e zero (c'est e dire pas d'acceleration)
     */

}
