package practbanco;
import java.util.*;

public class ahorros extends cuenta implements impuestos{
    private double tasa;
    private static int id=0;
    //public ArrayList<movimiento> mov;
    //private cuenta ahorro;
    
    public ahorros(/*String nom,*/fecha aper,double saldo,double tasa){
        super(/*nom,*/aper,saldo);
        if(tasa>1 || tasa<0) System.err.println("ERROR: porcentaje de tasa incorrecto");
        else{
            this.tasa=tasa;
            id+=1;
            flag=0;
            //mov=new ArrayList<movimiento>();
        }
    }
    @Override
    public double consultar(){
        pagarISRmensual();
        pagarISRanual();
        mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),0,""+super.consultar()));
      return super.consultar();
    }
    
    public void pagarISRmensual(){
        if(super.consultar()>10000){
            super.retirar(super.consultar()*ISRm);
        }
    }
    
    public void pagarISRanual(){
        if(super.consultar()>50000){
            super.retirar(super.consultar()*ISRa);
        }
    }
    
    @Override
    public void depositar(double monto){
        if(monto<0)System.err.println("ERROR: monto negativo");
        else {
            super.depositar(monto);
            mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto));
        }
    }
    
    //
        @Override
    public String toString(){
        return "CUENTA DE AHORROS: \nSaldo: $"+super.consultar()+"\nTasa de Interes: "+(tasa*100)+"% \nISRm: "+(ISRm*100)+"% \nISRa: "+(ISRa*100)+"% \n";
    }
    /*
     public ArrayList<movimiento>retmov(){
        return mov; 
    }*/
    
}//fin clase