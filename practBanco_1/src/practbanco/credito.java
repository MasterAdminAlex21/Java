package practbanco;

import java.util.ArrayList;

public class credito extends cuenta{
    private double tasa,deficit;
    private static int id=0;
    //public ArrayList<movimiento> mov;
    
    public credito(double saldo,double tasa/*,String nombre*/,fecha ap){
        super(/*nombre,*/ap,saldo);
        if(tasa>1 || tasa<0) System.err.println("ERROR: porcentaje de tasa incorrecto");
        else{
            this.tasa=tasa;
            id+=1;
            flag=2;
            //mov=new ArrayList<movimiento>();
        }
    }
    
    @Override
    public void depositar(double monto){
        if(deficit==0){
            super.depositar(monto);
            mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto));
        }else{
            if(monto<deficit) {
                deficit-=monto;
                mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto));
            }
            else if(monto==deficit) {
                deficit=0;
                mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto));
            }
            else{
                double aux;
                aux=monto-deficit;
                deficit-=deficit;
                super.depositar(aux);
                mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto));
            }
            
        }
    }
    
    @Override
    public void retirar(double monto){
        if(monto>super.consultar()){
            double aux;
            aux=monto-super.consultar();
            super.retirar(super.consultar());
            deficit+=aux;
            mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),2,""+monto));
        }
        else{
                super.retirar(monto);
                mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),2,""+monto));
        }
        
    }
    
    @Override
    public double consultar(){
        mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),0,""+super.consultar()));
        return super.consultar();
    }
    
    @Override
    public String toString(){
        return "CUENTA DE CREDITO:\nSaldo: $"+super.consultar()+"\nDéficit: $"+deficit+"\nTasa de interes: "+(tasa*100)+"%\n";
    }
    /*
     public ArrayList<movimiento> retmov(){
        return mov; 
    }*/
}//fin clase