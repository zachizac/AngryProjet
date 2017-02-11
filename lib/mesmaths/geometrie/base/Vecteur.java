package mesmaths.geometrie.base;

import java.awt.Point;
import java.awt.Polygon;

import mesmaths.MesMaths;

/**
 * Vecteur du plan d�fini par un couple (x,y) o� x et y sont des r�els quelconques
 * 
 * 
 * */
public class Vecteur
{
/**
 * Le vecteur nul (0,0)
 * 
 * */
public static final Vecteur VECTEURNUL = new Vecteur(0,0);
public double x,y;

/**
 * @param x
 * @param y
 */
public Vecteur(double x, double y)
{
this.x = x;
this.y = y;
}

/**
 * cr�e le vecteur nul (0,0)
 */
public Vecteur(){this.x = this.y = 0;}

/**
 * 
 * classique constructeur de copie
 * 
 * */
public Vecteur(Vecteur v){this(v.x,v.y);}

/**
 * @return une copie de this, physiquement ind�pendante de this (c'est-�-dire que la copie ne partage pas d'espace m�moire avec this) 
 * */
public Vecteur copie() { return new Vecteur(this);}

public void set(Vecteur v) 
{
x = v.x; 
y = v.y;
}

/**
 * cr�e et renvoie un vecteur � coordonn�es (x,y) al�atoires telles que 
 * 
 * xMin <= x <= xMax et yMin <= y <= yMax
 * 
 * 
 * */
public static Vecteur creationAleatoire(double xMin, double yMin, double xMax, double yMax)
{
return new Vecteur(MesMaths.creationAleatoire(xMin, xMax),MesMaths.creationAleatoire(yMin, yMax));
}

/**
 * @param string respectant le format " ( nombre r�el , nombre r�el )"
 * c'est le m�me format que celui du r�sultat de toString() 
 * Accepte un nombre quelconque d'espaces de part et d'autre des symboles '('  et ',' et  ')'
 * 
 * */
public Vecteur(String string)
{
int p0 = string.indexOf('(');
int p1 = string.indexOf(',');
int p2 = string.indexOf(')');
String sX, sY;

sX = string.substring(1+p0, p1).trim();
sY = string.substring(1+p1, p2).trim();

this.x = Double.parseDouble(sX);
this.y = Double.parseDouble(sY);
}


/**
 * 
 * @return  this + u
 * 
 * */

public Vecteur somme(Vecteur u) {return new Vecteur(this.x+u.x,this.y+u.y);}


/**
 * 
 * @return  this - u
 * 
 * */

public Vecteur difference(Vecteur u) {return this.somme(u.oppose());}



/**
 * 
 * @return  u - v
 * 
 * */

public static Vecteur difference(Vecteur u, Vecteur v){return u.difference(v);}



/**
 * 
 * @return a * u + b * v
 * 
 * */
public static Vecteur combinaisonLineaire(double a, Vecteur u, double b, Vecteur v)
{
return new Vecteur(a * u.x + b * v.x,
                   a * u.y + b * v.y);
}

/**
 * r�alise this = this + u
 * 
 * */
public void ajoute(Vecteur u)   { this.x += u.x; this.y += u.y;}

/**
 * r�alise this = this - u
 * 
 * */
public void retire(Vecteur u)   { this.x -= u.x; this.y -= u.y;}

/**
 * r�alise this = r * this
 * 
 * */
public void multiplie(double r) { this.x *= r;   this.y *=r;}

/**
 * 
 * @return -this
 * 
 * */
public Vecteur oppose()
{
return new Vecteur(-x,-y);
}

/**
 * 
 * @return r * this
 * 
 * */
public Vecteur produit(double r)
{
return new Vecteur(r*this.x,r*this.y);
}

public double produitScalaire(Vecteur v)
{
return this.x*v.x + this.y*v.y;
}

public static double produitScalaire(Vecteur u, Vecteur v) {return u.produitScalaire(v);}



/**
 * calcule et renvoie le carr� de la norme euclidienne de this, c-�-d (x*x + y*y)
 * 
 * */

public double normeCarree()
{
return this.produitScalaire(this);
}

/**
 * calcule et renvoie la norme euclidienne de this, c-�-d (x*x + y*y)^(1/2)
 * 
 * */
public double norme()
{
return Math.sqrt(this.normeCarree());
}

public Point toPoint()
{
return new Point((int)x,(int)y); 
}

public double determinant(Vecteur v)
{
return this.x * v.y - this.y * v.x;
}

public static double determinant(Vecteur u, Vecteur v) {return u.determinant(v);}

/**
 * calcule et renvoie la valeur de l'angle orient� (u,v) en rad
 * 
 * */
public static double angleOriente(Vecteur u, Vecteur v)
{
double normeU, normeV;
normeU = u.norme(); normeV = v.norme();
double sinAngle = Vecteur.determinant(u,v)/(normeU*normeV);
double cosAngle = Vecteur.produitScalaire(u,v)/(normeU*normeV);

return Math.atan2(sinAngle,cosAngle);
}

public static Polygon toPolygon( Vecteur [] tv)
{
int tx[];
int ty[];
int l = tv.length;

tx = new int[l];
ty = new int[l];

int i;
for ( i = 0; i < l; ++i)
    {
    tx[i] = (int)(tv[i].x);
    ty[i] = (int)(tv[i].y);
    }

return new Polygon(tx,ty,l);
}

/**
 * @return le r�sultat par la rotation de +PI/2 de this
 * 
 * */
public Vecteur rotationQuartDeTour()
{
return new Vecteur(-y,x);
}

/**
 * fournit une base orthornorm�e directe associ�e � this
 * base[0] est un vecteur unitaire colineaire et  de meme sens que this
 * et base[1] est tel que base[1] soit le r�sultat de la rotation d'angle de +PI/2 par rapport � base[0]
 *  
 * */
public Vecteur[] base()
{
Vecteur [] t= new Vecteur[2];

double d = this.norme();
t[0] = this.produit(1/d);
t[1] = t[0].rotationQuartDeTour();
return t;
}

/**
 * @return this sous forme textuelle : "( abscisse, ordonn�e)"
 * */
public String toString()
{
return "( " + this.x + ", " + this.y + ")";
}

/**
 * calcule et renvoie le r�sultat de la multiplication au sens des nombres complexes de this par v
 * 
 * */
public Vecteur produitComplexe(Vecteur v)
{
return new Vecteur(x*v.x - y*v.y,x*v.y + y*v.x); 
}

}
