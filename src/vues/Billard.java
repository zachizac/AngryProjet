package vues;

import java.awt.*;
import java.util.Vector;

import VisitorsPattern.DessineVisitor;
import modele.Bille;


/**
 * responsable du dessin des billes
 */
public class Billard extends Canvas {

    //il possede deux attributs, les billes cree par le main pour remplir le cadre du billard et le visitor qui permet de dessiner chaque bille
    Vector<Bille> billes;
    DessineVisitor visitor = new DessineVisitor();

    public Billard(Vector<Bille> billes) {
        this.billes = billes;
    }

    /**
     * methode paint classique, elle n'est appelee que lors de la creation du programme pour afficher la premiere fois les billes
     * @param graphics
     */
    @Override
    public void paint(Graphics graphics) {
        //l'attribut visitor est cree avec l'aide d'un nouveau visitor pour gerer le dessin des billes
        visitor = new DessineVisitor(graphics);

        for(Bille b : billes){
            //le visiteur implemente la methode dessine des billes
            b.accept(visitor);
        }
    }

    /**
     * boucle de rendue qui remplace l'appel constant à la méthode repaint. Ainsi nous gardons le contrôle du panel pour dessiner les balles
     */
    public void renderingLoop() {
        //on recupere le graphic grace a la methode getGraphics de awt.
        Graphics g = this.getGraphics();

        //pour eviter la supperposition des balles a chaque iteration, nous plaçon un rectangle blanc recouvrant le panel
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());

        //nous modifions l'attribut du visitor DessineVisitor a g pour pouvoir dessiner les balles
        visitor.setGraphics(g);

        for (Bille b : billes) {
            //nous utilisons le visiteur pour dessiner les balles et assurer une independance du modele.
            b.accept(visitor);
        }

        //ne pas oublier de liberer le graphics.
        g.dispose();
    }
}
