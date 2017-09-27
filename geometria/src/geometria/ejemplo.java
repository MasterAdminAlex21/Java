package geometria;
import java.awt.*;
class ejemplo{
    static Rect dib=new Rect();
    static triang tr=new triang();
    public static void main(String args[]){
        punto p=new punto("p", 0,0);
        System.out.println(p);
        punto q=new punto("q",1,3);
        
        //revisar cuando ninguno es mayor ni menor
        
        System.out.println(q);
       // System.out.println("Distancia al origen: "+p.distancia());
        //System.out.println("Distanca entre puntos: "+p.distancia(q) );
        if(p.cuadrante()==0) System.out.println("cuadrante: esta en el origen");
        else System.out.println("cuadrante: "+p.cuadrante());
        
        System.out.println("mayor: "+p.mayor(q));
        System.out.println("menor: "+p.menor(q));
        
        rectangulo a=new rectangulo("r1", 3,2,7,4);
        rectangulo b=new rectangulo("r2",5,3,10,7);
        System.out.println(a);
        
        if(a.estaAdentro(q)) System.out.println("el punto "+q+" esta adentro del rectangulo "+a);
        else System.out.println("Esta fuera del rectangulo");
        if(a.comparar(b)==0) System.out.println("El rectangulo "+b+" es igual al rectangulo "+a);
        else if(a.comparar(b)==1) System.out.println("el rectangulo " +b+" es menor al rectangulo "+a);
        else System.out.println("el rectangulo "+b+" es mayor al rectangulo "+a);
        
        
        rectangulo union=a.union(b);
        rectangulo inter=a.interseccion(b);
        
        //a.moverRect(q, p);
        System.out.println(union);
        dib.obtenUnion(a, b,union,inter);
        dib.setVisible(true);
        triangulo tr1=new triangulo("tr1",0, 0, 2, 1, 1, 2);
        tr.obtenTring(tr1, tr1);
        tr.setVisible(true);
    }
    
} 