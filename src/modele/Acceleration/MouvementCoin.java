package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Olivier on 19/03/2017.
 */
public class MouvementCoin extends Decorateur {

    Vecteur v= new Vecteur(0.00000025,0.0000025);
    /**
     * Constructeur de mouvement rectiligne uniforme
     * @param b bille subissant ce mouvement
     */
    public MouvementCoin(Bille b) {
        super(b);
        bille=b;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        Vecteur v1= new Vecteur(v.x+0.00000025,v.y+0.0000025);
        v=v1;
        bille.getAcceleration().set(v1);
    }

    @Override
    public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur) {
        bille.collisionContour(abscisseCoinHautGauche,ordonneeCoinHautGauche,largeur,hauteur);
    }
}
