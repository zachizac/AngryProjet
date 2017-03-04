package vues;

import java.awt.*;
import java.awt.image.BufferStrategy;
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
Frame f;

    public Billard(Vector<Bille> billes, Frame f)
    {
        this.billes = billes;
        this.f = f;
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

    public void myRenderingLoop()
    {
        int i;

        //while (true) {
        Graphics g = this.getGraphics();
        DessineVisitor visitor = new DessineVisitor(g);

        for ( i = 0; i < this.billes.size(); ++i) {
            this.billes.get(i).accept(visitor);
        }

        g.dispose();

        //}
    }

    
 
}
