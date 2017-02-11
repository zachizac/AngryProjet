package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les murs, subissant un mouvement rectiligne (mouvement en ligne droite) et subissant le frottement dans l'air
 * 
 * Soumis � un vecteur pesanteur
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtPesanteurFrottementRebond extends Bille
{
Vecteur pesanteur;

public BilleMvtPesanteurFrottementRebond(Vecteur position, double rayon,
        Vecteur vitesse, Vecteur pesanteur, Color couleur)
{
super(position, rayon, vitesse, couleur);
this.pesanteur = pesanteur;
}



/* (non-Javadoc)
 * @see decorateur_angryballs.modele.Bille#gestionAcc�l�ration(java.util.Vector)
 */
@Override
public void gestionAcc�l�ration(Vector<Bille> billes)
{
super.gestionAcc�l�ration(billes);          // remise � z�ro du vecteur acc�l�ration
this.getAcc�l�ration().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
this.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'acc�l�ration due au frottement dans l'air
}



@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonn�eCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
}

}
