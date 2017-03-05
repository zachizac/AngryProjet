import java.util.Observable;
import java.util.Observer;

public class EcouteurBoutonLancer implements Observer
{
AnimationBilles animationBilles;

public EcouteurBoutonLancer(AnimationBilles animationBilles)
{
this.animationBilles = animationBilles;
}

    /**
     *  Fonction update appeler à chaque fois l'objet Observable notifie la classe
     */
    public void update(Observable o, Object arg) {
        this.animationBilles.lancerAnimation();
    }
}
