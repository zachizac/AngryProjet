package modele;

import java.awt.*;
import java.util.Vector;

import VisitorsPattern.IVisitable;
import VisitorsPattern.IVisitor;
import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;


/**
 * Cas general d'une bille de billard
 */
public abstract class Bille implements IVisitable {
//----------------- classe Bille-------------------------------------

    protected Vecteur position;   // centre de la bille
    protected double rayon;            // rayon > 0
    protected Vecteur vitesse;
    protected Vecteur acceleration;
    protected int clef;                // identifiant unique de cette bille

    protected Color couleur;

    public static int prochaineClef = 0;

    public static double ro = 1;        // masse volumique

    public Bille(){};

    public Bille(Bille b){
        this.position=b.position;
        this.rayon=b.rayon;
        this.vitesse=b.vitesse;
        this.acceleration=b.acceleration;
        this.couleur=b.couleur;
        this.clef=b.clef;
    }
    public Bille(Vecteur position, double rayon, Vecteur vitesse,
                 Vecteur acceleration, Color couleur){
        this.position = position;
        this.rayon = rayon;
        this.vitesse = vitesse;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.clef = Bille.prochaineClef++;
    }
    /**
     * @return the position
     */
    public Vecteur getPosition() {
        return this.position;
    }


    /**
     * @return the rayon
     */
    public double getRayon() {
        return this.rayon;
    }


    /**
     * @return the vitesse
     */
    public Vecteur getVitesse() {
        return this.vitesse;
    }


    /**
     * @return the acceleration
     */
    public Vecteur getAcceleration() {
        return this.acceleration;
    }

    /**
     *
     * @return the couleur
     */
    public Color getCouleur(){
        return this.couleur;
    }


    /**
     * @return the clef
     */
    public int getClef() {
        return this.clef;
    }


    public double masse() {
        return ro * Geop.volumeSphère(rayon);
    }


    /**
     * mise e jour de position et vitesse e t+deltaT e partir de position et vitesse e l'instant t
     * La bille subit par defaut un mouvement uniformement accelere
     */
    public void deplacer(double deltaT) {
        Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
    }

    /**
     * gestion de l'eventuelle  collision de cette bille avec les autres billes
     * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
     * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes
     */
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return OutilsBille.gestionCollisionBilleBille(this, billes);
    }

   public void gestionAcceleration(Vector<Bille> billes){
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    };

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

    /**
     * methode accept pour implementer le dp visitor
     * @param visitor le visiteur
     */
    public void accept(IVisitor visitor)
    {
        visitor.visit(this);
    }


    public String toString() {
        return "centre = " + position + " rayon = " + rayon + " vitesse = " + vitesse + " acceleration = " + acceleration + " couleur = " + couleur + "clef = " + clef;
    }

//----------------- classe Bille -------------------------------------
}

