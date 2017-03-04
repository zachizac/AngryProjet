package VisitorsPattern;

import modele.Bille;

import java.awt.*;

/**
 * Created by Zachizac on 04/03/2017.
 */
public class DessineVisitor implements IVisitor {

    Graphics g;

    public DessineVisitor(Graphics graphics){ this.g = graphics; }

    public void visit(Bille b) {
        int width, height;
        int xMin, yMin;

        xMin = (int) Math.round(b.getPosition().x - b.getRayon());
        yMin = (int) Math.round(b.getPosition().y - b.getRayon());

        width = height = 2 * (int) Math.round(b.getRayon());

        g.setColor(b.getCouleur());
        g.fillOval(xMin, yMin, width, height);
        g.setColor(Color.CYAN);
        g.drawOval(xMin, yMin, width, height);
    }
}
