package banco;

public class cuenta{
    private/*protected*/ double saldo;
    /*public cuenta(){
    saldo=0;
    
    }*/
    private int flag;
    private fecha apertura;
    public cuenta(double inicial,int bandera){
        if(inicial<0){
            saldo=0;
        }else{
        saldo=inicial;
        }
        flag=bandera;
    }
    
    public cuenta(double inicial,fecha ap,int bandera){
        if(inicial<0){
            saldo=0;
        }else{
        saldo=inicial;
        }
        apertura=ap;
        flag=bandera;
    }
    public double consultar(){
    return saldo;
    }
    public void depositar(double monto){
        saldo+=monto;
    }
    public void retirar(double monto){
        if(monto>saldo){
            System.err.println("\nno se puede retirar esa cantidad");
        }else{
            saldo-=monto;
        }
    }
    public int flag(){
        return flag;
    }
}