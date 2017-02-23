package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;
import modele.DecorateurAccel;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class RectiligneUniforme extends DecorateurAccel {

    public RectiligneUniforme(Bille b) {
        super(b);
        bille=b;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }

}
