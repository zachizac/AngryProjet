package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;
import modele.DecorateurAccel;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class Pesanteur extends Decorateur{

    Vecteur pesanteur;

    /**
     * Constructeur de pesanteur
     * @param b la bille supportant la pesanteur
     */
    public Pesanteur(Bille b) {
        super(b);
        bille = b;
        this.pesanteur = bille.getAcceleration();
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes pour certains type d'acceleration (seulement pour frottement)
     */
    @Override
    public void gestionAcceleration(Vector<Bille> billes){
        super.gestionAcceleration(billes);                              // remise e zero du vecteur acceleration
        bille.getAcceleration().ajoute(this.pesanteur);                  // contribution du champ de pesanteur (par exemple)
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        bille.collisionContour(abscisseCoinHautGauche,ordonneeCoinHautGauche,largeur,hauteur);
    }

}
