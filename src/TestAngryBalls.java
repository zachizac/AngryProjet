
import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

import modele.Acceleration.*;
import modele.Bille;
import modele.BilleNue;
import modele.Collision.Bloque;
import modele.Collision.Grossissement;
import modele.Collision.PasseMuraille;
import modele.Collision.Rebond;
import modele.OutilsBille;
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

        Vecteur p0, p1, p2, p3, p4, p5, p6, v0, v1, v2, v3, v4,v5, v6;    // les positions des centres des billes et les vecteurs vitesse au demarrage.
        // Elles vont etre choisies aleatoirement

//------------------- creation des vecteurs position des billes ---------------------------------

        p0 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
        p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
        p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
        p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
        p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
        p5 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
        p6 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);

//------------------- creation des vecteurs vitesse des billes ---------------------------------

        v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
        v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
        v5 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
        v6 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie e changer ---------------------------------

        billes.add(new RectiligneUniforme(new Rebond(new BilleNue(p0, rayon, v0, Color.red))));
        billes.add(new Pesanteur(new FrottementVisqueux(new Rebond(new BilleNue(p1, rayon, v1, Color.yellow))), new Vecteur(0,0.001)));
        billes.add(new AttractionUniverselle(new FrottementVisqueux(new Rebond(new BilleNue(p2, rayon, v2, Color.green)))));
        billes.add(new RectiligneUniforme(new PasseMuraille(new BilleNue(p3, rayon, v3, Color.cyan))));
        billes.add(new AttractionUniverselle(new Bloque(new BilleNue(p4, rayon, v4, Color.black))));
        billes.add(new MouvementCoin((new Rebond(new BilleNue(p5, rayon, v5, Color.PINK)))));
        billes.add(new Grossissement(new RectiligneUniforme(new BilleNue(p6, rayon, v6, Color.orange))));

//---------------------- ici finit la partie e changer -------------------------------------------------------------

        System.out.println("billes = " + billes);

//-------------------- creation de l'objet responsable de l'animation (c'est un thread separe) -----------------------

        AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- Cre�ation des observateurs -----------------

        EcouteurBoutonLancer ecouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
        EcouteurBoutonArreter ecouteurBoutonArreter = new EcouteurBoutonArreter(animationBilles);

//-------------------------ajoute des observateurs sur les deux boutons observables ------------------------------

        //nous ajoutons les boutons aux observers pour implementer le DP
        cadre.lancerBilles.addObserver(ecouteurBoutonLancer);
        cadre.arreterBilles.addObserver(ecouteurBoutonArreter);

        //creer son collision
        OutilsBille.creeSonCollision();

    }
}
