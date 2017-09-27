package banco;

import java.util.ArrayList;

public class pruebabanco{
    public static void main(String args[]){
        banco ej;
        ej=new banco("Ejemplo", new cliente[0]);
        System.out.println(ej);
        ej.agregarCliente(new cliente("yo mero maromero :v", new ArrayList<cuenta>()));
        System.out.println(ej);
        cliente aux=ej.obtenerCliente(0);
        System.out.println(aux);
        aux.agregarCuenta(new cheques("yo mero maromero :v",5000, 2000, new fecha(21,03,2000)));
        System.out.println("se agrego una cuenta");
        ej.reportarClientes();
        
        ej.agregarCliente(new cliente("otro yo :v",new ArrayList<cuenta>()));
        System.out.println("se agrego otro cliente");
        System.out.println(ej);
        ej.reportarClientes();
        aux=ej.obtenerCliente(1);
        aux.agregarCuenta(new credito("otro yo :v",3000,.1,new fecha(3,10,2001)));
        System.out.println("se agrega una cuenta al 2o cliente");
        ej.reportarClientes();
        System.out.println(ej.obtenerCliente(0)+""+ej.obtenerCliente(0).obtenerCuenta(0)+"\n\n"+ej.obtenerCliente(1)+""+ej.obtenerCliente(1).obtenerCuenta(0));
    }
}//fin clase