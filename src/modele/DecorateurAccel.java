package modele;

import java.util.Vector;

/**
 * Created by MERTZ on 23/02/2017.
 */
public abstract class DecorateurAccel extends Decorateur {

    public DecorateurAccel(Bille b){
        super(b);
    }
    public abstract void gestionAcceleration(Vector<Bille> billes);
}
