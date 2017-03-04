package VisitorsPattern;

import modele.Bille;

import java.awt.*;

/**
 * Created by Zachizac on 04/03/2017.
 */
public class DessineVisitor implements IVisitor {

    Graphics g;

    /**
     * constructeur du visitor qui prend un parametre pour l'affichage
     * @param graphics
     */
    public DessineVisitor(Graphics graphics){ this.g = graphics; }
    public DessineVisitor(){};

    public void setGraphics(Graphics g){ this.g=g;}

    /**
     * Anciennement methode dessine presente dans la classe bille et qui affiche les billes sur le billard
     * remplacer par un visiteur et donc cette methode visite maintenant la classe bille pour l'affichage
     * independance de la vue et du modele ainsi mieux respectee
     * @param b la bille a afficher
     */
    public void visit(Bille b) {
        int width, height;
        int xMin, yMin;

        xMin = (int) Math.round(b.getPosition().x - b.getRayon());
        yMin = (int) Math.round(b.getPosition().y - b.getRayon());

        width = height = 2 * (int) Math.round(b.getRayon());

        g.setColor(Color.WHITE);
//        g.fillOval(xMin, yMin, width+100, height+100);

        g.setColor(b.getCouleur());
//        g.clearRect(xMin, yMin, width+100, height+100);

        g.fillOval(xMin, yMin, width, height);

        g.setPaintMode();

        g.setColor(Color.CYAN);
        g.drawOval(xMin, yMin, width, height);

//        g.dispose();
    }
}
