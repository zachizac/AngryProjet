package vues;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Vector;

import VisitorsPattern.DessineVisitor;
import modele.Bille;


/**
 * responsable du dessin des billes
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */
public class Billard extends Canvas {
    Vector<Bille> billes;
    Frame f;
    DessineVisitor visitor = new DessineVisitor();

    public Billard(Vector<Bille> billes, Frame f) {
        this.billes = billes;
        this.f = f;
    }

    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics) {
        int i;

        DessineVisitor visitor = new DessineVisitor(graphics);

        for (i = 0; i < this.billes.size(); ++i)
            this.billes.get(i).accept(visitor);
        for(Bille b : billes){
            b.accept(visitor);
        }
    }

    public void myRenderingLoop() {
        Graphics g = this.getGraphics();
        visitor.setGraphics(g);

        for (Bille b : billes) {
            b.accept(visitor);
        }

        this.repaint();
        g.dispose();

    }
}
