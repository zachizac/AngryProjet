import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 *  ICI : IL N'Y A RIEN A CHANGER
 *
 *  */

//public class EcouteurBoutonArreter implements ActionListener
public class EcouteurBoutonArreter implements Observer
{
AnimationBilles animationBilles;

public EcouteurBoutonArreter(AnimationBilles animationBilles)
    {
    this.animationBilles = animationBilles;
    }

//@Override
//public void actionPerformed(ActionEvent e)
//{
//this.animationBilles.arreterAnimation();
//}

    @Override
    public void update(Observable o, Object arg) {
        this.animationBilles.arreterAnimation();
    }
}
