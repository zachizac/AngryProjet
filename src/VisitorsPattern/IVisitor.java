package VisitorsPattern;

import modele.Bille;

/**
 * Created by Zachizac on 04/03/2017.
 * Interface Visitor necessaire a l'implementation du DP visitor
 * definir les methodes visites pour les classes implementant le visiteur
 */
public interface IVisitor {

    /**
     * Methode visit pour la classe bille, cette methode va permettre de creer des visitors pour bille
     * @param b
     */
    void visit(Bille b);
}
