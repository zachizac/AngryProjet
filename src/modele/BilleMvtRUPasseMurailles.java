package modele;

import java.awt.Color;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

/**
 * 
 * Bille traversant les murs et subissant un mouvement rectiligne uniforme (mouvment en ligne droite e vitesse constante)
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleMvtRUPasseMurailles extends Bille
{

/**
     * @param centre
     * @param rayon
     * @param vitesse
     * @param couleur
     */
    public BilleMvtRUPasseMurailles(Vecteur centre, double rayon,
            Vecteur vitesse, Color couleur)
    {
    super(centre, rayon, vitesse, couleur);
    }

@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonneeCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

}

}



