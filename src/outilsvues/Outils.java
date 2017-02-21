package outilsvues;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

/**
 * Quelques outils pratiques dans des applis GUI
 * */
public class Outils
{

/**
 * 
 * place frame et calcule sa taille en fonction des dimensions de l'�cran. 
 * Soient L et H respectivement la largeur et la hauteur de l'�cran
 * 
 * Alors place l'origine de frame en (Ox*L,Oy*H) et la largeur de frame sera L*largeur et la hauteur de frame sera 
 * H*hauteur   
 * 
 * 
 * */
public static void place(Frame frame, double Ox, double Oy, double largeur, double hauteur)
{
Toolkit toolkit = Toolkit.getDefaultToolkit();

Dimension screenSize = toolkit.getScreenSize();

frame.setLocation((int)(screenSize.width*Ox),(int)(screenSize.height*Oy));
frame.setSize((int)(screenSize.width*largeur), (int)(screenSize.height*hauteur));
}

}
