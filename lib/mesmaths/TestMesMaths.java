package mesmaths;

public class TestMesMaths
{

/**
 * @param args
 */
public static void main(String[] args)
{
double A,B,C;

A = 2; B = -22; C = 56; // Ax^2 +Bx+C = 2*(x-4)*(x-7)

double x [] = MesMaths.resoudre(A, B, C);

int j;

for (j = 0; j < x.length; ++j)
    System.out.println(x[j]);

double a0, a1, a2, a3;

a0 = -48;
a1 = 52;
a2 = -18;
a3 = 2; // les z�ros sont 2, 3 et 4

/*
a0 = -4;
a1 = 2;
a2 = -4;
a3 = 2; // le z�ro est 2
*/

double [] t = MesMaths.resoutEquationDegre3(a0, a1, a2, a3);

int i;

for ( i = 0; i < t.length; ++i)
    System.out.println(t[i]);

}

}
