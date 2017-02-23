package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;
import modele.Decorateur;
import modele.DecorateurAccel;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class FrottementVisqueux extends DecorateurAccel {

    /**
     * Constructeur de frottementVisqueux
     * @param b la bille subissant ce frottement
     */
    public FrottementVisqueux(Bille b) {
        super(b);
        this.bille=b;
    }

    /**
     * Fonction gestionAcceleration differentes suivant le type d'acceleration
     * @param billes l'ensemble des billes pour certains type d'acceleration
     */
    @Override
    public void gestionAcceleration(Vector<Bille> billes){
//        super.gestionAcceleration(billes);                                                                 // remise e zero du vecteur acceleration
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'acceleration due au frottement dans l'air
    }

}
