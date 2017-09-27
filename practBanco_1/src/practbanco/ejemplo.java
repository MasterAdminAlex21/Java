package practbanco;
import java.util.*;
public class ejemplo{

public static void main(String args[]){
    
    cliente personal;
    personal=new cliente("Yo merengues xD", new ArrayList<cuenta>());
    System.out.println(personal);
    personal.agregarCuenta(new ahorros( new fecha(21, 05, 2000), 1000, .1));
    personal.agregarCuenta(new cheques(5000, 1000, new fecha(10,03,2005)));
    personal.agregarCuenta(new credito(10000,.15,new fecha(30,04,2005)));
    
    cliente otro=new cliente("Otra cuenta feik :v",new ArrayList<cuenta>());
    otro.agregarCuenta(new cheques(10000,2000,new fecha(2,6,1950)));
    System.out.println(personal.obtenerCuenta(0));
    System.out.println(personal.obtenerCuenta(1));
    System.out.println(personal.obtenerCuenta(2));
    System.out.println(personal);
    personal.obtenerCuenta(1).depositar(3000);
    personal.obtenerCuenta(1).consultar();
    System.out.println(otro);
    System.out.println(otro.obtenerCuenta(1));
    
    ArrayList<movimiento> mo=new ArrayList<movimiento>();
    mo=personal.obtenerCuenta(0).mov;
    System.out.println(mo);
    //System.out.println(otro.obtenerCuenta(1));
}    
} 
