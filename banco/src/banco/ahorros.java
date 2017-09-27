package banco;

public class ahorros extends cuenta implements impuestos{
    private double interes;
    //public final int flag=1;
    private int id;
    public ahorros(double saldo, double ti){
        super(saldo,1); //privado
       // super.saldo=saldo; //protegido pero anexar constructor sin argumentos
       if(ti>=1) 
       interes=ti/100;
       else if(ti>0 && ti<1) interes=ti;
    }
    
    @Override
    public double consultar(){
        depositar(super.consultar()*interes);
        return super.consultar();
    }
    
    public void pagarISRmensual(){
        if(super.consultar()>0){
            //saldo=saldo-(saldo*ISRm);
            super.retirar(super.consultar()*ISRm);
        }else{
            System.err.println("ERROR: no hay saldo");
        }
    }
    
    public void pagarISRanual(){
        if(super.consultar()>0){
            //saldo=saldo-(saldo*ISRa);
            super.retirar(super.consultar()*ISRa);
        }else{
            System.err.println("ERROR: no hay saldo");
        }
    }
    
    @Override
    public String toString(){
        return "saldo: "+super.consultar()+"\ninteres: "+interes;
    }
    
    
}//fin clase