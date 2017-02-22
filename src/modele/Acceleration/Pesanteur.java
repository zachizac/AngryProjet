package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;
import modele.DecorateurAcceleration;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class Pesanteur extends DecorateurAcceleration{

    Vecteur pesanteur;

    /**
     * Constructeur de pesanteur
     * @param b la bille supportant la pesanteur
     */
    public Pesanteur(Bille b, Vecteur pesanteur) {
        bille = b;
        this.pesanteur = pesanteur;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes pour certains type d'acceleration (seulement pour frottement)
     */
    public void gestionAcceleration(Vector<Bille> billes){
        this.getAcceleration().set(Vecteur.VECTEURNUL);                 // remise e zero du vecteur acceleration
        this.getAcceleration().ajoute(this.pesanteur);                  // contribution du champ de pesanteur (par exemple)
    }

}
