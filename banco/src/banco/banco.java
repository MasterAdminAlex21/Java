package banco;
import java.util.*;

public class banco{
    private ArrayList<cliente> clientes;
    private static int numclientes=0;
    
    public banco(){
        clientes=new ArrayList<cliente>();
        
    }
    
    void agregaClientes(String nombre, String numcta){
    cliente cli=new cliente(nombre);
    cli.establecerNumcuenta(numcta);
    numclientes+=1;
    cli.establecerCuenta(new cuenta(0,-1));
    clientes.add(cli);
    }
    
    public int obtenerNumClientes(){
        return numclientes;
    }
    
    public cliente obtenerCliente(int index){
        if(index>clientes.size()){
            System.err.println("Hay menos clientes que el que se busca");
            return null;
        }else if(index<0){
            System.err.println("No puede haber menos de 0 clientes");
            return null;
        }else{
        return clientes.get(index);
        }
    }
    
    public void imprimirClientes(){
        /*for(int i=1;i<clientes.size();i++){
            cliente aux;
            aux=clientes.get(i);
            System.out.println(aux.toString());
        }*/
        
        System.out.println(clientes);
    }

}