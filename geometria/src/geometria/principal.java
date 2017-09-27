package geometria;
import java.util.*;
import java.math.*;

public class principal{
    public static Scanner leer=new Scanner(System.in);
    public static Rect dib=new Rect();
    public static void main(String args[]){
        punto a1,b1;
        int x,y;
        rectangulo r1,r2;
        punto ale=new punto("aleat",(int)(Math.random()*20),(int)(Math.random()*20));
        //operaciones con puntos
        
        System.out.print("operaciones con puntos:\ningrese cordenadas punto p:\nx: ");
        x=leer.nextInt();
        System.out.print("y: ");
        y=leer.nextInt();
        a1=new punto("p",x,y);
        
        System.out.print("\nq: \nx: ");
         x=leer.nextInt();
        System.out.print("y: ");
        y=leer.nextInt();
        b1=new punto("q",x,y);
        
        System.out.println("\n"+a1+"\n"+b1);
        
        System.out.println("Distancia entre los puntos: "+a1.distancia(b1));
        System.out.println("Distancia del origen a "+a1+": "+a1.distancia());
        System.out.println("Distancia del origen a "+b1+": "+b1.distancia());
        
        System.out.println("Cuadrante de "+a1+": "+a1.cuadrante());
        System.out.println("Cuadrante de "+b1+": "+b1.cuadrante());
        
        //operaciones con el rectangulo
        System.out.println("ingrese coordenadas del rectangulo 1:\ninicio: ");
        System.out.print("x: ");
        x=leer.nextInt();
        System.out.print("y: ");
        y=leer.nextInt();
        a1=new punto("p",x, y);
        System.out.print("\nfinal: \nx:");
        x=leer.nextInt();
        System.out.print("y: ");
        y=leer.nextInt();
        b1=new punto("q",x, y);
        r1=new rectangulo("r1", a1, b1);
        
        int x2,y2;
        
        System.out.println("ingrese coordenadas del rectangulo 2:\ninicio: ");
        System.out.print("x: ");
        x=leer.nextInt();
        System.out.print("y: ");
        y=leer.nextInt();
        System.out.print("\nfinal: \nx:");
        x2=leer.nextInt();
        System.out.print("y: ");
        y2=leer.nextInt();
        
        r2=new rectangulo("r2",x, y, x2, y2);
        
        rectangulo union,inter;
        
        union=r1.union(r2);
        inter=r2.interseccion(r2);
        
        System.out.println("union: "+union);
        System.out.println("interseccion: "+inter);
        
        dib.obtenUnion(r1, r2, union, inter);
        dib.setVisible(true);
        
        
        
        if(r1.estaAdentro(ale)) System.out.println("el punto "+ale+" esta adentro del rectangulo "+r1);
        else System.out.println("El punto "+ale+" esta fuera del rectangulo " +r1);
        if(r2.estaAdentro(ale)) System.out.println("el punto "+ale+" esta adentro del rectangulo "+r2);
        else System.out.println("El punto "+ale+" esta fuera del rectangulo "+r2);
        
        if(r1.comparar(r2)==0) System.out.println("El rectangulo "+r2+" es igual al rectangulo "+r1);
        else if(r1.comparar(r2)==1) System.out.println("el rectangulo " +r2+" es menor al rectangulo "+r1);
        else System.out.println("el rectangulo "+r2+" es mayor al rectangulo "+r1);
    }
}