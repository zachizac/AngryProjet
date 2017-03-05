package vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

/**
 * Created by Olivier on 05/03/2017.
 */
public class ViewButton extends Observable {
    public Button bouton;

    public ViewButton(Button b){
    this.bouton=b;

        this.bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
            }
        });

//        this.bouton.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent me) {
//                System.out.println("COUCOU");
//            }
//        });
    };
}
