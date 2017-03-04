package vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import VisitorsPattern.DessineVisitor;
import modele.Bille;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class Billard extends Canvas
{
Vector<Bille> billes;
    public Billard(Vector<Bille> billes)
    {
this.billes = billes;
    }
    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics)
    {
    int i;
    DessineVisitor visitor = new DessineVisitor(graphics);
    
    for ( i = 0; i < this.billes.size(); ++i)
        this.billes.get(i).accept(visitor);
        //this.billes.get(i).dessine(graphics);
    
    //System.out.println("billes dans le billard = " + billes);
    }

    
 
}
