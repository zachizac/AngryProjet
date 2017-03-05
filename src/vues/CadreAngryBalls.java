package vues;

import java.awt.*;
import java.util.Vector;

import ObserverPattern.Observable;
import ObserverPattern.Observer;
import modele.Bille;


import outilsvues.EcouteurTerminaison;

import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrele (arret du programme, lancer les billes, arreter les billes) 
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class CadreAngryBalls extends Frame implements VueBillard
{
TextField presentation;
Billard billard;
//public Button lancerBilles, arreterBilles;
    public ViewButton lancerBilles,arreterBilles;
Panel haut, centre, bas;

EcouteurTerminaison ecouteurTerminaison;


public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException
{

super(titre);
Outils.place(this, 0.33, 0.33, 0.5, 0.5);
this.ecouteurTerminaison = new EcouteurTerminaison(this);

//ligne pour que la frame ne fasse pas les repaints non souhait�
this.setIgnoreRepaint(true);

this.haut = new Panel(); this.haut.setBackground(Color.LIGHT_GRAY);
this.add(this.haut,BorderLayout.NORTH);

this.centre = new Panel();
this.add(this.centre,BorderLayout.CENTER);

this.bas = new Panel(); this.bas.setBackground(Color.LIGHT_GRAY);
this.add(this.bas,BorderLayout.SOUTH);

this.presentation = new TextField(message, 100); this.presentation.setEditable(false);
this.haut.add(this.presentation);

this.billard = new Billard(billes, this);
this.add(this.billard);

this.lancerBilles = new ViewButton(new Button("lancer les billes"));
//this.lancerBilles.bouton = new Button("lancer les billes");
    this.bas.add(this.lancerBilles.bouton);

    this.arreterBilles=new ViewButton(new Button("arreter les billes"));
//this.arreterBilles.bouton = new Button("arreter les billes");
    this.bas.add(this.arreterBilles.bouton);

}

public double largeurBillard() 
{
return this.billard.getWidth();
}

public double hauteurBillard()
{
return this.billard.getHeight();
}

    @Override
//    public void miseAJour() {        this.billard.repaint();
//    }
    /**
     * methode miseAJour redefinie pour l'affichage actif
     */
    public void miseAJour() {
        this.billard.myRenderingLoop();
    }

    @Override
    public void montrer() {
        this.setVisible(true);
    }


}