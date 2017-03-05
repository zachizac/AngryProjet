package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by Olivier on 05/03/2017.
 */
public class ViewButton extends Observable {
    public Button bouton;

    public ViewButton(Button b) {
        this.bouton = b;

        this.bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
            }
        });
    }
}
