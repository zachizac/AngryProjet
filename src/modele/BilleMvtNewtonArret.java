package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille s'arr�tant sur les bords et subissant l'attraction des autres billes
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleMvtNewtonArret extends Bille
{


public BilleMvtNewtonArret(Vecteur position, double rayon, Vecteur vitesse,
        Color couleur)
{
super(position, rayon, vitesse, couleur);
}

/* (non-Javadoc)
 * @see decorateur_angryballs.modele.Bille#gestionAcc�l�ration(java.util.Vector)
 */
@Override
public void gestionAcc�l�ration(Vector<Bille> billes)
{
super.gestionAcc�l�ration(billes);                              // remise � z�ro du vecteur acc�l�ration
this.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes));     // contribution de l'acc�l�ration due � l'attraction des autres billes
}

@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonn�eCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonn�eCoinHautGauche, hauteur);
}

}
