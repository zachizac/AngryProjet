package modele.Collision;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 19/03/2017.
 */
public class Grossissement extends Decorateur{

    double rayonBase;
    boolean inc;
    static double EPSILON = 1.0E-6;
    /**
     * Constructeur de Rebond, une décoration de collision de bille
     * @param b la bille à décorer
     */
    public Grossissement(Bille b){
        super(b);
        bille = b;
        rayonBase = 0;
        inc = true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) { bille.getAcceleration();}

    /**
     * Methode collisionContour qui determine comment une bille reagit a une collision avec le cadre : ici la bille se bloque contre les parois
     * @param abscisseCoinHautGauche
     * @param ordonneeCoinHautGauche
     * @param largeur
     * @param hauteur
     */
    @Override
    public void collisionContour(double abscisseCoinHautGauche,
                                 double ordonneeCoinHautGauche, double largeur, double hauteur)
    {
        if(rayonBase != 0 && this.getRayon()!=0.0){
            rayonBase = this.getRayon();
        }

        if(this.getRayon() >= (2 * rayonBase) && inc){
            inc = false;
        }
        else{
            if(this.getRayon() <= rayonBase && !inc){
                inc = true;
            }
        }


        Vecteur min = new Vecteur(abscisseCoinHautGauche,ordonneeCoinHautGauche);
        Vecteur diago = new Vecteur(largeur, hauteur);
        Vecteur max = min.somme(diago);


        Vecteur coins[] = new Vecteur[5];

        coins[0] = min;         // le coin haut gauche du rectangle d�fini par le composant
        coins[1] = new Vecteur(max.x,min.y);
        coins[2] = max;
        coins[3] = new Vecteur(min.x, max.y);
        coins[4] = coins[0];                    // pour refermer le contour !

        int i;
        for ( i = 1; i < coins.length; ++i)
            if (collisionBilleSegmentAvecRebond(position, rayon, vitesse, coins[i-1], coins[i])) {
                if (inc) this.incRayon(1);
                else this.incRayon(-1);
                return;
            }

        return;


        //Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
        //Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);
    }

    static boolean collisionBilleSegmentAvecRebond( Vecteur position, double rayon, Vecteur vitesse, Vecteur P0, Vecteur P1)
    {
        Vecteur[] base = Geop.base( P0,  P1);
        Vecteur I = base[0];
        Vecteur J = base[1];

        double d = position.difference(P0).produitScalaire(J);

        if (d <= rayon) // il y a collision entre la bille (position,rayon) et le segment [P0P1]
        {                                                            ////System.err.println("intersection avec : "+ P0 +" et "+ P1 );


            vitesse.set( Geop.reflechi( vitesse, I, J));                    ////System.err.println("v r�fl�chi = " + vitesse);

            double  d1;


            d1 = rayon + EPSILON;

            if (vitesse.norme() < EPSILON) // choc mou
            {                                                                         ////System.err.println("choc mou au bord");
                double t = d1 - d;
                position.ajoute(J.produit(t));
            }
            else                                     // choc �lastique
            {
                double deltaT = (d1 - d) / vitesse.produitScalaire(J);
                position.ajoute(vitesse.produit(deltaT));
            }
            return true;
        } // il y a collision

        else                // il n'y a pas de collision entre la bille et le bord
            return false;
    }                           // collisionBilleSegmentAvecRebond
}

