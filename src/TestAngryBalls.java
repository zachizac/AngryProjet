import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

import modele.Acceleration.AttractionUniverselle;
import modele.Acceleration.FrottementVisqueux;
import modele.Acceleration.Pesanteur;
import modele.Acceleration.RectiligneUniforme;
import modele.Bille;
import modele.BilleNue;
import modele.Collision.Bloque;
import modele.Collision.PasseMuraille;
import modele.Collision.Rebond;
import vues.CadreAngryBalls;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement different
 * <p>
 * Ideal pour mettre en place le DP decorator
 */
public class TestAngryBalls {

    /**
     * @param args
     */
    public static void main(String[] args) {
//------------------- creation de la liste (pour l'instant vide) des billes -----------------------

        Vector<Bille> billes = new Vector<Bille>();

//---------------- creation de la vue responsable du dessin des billes -------------------------

        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Animation de billes ayant des comportements differents. Situation ideale pour mettre en place le DP Decorator",
                billes);

        cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------


        double xMax, yMax;
        double vMax = 0.1;
        xMax = cadre.largeurBillard();      // abscisse maximal
        yMax = cadre.hauteurBillard();      // ordonnee maximale

        double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais ce n'est pas obligatoire

        Vecteur p0, p1, p2, p3, p4, v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au demarrage.
        // Elles vont etre choisies aleatoirement

//------------------- creation des vecteurs position des billes ---------------------------------

        p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

//------------------- creation des vecteurs vitesse des billes ---------------------------------

        v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
        v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie e changer ---------------------------------

        billes.add(new RectiligneUniforme(new Rebond(new BilleNue(p0, rayon, v0, Color.red))));
        billes.add(new Pesanteur(new FrottementVisqueux(new Rebond(new BilleNue(p1, rayon, v1, Color.yellow))), new Vecteur(0,0.001)));
        billes.add(new AttractionUniverselle(new FrottementVisqueux(new Rebond(new BilleNue(p2, rayon, v2, Color.green)))));
        billes.add(new RectiligneUniforme(new PasseMuraille(new BilleNue(p3, rayon, v3, Color.cyan))));
        billes.add(new AttractionUniverselle(new Bloque(new BilleNue(p4, rayon, v4, Color.black))));

//---------------------- ici finit la partie e changer -------------------------------------------------------------

        System.out.println("billes = " + billes);

//-------------------- creation de l'objet responsable de l'animation (c'est un thread separe) -----------------------

        AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des ecouteurs de boutons qui permettent de contreler (un peu...) l'application -----------------

        EcouteurBoutonLancer ecouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
        EcouteurBoutonArreter ecouteurBoutonArreter = new EcouteurBoutonArreter(animationBilles);

        cadre.lancerBilles.addObserver(ecouteurBoutonLancer);
        cadre.arreterBilles.addObserver(ecouteurBoutonArreter);
//------------------------- activation des ecouteurs des boutons et ea tourne tout seul ------------------------------

//        cadre.lancerBilles.addActionListener(ecouteurBoutonLancer);             // maladroit mais ne changez rien
//        cadre.arreterBilles.addActionListener(ecouteurBoutonArreter);           // maladroit mais ne changez rien

    }
}
