package practbanco;

import java.util.ArrayList;

public class cuenta{
    private double saldo;
    private fecha apertura;
    //private String nombre;
    protected int flag;
     protected ArrayList<movimiento> mov;   
     
    public cuenta(String nombre,fecha ap,double saldo){
       // this.nombre=nombre;
        apertura=ap;
        this.saldo=saldo;
        mov=new ArrayList<movimiento>();
    }
    
    public cuenta(fecha ap,double saldo){
        apertura=ap;
        this.saldo=saldo;
        mov=new ArrayList<movimiento>();
    }
    
    public double consultar(){
        //mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),0,""+saldo));
        return saldo;
    }
    
    public void depositar(double monto){
        if(monto<0) System.err.println("Si se va a depositar con numeros negativos, elija la opcion retirar");
        else {
            saldo+=monto;
           // mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto));
        }
    }
    
    public void retirar(double monto){
        if(monto>saldo) System.err.println("El monto es superior al saldo");
        else {
            saldo-=monto;
            //mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),2,""+monto));
        }
    }
    
    public int bandera(){
        return flag;
    }
}//fin clase