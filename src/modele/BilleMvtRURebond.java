package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

/**
 * 
 * Bille rebondissant sur les murs et subissant un mouvement rectiligne uniforme (mouvment en ligne droite � vitesse constante)
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
super(centre, rayon, vitesse, couleur);

}

@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonn�eCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecRebond( this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);

}

}


