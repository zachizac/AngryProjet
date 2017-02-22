package modele.Acceleration;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.Decorateur;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 */
public class RectiligneUniforme extends Decorateur {

    public RectiligneUniforme(Bille b) {
        bille = b;
    }

}
