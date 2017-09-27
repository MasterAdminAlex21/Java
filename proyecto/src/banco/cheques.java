package banco;

public class cheques extends cuenta{
     private double sobregiro,auxsobre;
    private static int id=0;
    private int idche;
    //private movs m;
    
    public cheques(String nom,double saldo,double sobre,fecha ap){
        super();
        if(sobre<0) System.err.println("ERROR: sobregiro incorrecto");
        else {
        apertura=ap;
        auxsobre=sobregiro=sobre;
        this.saldo=saldo;
        flag=1;
        id+=1;
        idche=id;
        }
        
        m=new movs(nom);
        cta+=1;
        idcta=cta;
        m.escribir("Cheques "+idcta, new movimientos(ap,"Cheques "+idcta+"\tApertura",""));
    }
    @Override
    public void depositar(double monto,fecha f){
        if(sobregiro<auxsobre && monto>(auxsobre-sobregiro)){
            saldo+=monto-(auxsobre-sobregiro);
            sobregiro=auxsobre;
        }else if(sobregiro<auxsobre && monto<(auxsobre-sobregiro) && sobregiro+monto<=auxsobre){
            sobregiro+=monto;
        }else if(sobregiro==auxsobre){
            saldo+=monto;
        }
        
        m.escribir("Cheques "+idcta, new movimientos(f,"Deposito",""+monto));
    }
    
    @Override
    public void retirar(double monto,fecha f){
        if(monto<=saldo){
            saldo-=monto;
        }else if(saldo==0 && monto<sobregiro){
            sobregiro-=monto;
        }else if(monto<=saldo+sobregiro){
            sobregiro-=(monto-saldo);
            saldo-=saldo;
        }
       m.escribir("Cheques "+idcta, new movimientos(f,"Retiro",""+monto));
    }
    
    @Override
    public double consultar(fecha f){
     m.escribir("Cheques "+idcta, new movimientos(f,"Consulta","saldo: "+saldo+"      sobregiro: "+sobregiro));
        return saldo+sobregiro;
    }
    
    public double consaux(){
     return saldo+sobregiro;
    }
    
       //
    @Override
    public String toString(){
        return "===========\n| CHEQUES |\n===========\nNum. cuenta: "+idcta+"\nSaldo total: $"+consaux()+"\nSaldo: $"+saldo+"\nSobregiro: $"+sobregiro+"\n";
    }
    
    public boolean caduco(fecha f){
     if(f.año()>apertura.año() && f.mes()>=apertura.mes() && f.dia()>=apertura.dia()){
      //caduco
      m.escribir("Cheques "+idcta, new movimientos(new fecha(apertura.dia(),apertura.mes(),apertura.año()+1),"Cuenta caducada","saldo: "+saldo+"      sobregiro: "+sobregiro));
      return true;
     }else{
      return false;
     }
    }
    
    public int id(){
     return idche;
    }
    
    public String leer(){
     return m.imprimir("Cheques "+idcta);
    }
}//fin clase

