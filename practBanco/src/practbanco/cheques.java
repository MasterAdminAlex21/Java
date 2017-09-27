package practbanco;
import java.util.*;

public class cheques extends cuenta{
    private double sobregiro,auxsobre;
    private static int id=0;
    //public ArrayList<movimiento> mov;
    
    public cheques(double saldo,double sobre,fecha ap/*,String nom*/){
        super(/*nom,*/ ap, saldo);
        if(sobre<0) System.err.println("ERROR: sobregiro incorrecto");
        else auxsobre=sobregiro=sobre;
        flag=1;
        id+=1;
        //mov=new ArrayList<movimiento>();
    }
    @Override
    public void depositar(double monto){
        if(monto<0) System.err.println("ERROR: saldo incorrecto");
        else{
            if(sobregiro<auxsobre){
                double i=auxsobre-sobregiro;
                sobregiro=auxsobre;
                
                super.depositar(monto-i);
                mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto+"||"+sobregiro));
            }else{
                mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),1,""+monto+"||"+sobregiro));
                super.depositar(monto);
            }
            
        }
    }
    
    @Override
    public void retirar(double ret){
    if(ret>super.consultar()+sobregiro || (ret>sobregiro && super.consultar()==0)){
        System.err.println("ERROR: no hay suficiente saldo");
    }else{ 
        if(ret<super.consultar()){
        super.retirar(ret);
         mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),2,""+this.cad()));
    }else if(ret<sobregiro && super.consultar()==0){
        sobregiro-=ret;
         mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),2,""+this.cad()));
    }else{
        double aux;
        aux=super.consultar()-ret;
        super.retirar(super.consultar());
        sobregiro-=aux;
         mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),2,""+this.cad()));
    }
       
    }
    }
    
    @Override
    public double consultar(){
        mov.add(new movimiento(new fecha((int)(Math.random()*31),(int)(Math.random()*12),1999),0,""+super.consultar()));
        return super.consultar();
    }
    
       //
    @Override
    public String toString(){
     return "CUENTA DE CHEQUES:\nSaldo: $"+super.consultar()+"\nSobregiro: $"+sobregiro+"\n";   
    }
    
    private String cad(){
        return super.consultar()+"||"+sobregiro;
    }
    /*
     public ArrayList<movimiento>retmov(){
        return mov;
    }*/
}//fin clase