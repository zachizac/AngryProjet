package modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les bords, subissant le frottement dans l'air et subissant l'attraction des autres billes
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtNewtonFrottementRebond extends Bille
{

public BilleMvtNewtonFrottementRebond(Vecteur centre, double rayon,
        Vecteur vitesse, Color couleur)
{
super(centre, rayon, vitesse, couleur);
}




/* (non-Javadoc)
 * @see decorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
 */
@Override
public void gestionAcceleration(Vector<Bille> billes)
{
super.gestionAcceleration(billes);                              // remise e zero du vecteur acceleration
this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));     // contribution de l'acceleration due e l'attraction des autres billes
this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'acceleration due au frottement dans l'air
}




@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonneeCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);

}

}
