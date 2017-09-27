package banco;
import java.util.*;

public class cliente{
    private String nombre;
    private ArrayList<cuenta> cuentas;
    private int numcuentas;
    private String numcuent;
    
    private cuenta cuentacli;
    private String numCuenta;
    
    
    public cliente(String nom){
        nombre=nom;
        cuentas=new ArrayList<cuenta>();
    }
    
    public cliente(String nom,ArrayList<cuenta> ctas){//arreglar esto
        nombre=nom;
        cuentas=ctas;
    }
    
    public void establecerCuenta(cuenta Cuenta){
        cuentacli=Cuenta;
    }
    public void establecerNumcuenta(String numcta){
        numCuenta=numcta;
    }
    public String obtenerNombre(){
    return nombre;
    }
    
    public cuenta obtenerCuenta(){
    return cuentacli;
    } 
    public String obtenernumcuen(){
    return numCuenta;
    }
    
    @Override
    public String toString(){
        return "\n"+nombre+"\n"+numCuenta+"\n"+cuentacli.consultar();
    }
    
    
    public void agregarCuenta(cuenta a){
        cuentas.add(a);
        //System.out.println(a);
    }
    
    public void agregarCuenta(cuenta a, int i){
        cuentas.add(i, a);
    }
    
    public cuenta retCuenta(int i){
        return cuentas.get(i);
    }
    
    public int retTam(){
        return cuentas.size();
    }
    
}