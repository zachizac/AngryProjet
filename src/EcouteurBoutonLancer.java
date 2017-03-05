import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 *  ICI : IL N'Y A RIEN A CHANGER
 *
 *  */
//public class EcouteurBoutonLancer implements ActionListener
public class EcouteurBoutonLancer implements Observer
{
AnimationBilles animationBilles;

/**
 * @param animationsBilles
 */
public EcouteurBoutonLancer(AnimationBilles animationBilles)
{
this.animationBilles = animationBilles;
}



//@Override
//public void actionPerformed(ActionEvent arg0)
//{
//this.animationBilles.lancerAnimation();
//}

    @Override
    public void update(Observable o, Object arg) {
        this.animationBilles.lancerAnimation();
    }
}
