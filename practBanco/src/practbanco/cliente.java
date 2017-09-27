package practbanco;

import java.util.*;

public class cliente{
    
    private String nombre,numcuenta;
    private int numctas;
    private ArrayList<cuenta> cuentas;
    public static int id;
    
    
    public cliente(String nom,ArrayList<cuenta> ctas){
        nombre=nom;
        numcuenta=""+((int)(Math.random()*Math.pow(10, 6)));
        cuentas=ctas;
        numctas=0;
        id+=1;
    }
    
    public void agregarCuenta(cuenta cta){
        cuentas.add(cta);
        numctas+=1;
    }
    
    public cuenta obtenerCuenta(int i){
        int j=0;
        for(;j<cuentas.size();j++){
            if(cuentas.get(j).flag==i){
                //return cuentas.get(i);
                break;
            }
        }
        if(j==cuentas.size())return null;
        else return cuentas.get(j);
    }
    
    @Override
    public String toString(){
        return "Cliente: "+nombre+"\nNumero de cuenta: "+numcuenta+"\nNumero de cuentas: "+numctas+"\n";
    }
    
    public String nombre(){
        return nombre;
    }
    
    public boolean exiscta(int i){
        cuenta aux;
        aux=this.obtenerCuenta(i);
        if(aux==null) return false;
        else return true;
    }
    
}//fin clase