package banco;

import java.util.*;

public abstract class cuenta{
    protected double saldo;
    protected fecha apertura;
    protected int flag;
    protected String nombre;
    protected static int cta=0;
    protected int idcta=0;
    protected movs m;
    
    public cuenta(){
        apertura=new fecha(1, 1, 1970);
        saldo=0;
        
    }
    
    public String aper(){
        if(flag==0) return "Ahorros: "+apertura;
        else if(flag==1) return "Cheques: "+apertura;
        else return "Credito: "+apertura;
    }
   // public abstract String leer();
    public abstract double consultar(fecha f);
    public abstract void depositar(double monto,fecha f);
    public abstract void retirar(double monto,fecha f);
    
    public int flag(){
     return flag;
    }
    
}//fin clase