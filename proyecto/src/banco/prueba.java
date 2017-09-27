package banco;
import java.util.*;
import proyecto.*;

public class prueba{
    public static void main(String args[]){
       hilo h= new hilo();
     cliente a;
     cuenta aux;
     a=new cliente("Yo merengues :v", new ArrayList<cuenta>());
     System.out.println(a);
     a.agregarCuenta(new cheques("Yo merengues",5000, 2000, h.calendario()));
     a.agregarCuenta(new ahorros("Yo merengues",h.calendario(),3000,.1/*,h.calendario()*/));
     a.agregarCuenta(new credito("Yo merengues",3000, .1, h.calendario()));
     a.agregarCuenta(new cheques("Yo merengues",5000, 2000, h.calendario()));
     a.agregarCuenta(new cheques("Yo merengues",5000, 2000, h.calendario()));
     a.agregarCuenta(new cheques("Yo merengues",5000, 2000, h.calendario()));
     try{
         aux=a.obtenerCuenta(0);
         System.out.println(aux);
         aux=a.obtenerCuenta(1);
         System.out.println(aux);
         aux=a.obtenerCuenta(2);
         System.out.println(aux);
         aux=a.obtenerCuenta(3);
         System.out.println(aux);
         
         
     }
     catch(IndexOutOfBoundsException e){
         System.err.println("No existe cuenta\n\n");
     }
     aux=a.obtenerCuenta(0);
     aux.retirar(5000,h.calendario());
     System.out.println(aux);
     aux.depositar(3000,h.calendario());
     System.out.println(aux);
     aux.retirar(4000,h.calendario());
     System.out.println(aux);
     aux.depositar(2000,h.calendario());
     System.out.println(aux);
     System.out.println("saldo: "+aux.consultar(h.calendario()));
     System.out.println("\n\n");
     
     aux=a.obtenerCuenta(2);
     System.out.println(aux);
     aux.retirar(5000,h.calendario());
     System.out.println(aux);
     aux.depositar(3000,h.calendario());
     System.out.println(aux);
     aux.retirar(4000,h.calendario());
     System.out.println(aux);
     aux.depositar(3000,h.calendario());
     System.out.println(aux);
     System.out.println("saldo: "+aux.consultar(h.calendario()));
     System.out.println("\n");
     
        System.out.println(a);
        
        aux=a.obtenerCuenta(0);
        System.out.println(aux.retmov());
        System.out.println();
        aux=a.obtenerCuenta(2);
        System.out.println(aux.retmov());
        
        System.out.println(a.reportarEdosCtas());
     h.stop();
     
    }
}//fin clase