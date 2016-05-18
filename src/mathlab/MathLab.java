/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathlab;

/**
 *
 * @author Svetlana
 */
public class MathLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        halfDiv(0.7,0.8,0.001);
        System.out.println();
        Newtone(0.7,0.8,0.001);
        System.out.println();
        iter(0.7,0.8,0.001);
    }
    
    public static double f(double x){
        return x+ Math.log(x)-0.5;
    }
    
    static double fi(double x){
        return Math.exp(0.5-x);
    }
    
    public static void halfDiv(double a, double b, double eps){
        double c = 0;
        int i  = 0;
        do{
            i++;
            c = (a+b)/2;
            c = roundResult(c,4);
            System.out.println(i+" "+a+" "+b+" "+f(a)+" "+f(b)+" "+Math.abs(a-b) );
            if(f(a)*f(c)<0){
                b = c;
            } else{
                a = c;
            }
        }while(Math.abs(a-b)>eps);
        
    }
    
    static void Newtone(double a, double b, double eps){
       double m1 = 2.25;
       double x = a;
       int i = 0;
       while(Math.abs(f(x))/m1>eps){
           i++;
           System.out.println(i+" "+x+" "+f(x)+" "+Math.abs(f(x))/m1 );
           x = x - f(x)/(1+1/x);
           x = roundResult(x,4);
       }
    }
    
    static void iter (double a, double b, double eps){
        double q = 0.82;
        double xpred = 0;
        double x = a;
        int i = 0;
        while(Math.abs(x-xpred)>(1-q)*eps/q){
            i++;
            System.out.println(i+" "+x+" "+Math.abs(x-xpred));
            xpred = x;
            x = fi(x);
        }
    }
    
    static double roundResult (double d, int precise) {

        precise = (int) Math.pow(10, precise);
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;
    }
    
    
}

