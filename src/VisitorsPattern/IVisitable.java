package VisitorsPattern;


/**
 * Created by Zachizac on 04/03/2017.
 * interface IVisitable pour l'implementation du DP visitor
 */
public interface IVisitable {
    //la methode accept qui permet d'activer le visiteur
    void accept(IVisitor visitor);
}
