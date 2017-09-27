package banco;



public class cheques extends cuenta{
    private double sobregiro;
    public int id;
    
    public cheques(double saldo, double sobgir){
    super(saldo,0);
    sobregiro=sobgir;
    }
    
    @Override
    public double consultar(){
        return super.consultar();
        
    }
    
    public double consultarSobregiro(){
    return sobregiro;
    }
    
    @Override//revisar esto
    public void retirar(double ret){
    if(ret>(super.consultar()+sobregiro)){
        
        System.err.println("\nla cantidad es mayor al saldo ");
        
    }
    else{
        
        if(super.consultar()>=ret){
            super.retirar(ret);
        }else if (super.consultar()==0 && ret<sobregiro){
            sobregiro-=ret;
        }else{
            int cont=0;
            while(super.consultar()!=0){
                super.retirar(1);
                cont+=1;
            }
            //sobregiro=cont;
            sobregiro-=(ret-cont);
        }
        
    }
    }
    
    @Override 
    public String toString(){
        return "saldo: "+super.consultar()+"\nsobregiro: "+sobregiro;
    }
    
}//fin clase