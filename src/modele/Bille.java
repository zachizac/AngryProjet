package modele;

import java.awt.*;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;


/**
 * Cas general d'une bille de billard
 */
public abstract class Bille {
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
     * <p>
     * modifie le vecteur position et le vecteur vitesse
     * <p>
     * laisse le vecteur acceleration intact
     * <p>
     * La bille subit par defaut un mouvement uniformement accelere
     */
    public void deplacer(double deltaT) {
        Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
    }

    /**
     * gestion de l'eventuelle  collision de cette bille avec les autres billes
     * <p>
     * billes est la liste de toutes les billes en mouvement
     * <p>
     * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
     *
     * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
     * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes
     */
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return OutilsBille.gestionCollisionBilleBille(this, billes);
    }

    public abstract void gestionAcceleration(Vector<Bille> billes);

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);


    public void dessine(Graphics g) {
        int width, height;
        int xMin, yMin;

        xMin = (int) Math.round(position.x - rayon);
        yMin = (int) Math.round(position.y - rayon);

        width = height = 2 * (int) Math.round(rayon);

        g.setColor(couleur);
        g.fillOval(xMin, yMin, width, height);
        g.setColor(Color.CYAN);
        g.drawOval(xMin, yMin, width, height);
    }


    public String toString() {
        return "centre = " + position + " rayon = " + rayon + " vitesse = " + vitesse + " acceleration = " + acceleration + " couleur = " + couleur + "clef = " + clef;
    }

//----------------- classe Bille -------------------------------------
}

