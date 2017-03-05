package modele;

import java.util.Vector;

/**
 * Created by Zachizac on 21/02/2017.
 * Classe decorateur qui permet l'ajout de decoration sur les billes nues nouvellement crees.
 */
public abstract class Decorateur extends Bille{

    //attribut bille representant la bille a decorer
    protected Bille bille;

    /**
     * constructeur de decorateur de bille
     * @param b la bille a decorer
     */
    public Decorateur(Bille b){
        super(b);
    }

    public void gestionAcceleration(Vector<Bille> billes){
        super.gestionAcceleration(billes);
    };

    public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

}
