package exodecorateur_angryballs.maladroit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class EcouteurBoutonArr�ter implements ActionListener
{
AnimationBilles animationBilles;

public EcouteurBoutonArr�ter(AnimationBilles animationBilles)
    {
    this.animationBilles = animationBilles;
    }

@Override
public void actionPerformed(ActionEvent e)
{
this.animationBilles.arr�terAnimation();
}

}
