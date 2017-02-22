package modele;

import java.awt.Color;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

/**
 * 
 * Bille rebondissant sur les murs et subissant un mouvement rectiligne uniforme (mouvment en ligne droite e vitesse constante)
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtRURebond extends Bille
{

public BilleMvtRURebond(Vecteur centre, double rayon, Vecteur vitesse,
        Color couleur)
{

}

public void collisionContour(double abscisseCoinHautGauche,
        double ordonneeCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

}

}


