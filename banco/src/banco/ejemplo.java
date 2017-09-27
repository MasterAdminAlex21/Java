package banco;
import java.util.*;

public class ejemplo{
    public static void main(String args[]){
        //cliente yo=new cliente("yo meregues");
        /*yo.establecerNumcuenta("023321");
        yo.establecerCuenta(new cuenta(5000));
        System.out.println(yo.toString());
        
        ArrayList<cliente> lista=new ArrayList<cliente>();
        lista.add(yo);
        System.out.println("\narray:\n"+lista);
        */
        
        //herencia
        //ArrayList<cuenta> ctas;
        //ctas=
        cliente nvo=new cliente("soi io",new ArrayList<cuenta>());
        ahorros ca=new ahorros(1000,1);
        System.out.println("ahorros: "+ca.consultar());
        //System.out.println(ca);
                
                
                
        cheques uno=new cheques(1000, 500);
        System.out.println("saldo: $"+uno.consultar()+"\nsobregiro: $"+uno.consultarSobregiro());
        uno.retirar(1200);
        System.out.println("se retiran 1200 \nsaldo: $"+uno.consultar()+"\nsobregiro: $"+uno.consultarSobregiro());
        uno.retirar(300);
        System.out.println("se retiran 300 \nsaldo: $"+uno.consultar()+"\nsobregiro: $"+uno.consultarSobregiro());
        
        
        
        //aqui empieza lo chido xdxdxd
        
        
        nvo.agregarCuenta(ca);
        nvo.agregarCuenta(uno);
        cuenta x=nvo.retCuenta(1);
        int i=0;
        while(i<nvo.retTam()){
        System.out.println("\n"+nvo.retCuenta(i)+"\nflag: "+nvo.retCuenta(i).flag());
        i+=1;
        }
        
        //System.out.println(nvo);
    }
    
}