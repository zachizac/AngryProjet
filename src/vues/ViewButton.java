package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by Olivier on 05/03/2017.
 * Classe observable pour l'implementation du DP observer
 */
public class ViewButton extends Observable {
    public Button bouton;

    /**
     * methode de gestion du bouton pour rendre independant la vue du main.
     * @param b le bouton
     */
    public ViewButton(Button b) {
        this.bouton = b;

        //on utilise un actionListener pour traiter l'etat du bouton
        this.bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
            }
        });
    }
}
