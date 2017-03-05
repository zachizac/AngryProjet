package vues;

import java.awt.*;
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
    DessineVisitor visitor = new DessineVisitor();

    public Billard(Vector<Bille> billes) {
        this.billes = billes;
    }

    @Override
    public void paint(Graphics graphics) {
        DessineVisitor visitor = new DessineVisitor(graphics);

        for(Bille b : billes){
            b.accept(visitor);
        }
    }

    public void myRenderingLoop() {
        Graphics g = this.getGraphics();

        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        visitor.setGraphics(g);

        for (Bille b : billes) {
            b.accept(visitor);
        }


        g.dispose();
    }
}
